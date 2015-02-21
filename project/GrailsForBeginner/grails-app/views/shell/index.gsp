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
   setInterval(function () {
        console.log("HI janu");
       jQuery.ajax({
           type: "POST",
           url: "http://localhost:8221/GrailsForBeginner/shell/run?command=ping google.com -t",
           dataType:"json",
           success: function(res){
               jQuery("#lines").append(res.lines)
               jQuery('#lines').animate({scrollTop: $('#lines').prop("scrollHeight")}, 500);
                console.log(res.lines)
           }
       })


    },1000);

</script>

</head>

<body>

<pre id="lines">
    hello world
</pre>
</body>
</html>