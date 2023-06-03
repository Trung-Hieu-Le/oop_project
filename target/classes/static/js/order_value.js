var xValues = orderValueAndCount.map(x => x[0]);
var y1Values = orderValueAndCount.map(x => x[1]);
var y2Values = orderValueAndCount.map(x => x[2]);

new Chart("valueOrderChart", {
  type: "line",
  data: {
    labels: xValues,
    datasets: [{
      fill: false,
      lineTension: 0,
      borderColor: 'red',
      backgroundColor: 'red',
      data: y1Values
    }]
  },
  options: {
    legend: { display: false },
    title: {
      display: true,
      text: "Số đơn hàng của từng khách hàng"
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

new Chart("numberOrderChart", {
  type: "line",
  data: {
    labels: xValues,
    datasets: [{
      fill: false,
      lineTension: 0,
      borderColor: 'red',
      backgroundColor: 'red',
      data: y2Values
    }]
  },
  options: {
    legend: { display: false },
    title: {
      display: true,
      text: "Tổng giá trị các đơn hàng của từng khách hàng"
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

