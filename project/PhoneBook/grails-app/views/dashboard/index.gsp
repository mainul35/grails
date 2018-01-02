<meta name="layout" content="main"/>

<script>
    window.onload = function() {
        var ctx = document.getElementById("report");
        var lineChart = new Chart(ctx, {
            type: 'bar',
            responsive: true,
            maintainAspectRatio: true,
            data: {
                labels: ["Contact", "Contact Group", "Number"],
                datasets: [{
                    label:"Report",
                    data: [10, 8, 6]
                }]
            }
        })
    }
</script>

<div class="card">
    <div class="card-header">
        <span class="float-right">
            <div class="btn-group">
                <a href="#" class="btn btn-success">New Contact</a>
                <a href="#" class="btn btn-primary">New Contact Group</a>
                <a href="#" class="btn btn-primary">Reload</a>
            </div>
        </span>
    </div>

    <div class="card-body">
        <canvas id="report" width="200" height="200"></canvas>
    </div>
</div>