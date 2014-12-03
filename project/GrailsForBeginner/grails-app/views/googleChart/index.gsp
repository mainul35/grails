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

<div class="circle" id="circles-1"></div>
<script>
    Circles.create({
        id:           'circles-1',
        radius:       60,
        value:        43,
        maxValue:     100,
        width:        5,
        text:         function(value){return value;},
        colors:       ['#F2E6E6', '#FA0000'],
        duration: 	  400,
        wrpClass:	    'circles-wrp',
        textClass:	  'circles-text',
        styleWrapper: true,
        styleText:    true
    });
</script>

<div class="circle" id="circle"></div>


<div id="line_chart" style="width: 1200px; height: 500px;"></div>
<div id="donut_chart" style="width: 500px; height: 500px;"></div>
<div id="pie_chart" style="width: 500px; height: 500px;"></div>
<div id="circle_chart" style="width: 500px; height: 500px;"></div>
<div id="column_chart" style="width: 1000px; height: 500px;"></div>

<style>
.cell-block {
    padding: 10px 0;
    position: relative;
    text-align: center;
}
.opacity {
    background: none repeat scroll 0 0 red;
    bottom: 0;
    left: 0;
    position: absolute;
    right: 0;
    top: 0;
    z-index: 0;
}
.amount {
    color: #fff;
    position: relative;
    z-index: 10;
}
</style>
<table cellpadding="0" cellspacing="0" width="100%" border="0">
    <tr>
        <td>
            <div class="cell-block"><span class="amount">20%</span><span class="opacity"></span></div>
        </td>
        <td>
            <div class="cell-block"><span class="amount">50%</span><span class="opacity"></span></div>
        </td>
        <td>
            <div class="cell-block"><span class="amount">10%</span><span class="opacity"></span></div>
        </td>
    </tr>
</table>



</body>
</html>