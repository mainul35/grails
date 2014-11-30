/**
 * Created with IntelliJ IDEA.
 * User: H.M.Touhid MIa
 */

GFB.graph = (function () {

    return {

        generate: function () {
            GFB.ajax.call({
                url:GFB.baseURL + "googleChart/getData",
                dataType:"JSON",
                callBackF:function(res){
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

                    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

                    chart.draw(data, options);
                }

            });

        },
        googleAPI: function () {

        }


    }
}());