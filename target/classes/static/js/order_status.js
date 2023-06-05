var transaction_x = orderStatusCount.map(x => x[0]);
var transaction_y = orderStatusCount.map(x => x[1]);
var xValues = transaction_x;
var yValues = transaction_y;
var barColors = [
    "#f36174",
    "#a166f4",
    "#52ffe0",
    "#4ea579",
    "#f2b652",
    "#d5563d",
    "#1e7145",

];

new Chart("statusChart", {
    type: "pie",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: barColors,
            data: yValues
        }]
    },
    options: {
        legend: {position:'bottom',},
        title: {
            display: true,
            text: "Tỉ lệ trạng thái của đơn hàng",
        }
    }
});