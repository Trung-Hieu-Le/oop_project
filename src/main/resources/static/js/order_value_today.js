var xValuesToday = orderUserCountToday.map(x => x[0]);
var y1ValuesToday = orderUserCountToday.map(x => x[1]);

new Chart("userChartToday", {
    type: "line",
    data: {
      labels: xValuesToday,
      datasets: [{
        fill: false,
        lineTension: 0,
        borderColor: 'red',
        backgroundColor: 'red',
        data: y1ValuesToday
      }]
    },
    options: {
      legend: { display: false },
      title: {
        display: true,
        text: "Số đơn đặt hàng của khách hàng hôm nay"
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