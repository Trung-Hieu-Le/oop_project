var xValues = orderShipperCount.map(x => x[0]);
var yValues = orderShipperCount.map(x => x[1]);
var barColors = "lightblue";

new Chart("shipperChart", {
    type: "bar",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: barColors,
            data: yValues
        }]
    },
    options: {
        legend: { display: false },
        title: {
            display: true,
            text: "Số lượng đơn hàng mỗi shipper được giao"
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