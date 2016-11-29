/**
 * Created by touhid on 30/08/2015.
 */

jQuery(document).ready(function(){
    jQuery(".apply-chosen").chosen();
    jQuery(".open-confirm-box").click(function (event) {
        var url = $(this).attr("wizard-url"),
            title = $(this).attr("wizard-title");
        GT.wizard.confirm(title, url);
        event.preventDefault();
    });

    var searchArea = jQuery("#search-area");
    searchArea.find(".selected-column-name li").click(function(){
        var _this = $(this);
        searchArea.find(".selected-column-label").text(_this.text());
        searchArea.find(".selected-column-name").val(_this.attr('data'));
    });

    var selected = searchArea.find(".selected-column-name");
    if(selected.attr("selected-data") !== ""){
        var colAttr = "li[data='" + selected.attr("selected-data") + "']",
            colName = selected.find(colAttr).text();
        if(colName !== undefined){
            searchArea.find(".selected-column-label").text(colName);
        }
    }

    function setGetParameter(paramName, paramValue){
        var url = window.location.href;
        var hash = location.hash;
        url = url.replace(hash, '');
        if (url.indexOf(paramName + "=") >= 0)
        {
            var prefix = url.substring(0, url.indexOf(paramName));
            var suffix = url.substring(url.indexOf(paramName));
            suffix = suffix.substring(suffix.indexOf("=") + 1);
            suffix = (suffix.indexOf("&") >= 0) ? suffix.substring(suffix.indexOf("&")) : "";
            url = prefix + paramName + "=" + paramValue + suffix;
        }
        else
        {
            if (url.indexOf("?") < 0)
                url += "?" + paramName + "=" + paramValue;
            else
                url += "&" + paramName + "=" + paramValue;
        }
        window.location.href = url + hash;
    }

    jQuery(".panel").on("change",".number-of-item-per-page",function(){
        setGetParameter("max", $(this).val());

    });

    jQuery('.datepicker').datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd-mm-yy',
        yearRange: "-350:+0"
    });

});
