/**
 * Created with IntelliJ IDEA.
 * User: H.M.Touhid MIa
 */

GFB.graph = (function () {

    var LINE = "LINE",
        PIE = "PIE",
        COLUMN = "COLUMN";

    return {
        generate: function (type, url) {
            GFB.ajax.call({
                url:GFB.baseURL + url,
                dataType:"JSON",
                callBackF:function(res){
                  if(type == "LINE"){
                    GFB.graph.lineChart(res);
                  } else if (type == "DONUT"){
                      GFB.graph.donutChart(res);
                  }else if (type == "PIE"){
                      GFB.graph.pieChart(res);
                  }else if (type == "ALU"){
                      GFB.graph.circleChart(res);
                  }else if (type == "COLUMN"){
                      GFB.graph.columnChart(res);
                  }
                }

            });

        },
        googleChartAPI:function(chartType, data, options, place){

            var chart;
            if(chartType == "LINE"){
                chart = new google.visualization.LineChart(document.getElementById(place));
            }else if (chartType == "PIE"){
                chart = new google.visualization.PieChart(document.getElementById(place));
            }else if (chartType == "COLUMN"){
                chart = new google.visualization.ColumnChart(document.getElementById(place));
            }
            chart.draw(data, options);
        },
        lineChart: function (res) {
            var data = google.visualization.arrayToDataTable(res);
            var formatter = new google.visualization.NumberFormat({pattern:'$###,###'} );
            formatter.format(data, 1);
            formatter.format(data, 2);
            var options = {
                title: 'Line Chart',
                pointSize: 10,
                vAxis: {title: "Vertical Axis",format:'$#,###'},
                hAxis: {title: "Horizontal Axis"}
            };
            GFB.graph.googleChartAPI(LINE,data,options,"line_chart");
        },
        donutChart:function(res){
            var data = google.visualization.arrayToDataTable(res);
            var options = {
                title: 'Donut Chart',
                pieHole: 0.4
            };
            GFB.graph.googleChartAPI(PIE,data,options,"donut_chart");
        },
        pieChart:function(res){
            var data = google.visualization.arrayToDataTable(res);
            var options = {
                title: 'Pie Chart'
            };
            GFB.graph.googleChartAPI(PIE,data,options,"pie_chart");
        },
        circleChart:function(res){
            var data = google.visualization.arrayToDataTable(res);
            var options = {
                pieHole: 0.9,
                backgroundColor:{stroke:"#666"},
                pieSliceText: 'none',
                pieStartAngle: 135,
                tooltip: { trigger: 'none' },
                slices: {
                    0: { color: 'red' },
                    1: { color: '#666699' }
                },
                pieSliceTextStyle: {
                    color: 'black'
                },
                legend: 'none'
            };
            GFB.graph.googleChartAPI(PIE,data,options,"circle_chart");
        },
        columnChart:function(res){
            var data = google.visualization.arrayToDataTable(res);
            var options = {
                title: 'Column Chart',
                hAxis: {title: 'Month', titleTextStyle: {color: 'red'}}
            }
            GFB.graph.googleChartAPI(COLUMN,data,options,"column_chart");
        }




    }
}());