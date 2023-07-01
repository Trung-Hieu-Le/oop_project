var xValuesToday = orderShipperCountToday.map(x => x[0]);
var yValuesToday = orderShipperCountToday.map(x => x[1]);

var barColors = "#87CEEB";

new Chart("shipperChartToday", {
    type: "bar",
    data: {
        labels: xValuesToday,
        datasets: [{
            backgroundColor: barColors,
            data: yValuesToday
        }]
    },
    options: {
        legend: { display: false },
        title: {
            display: true,
            text: "Số lượng đơn hàng mỗi shipper được giao hôm nay"
        },
        scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true
              }
            }],
        }
    }
});