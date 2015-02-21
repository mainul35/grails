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

    <style>
    * {
        background-color: #000000;
    }

    #lines {
        color: #FFFFFF;
        width: 100%;
        height: 500px;
        padding: 20px;
        overflow-y: auto;
    }
    </style>
    <asset:javascript src="lib/jquery-1.10.2.js"/>

<script type="text/javascript">



    function ajaxRequest(command){

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
                jQuery("#lines").append(res.lines)
                jQuery('#lines').animate({scrollTop: $('#lines').prop("scrollHeight")}, 500);
                setTimeout(function(){ajaxRequest()}, 1000);
            }
        })
    }

    jQuery(function(){
        ajaxRequest("ping google.com -t")
    }());

</script>

</head>

<body>

<pre id="lines">
</pre>
</body>
</html>