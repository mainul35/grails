<%--
  Created by IntelliJ IDEA.
  User: touhid
  Date: 30/11/2014
  Time: 11:36 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            GFB.graph.generate();
        }
    </script>
    <meta name="layout" content="grap">
</head>

<body>
<div id="chart_div" style="width: 1200px; height: 500px;"></div>
</body>
</html>