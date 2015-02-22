<%--
  Created by IntelliJ IDEA.
  User: touhid
  Date: 21/02/2015
  Time: 2:51 PM
--%>




<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>..:: Shell ::..</title>
    <asset:javascript src="lib/jquery-1.10.2.js"/>

<script type="text/javascript">

    function ajaxRequest(consoleClass, command){
        if(command != undefined ){
            command = "?command=" + command;
        }else{
            command = "";
        }

        jQuery.ajax({
            type: "POST",
            url: "http://localhost:8080/GrailsForBeginner/shell/run" + command,
            dataType:"json",
            success: function(res){
                jQuery("." + consoleClass).append(res.lines)
                jQuery('#console-box').animate({scrollTop: $('#console-box').prop("scrollHeight")}, 500);
                if(res.isEnd != 1){
                    setTimeout(function(){ajaxRequest(consoleClass)}, 1000);
                }else{
                    jQuery(".console-input-panel").show();  
                }
            }
        })
    }

    $(document).ready(function () {        
        var promptInput = jQuery('#prompt-input');
        promptInput.keydown(function (e){
            if(e.keyCode == 13){
                var val =  promptInput.val(),
                        klass = "line-text";
                if(val == undefined || val == ""){
                    klass = "empty-line";
                }else{
                    var placed =  jQuery("#console-box .line:nth-last-child(1)"),
                            consoleClass = "console-output-" + jQuery("#console-box .console-output").size() ;
                    placed.before('<div class="line"><div class="line-user"><label>web-shell #</label></div><div class="'+ klass +'">' + val + '</div></div>');   
                    placed.before('<pre class="console-output '+ consoleClass + '"></pre>');
                    jQuery(".console-input-panel").hide()
                    ajaxRequest(consoleClass,val);
                }                
                promptInput.val("");
            }
        });        
    });


</script>
    <style>
    * {
        background-color: #000000;
        margin: 0;
        font-family: monospace;
    }

    input:focus {
        color: #fffafe
    }

    .line-user {
        float: left;
        color: #FFFFFF;
    }

    .line-input {
        margin-left:90px;
    }

    .empty-line {
        width: 100%;
        padding:10px;
    }

    .line-input input {
        width: 100%;
        border: 1px solid #000000;
        color: #ffffff;
    }

    .line-text {
        margin-left:90px;
        width: 100%;
        color: #FFFFFF;
    }
    
    .console-output{
        color: #FFFFFF;
        padding-bottom: 10px;
    }
    </style>
    
    
</head>
<body>
<div id="console-box">
        <div class="line console-input-panel">
            <div class="line-user"><label>web-shell #</label></div>
            <div class="line-input"><input id="prompt-input" type="text" name="abc"/></div>
        </div>
</div>
</body>
</html>