GT.commonTask = (function(){

    var BUILD_STATUS_CHECKER = "build/statusLine",
        UPDATE_STATUS_CHECKER = "instance/statusLine?instance=",
        TRANSFER_TOOL_INSTNACE_LIST = "transferTool/getInstancesByURL?url=",
        TRANSFER_TOOL_BACKUP_STATUS_CHECKER = "transferTool/statusChecker?requestedID=",
        TRANSFER_TOOL_START_TRANSFER = "transferTool/startTransfer",
        TRANSFER_TOOL_REDIRECT_INDEX = "transferTool/index?requestedID=",
        SCHEMA_GENERATION_CHECKER = "provisioning/schemaStatus",
        LOG_CHECKER = "monitoring/readLine?instance=";


    function buildStatusCheckerRequester(statusSection) {

        var statusBar = statusSection.find(".status-bar"),
            progress = statusSection.find(".progress"),
            buttonBox = statusSection.find(".button-box");

        setTimeout(function () {
            var isLoop = true;
            GT.ajax.call({
                url:GT.baseURL + BUILD_STATUS_CHECKER,
                success:function(content){
                    if(!Boolean(content.isEnd)){
                        statusBar.text(content.message);
                        buildStatusCheckerRequester(statusSection);
                    }else{
                        progress.hide();
                        buttonBox.show();
                        statusBar.html("<pre>" + content.message + "</pre>");
                    }
                }
            });
        }, 300);
    }

    function statusCheckerRequester(statusSection, url, callback) {
        var statusBar = statusSection.find(".status-bar"),
            progress = statusSection.find(".progress"),
            buttonBox = statusSection.find(".button-box");
        setTimeout(function () {
            var isLoop = true;
            GT.ajax.call({
                url:GT.baseURL + url,
                success:function(content){
                    if(!Boolean(content.isEnd)){
                        statusBar.text(content.message);
                        statusCheckerRequester(statusSection, url, callback);
                    }else{
                        progress.hide();
                        buttonBox.show();
                        if(callback !== undefined){
                            callback(statusBar,content)
                        }
                    }
                }
            });
        }, 300);
    }


    function logChecker(statusSection, url) {
        setTimeout(function () {
            GT.ajax.call({
                url:GT.baseURL + url,
                success:function(content){
                    if(!Boolean(content.isEnd)){
                        statusSection.append(content.message);
                        statusSection.animate({scrollTop: statusSection.prop("scrollHeight")}, 500);
                        logChecker(statusSection, url);
                    }
                }
            });
        }, 300);
    }

    function transferToolCommunication(url,callback){
        GT.ajax.call({
            url:GT.baseURL + url,
            success:function(content){
                if(!Boolean(content.success)){
                    GT.messageBox.showMessage(false, content.message);
                }else{
                    if(callback !== undefined){
                        callback(content)
                    }
                }
            }
        });
    }



    return{
        buildStatusChecker: function(statusSection) {
            buildStatusCheckerRequester(statusSection);
        },
        updateStatusChecker: function(statusSection) {
            var instance = statusSection.attr("data");
            statusCheckerRequester(statusSection,UPDATE_STATUS_CHECKER + instance, function(statusBar){
                statusBar.html("<h1>Updated</h1>");
            });
        },
        installPlugin: function(statusSection) {
            var instance = statusSection.attr("data");
            statusCheckerRequester(statusSection,UPDATE_STATUS_CHECKER + instance, function(statusBar){
                statusBar.html("<h1>Installed</h1>");
            });
        },
        logCheck: function(statusSection) {
            var instance = statusSection.attr("data");
            logChecker(statusSection,LOG_CHECKER + instance);
        },
        schemaGenerationChecker: function(statusSection) {
            statusCheckerRequester(statusSection,SCHEMA_GENERATION_CHECKER, function(statusBar){
                statusBar.html("<h1>Done</h1>");
            });
        },

        transferTool: function(transferTool) {
            var source = transferTool.find(".source-server"),
                destination = transferTool.find(".destination-server"),
                form = transferTool.find(".start-transfer"),
                url = '';
            source.find(".show-source-instance").click(function(){
                url = source.find(".source-instance-url").val();
                if(url === undefined || url === ""){
                    GT.messageBox.showMessage(false, "Please Enter source url");
                }else{
                    transferToolCommunication(TRANSFER_TOOL_INSTNACE_LIST + url,function(response){
                        source.find(".source-instance-holder").html("");
                        source.find(".source-instance-holder").html(response.html);
                    });
                }
            });

            destination.find(".show-destination-instance").click(function(){
                url = destination.find(".destination-instance-url").val();
                if(url === undefined || url === ""){
                    GT.messageBox.showMessage(false, "Please Enter Destination url");
                }else{
                    transferToolCommunication(TRANSFER_TOOL_INSTNACE_LIST + url,function(response){
                        destination.find(".destination-instance-holder").html("");
                        destination.find(".destination-instance-holder").html(response.html);
                    });
                }
            });
            form.submit(function(event){
                var destinationURL,
                    sourceURL,
                    destinationInstance,
                    sourceInstance,
                    sourceVersion,
                    destinationVersion,
                    sourceSelectedOption,
                    destinationSelectedOption;

                sourceSelectedOption = source.find(".instance-select");
                destinationSelectedOption = destination.find(".instance-select");
                sourceURL =  source.find(".source-instance-url").val();
                destinationURL = destination.find(".destination-instance-url").val();
                destinationInstance = destinationSelectedOption.val();
                sourceInstance = sourceSelectedOption.val();

                sourceVersion = sourceSelectedOption.find('option:selected').attr("data-version");
                destinationVersion = destinationSelectedOption.find('option:selected').attr("data-version");

                if(sourceURL === undefined || sourceURL === ""){
                    GT.messageBox.showMessage(false, "Please Enter Source URL");
                }else if(destinationURL === undefined || destinationURL === ""){
                    GT.messageBox.showMessage(false, "Please Enter Destination URL");
                }else if (sourceSelectedOption.val() === "empty"){
                    GT.messageBox.showMessage(false, "Please Select Source Instance");
                }else if (destinationSelectedOption.val() === "empty"){
                    GT.messageBox.showMessage(false, "Please Select Destination Instance");
                }else if (sourceVersion === undefined || destinationVersion === undefined){
                    GT.messageBox.showMessage(false, "Can't Able get versions");
                }else if (sourceVersion !== destinationVersion){
                    GT.messageBox.showMessage(false, "Can't able to copy. Version Not matches");
                }else{
                    GT.ajax.call({
                        url:GT.baseURL + TRANSFER_TOOL_START_TRANSFER,
                        data:{
                            sourceVersion:sourceVersion,
                            destinationVersion:destinationVersion,
                            destinationInstance:destinationInstance,
                            sourceInstance:sourceInstance,
                            sourceServer:sourceURL,
                            destinationServer:destinationURL
                        },
                        success:function(content){
                            if(!Boolean(content.success)){
                                GT.messageBox.showMessage(false, content.message);
                            }else{
                                window.location = GT.baseURL + TRANSFER_TOOL_REDIRECT_INDEX +  content.uuid
                            }
                        }
                    });
                }
                event.preventDefault();
            });


        },
        backupStatusChecker: function(statusSection) {
            var uuid = statusSection.attr("data-uuid");
            statusCheckerRequester(statusSection,TRANSFER_TOOL_BACKUP_STATUS_CHECKER + uuid, function(statusBar,content){
                if(!Boolean(content.success)){
                    statusBar.text(content.message);
                }else{
                    statusBar.html("<h1>Done</h1>");
                }
            });
        },


    }

}());