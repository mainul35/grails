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

    <script>
        $(function() {
            $( "#sortable" ).sortable({
                revert: true
            });
            $( "#draggable" ).draggable({
                connectToSortable: "#sortable",
                helper: "clone",
                revert: "invalid"
            });
            $( "ul, li" ).disableSelection();
        });
    </script>
</head>

<body>



<ul>
    <li id="draggable" class="ui-state-highlight">Drag me down</li>
</ul>

<ul id="sortable">
    <li class="ui-state-default">Item 1</li>
    <li class="ui-state-default">Item 2</li>
    <li class="ui-state-default">Item 3</li>
    <li class="ui-state-default">Item 4</li>
    <li class="ui-state-default">Item 5</li>
</ul>





</body>
</html>