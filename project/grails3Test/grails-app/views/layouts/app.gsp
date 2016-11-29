<%--
  Created by IntelliJ IDEA.
  User: Touhid Mia
  Date: 04/07/2015
  Time: 09:51 PM
--%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails Totorial"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">

    <asset:stylesheet src="lib/bootstrap.min.css"/>
    <asset:stylesheet src="lib/chosen.min.css"/>
    <asset:stylesheet src="app/style.css"/>

    <asset:javascript src="lib/jquery-1.11.3.min.js"/>
    <asset:javascript src="lib/chosen.jquery.min.js"/>
    <asset:javascript src="lib/jquery-ui.min.js"/>
    <asset:javascript src="lib/bootstrap.min.js"/>
    <asset:javascript src="app/gt.js"/>
    <asset:javascript src="app/gt.init.js"/>
    <asset:javascript src="app/gt.common.task.js"/>
    <asset:javascript src="app/gt.message.box.js"/>
    <asset:javascript src="app/gt.wizard.js"/>
    <script type="text/javascript">
        GT.baseURL = "${session.getServletContext().getContextPath()}/";
        <g:if test="${flash?.message && flash?.message?.info}">
        jQuery(document).ready(function () {
            GT.messageBox.showMessage(Boolean(${flash.message?.success}), "${flash.message?.info}");
        });
        </g:if>
    </script>
    <g:layoutHead/>
</head>
<body>

<g:render template="/layouts/header"/>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <g:render template="/layouts/left-menu"/>
        </div>
        <div class="col-md-9">
            <g:layoutBody/>
        </div>
    </div>
</div>
<g:render template="/layouts/footer"/>
</body>
</html>