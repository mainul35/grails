<%--
  Created by IntelliJ IDEA.
  User: touhid
  Date: 4/12/2014
  Time: 3:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="draggable">

    <style>
    body {
        min-width: 1000px;
    }
    .column {
        width: 400px;
        float: left;
        padding-bottom: 100px;
    }
    .portlet {
        margin: 0 1em 1em 0;
        padding: 0.3em;
    }
    .portlet-header {
        padding: 0.2em 0.3em;
        margin-bottom: 0.5em;
        position: relative;
    }
    .portlet-toggle {
        position: absolute;
        top: 50%;
        right: 0;
        margin-top: -8px;
    }
    .portlet-content {
        padding: 0.4em;
    }
    .portlet-placeholder {
        border: 1px dotted black;
        margin: 0 1em 1em 0;
        height: 50px;
    }
    </style>

    <script>
        $(function() {
            $( ".column" ).sortable({
                connectWith: ".column",
                handle: ".portlet-header",
                placeholder: "portlet-placeholder ui-corner-all",
                stop:function(event, ui){
                    console.log("End " + ui.item.index())
                },
                start:function(event, ui){
                    console.log("Start " + ui.item.index())
                }

            });

            $( ".portlet" )
                    .addClass( "ui-widget ui-widget-content ui-helper-clearfix ui-corner-all" )
                    .find( ".portlet-header" )
                    .addClass( "ui-widget-header ui-corner-all" )
                    .prepend( "<span class='ui-icon ui-icon-minusthick portlet-toggle'></span>");

        });
    </script>
</head>

<body>

<div class="column1"></div>



<div class="column ">
    <g:each in="${items}" var="item">
        <div class="portlet">
            <div class="portlet-header">${item?.name}</div>
            <div class="portlet-content">${item?.description}</div>
        </div>
    </g:each>
</div>
</body>
</html>