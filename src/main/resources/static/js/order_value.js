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
      backgroundColor: 'red',
      data: y1Values
    }]
  },
  options: {
    legend: {display: false},
    scales: {
      yAxes: [{ticks: {min: 6, max:16}}],
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
      backgroundColor: 'red',
      data: y2Values
    }]
  },
  options: {
    legend: {display: false},
    scales: {
      yAxes: [{ticks: {min: 6, max:16}}],
    }
  }
});

