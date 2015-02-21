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

    input:focus {
        color: #fffafe
    }    .less{
            color: #FFFFFF;
        }

    /*input:-webkit-autofill {*/
        /*-webkit-box-shadow:0 0 0 50px #000000 inset; *//* Change the color to your own background color */
        /*-webkit-text-fill-color: #000000;*/
    /*}*/
    /*input:-webkit-autofill:focus {*/
        /*-webkit-box-shadow: *//*your box-shadow*//*,0 0 0 50px #000000 inset;*/
        /*-webkit-text-fill-color: #000000;*/
    /*}*/

    </style>
    <asset:javascript src="lib/jquery-1.10.2.js"/>

<script type="text/javascript">
    jQuery('#cmd-prompt').keydown(function (e){
        if(e.keyCode == 13){
            jQuery("#press-enter").prepend('<div class="less">web-shell #</div>');
        }
    });


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
                if(res.isEnd != 1){
                    setTimeout(function(){ajaxRequest()}, 1000);
                }
            }
        })
    }

    jQuery(function(){
        ajaxRequest("ping google.com");
    }());

</script>

</head>

<body>

<div>
    <div id="press-enter">
    </div>
    <form action="" class="cmdline" onsubmit="return false;" name="f">
        <table class="inputtable">
            <tbody>
            <tr>
                <td>
                    <div class="less">web-shell #</div>
                </td>

                <td class="cmd-input">
                    <input type="text" autocomplete="off" id="cmd-prompt" name="q" style="border: 1px solid #000000;" >
                </td>
            </tr>
        </tbody>
        </table>
    </form>
</div>
<pre id="lines">
</pre>
</body>
</html>