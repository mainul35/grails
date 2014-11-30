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
            GFB.graph.generate("LINE","googleChart/lineChartData");
            GFB.graph.generate("DONUT","googleChart/donutChartData");
            GFB.graph.generate("PIE","googleChart/donutChartData");
            GFB.graph.generate("ALU","googleChart/circleChartData");
            GFB.graph.generate("COLUMN","googleChart/lineChartData");
        }
    </script>
    <meta name="layout" content="grap">
</head>

<body>
<div id="line_chart" style="width: 1200px; height: 500px;"></div>
<div id="donut_chart" style="width: 500px; height: 500px;"></div>
<div id="pie_chart" style="width: 500px; height: 500px;"></div>
<div id="circle_chart" style="width: 500px; height: 500px;"></div>
<div id="column_chart" style="width: 1000px; height: 500px;"></div>
</body>
</html>