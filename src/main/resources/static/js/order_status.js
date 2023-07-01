var transaction_x = orderStatusCount.map(x => x[0]);
var transaction_y = orderStatusCount.map(x => x[1]);

var barColors = [
    "#FFD700",
    "#0096FF",
    "#7CFC00",
    "#EE4B2B",
    "#BF40BF",
    "#d5563d",
    "#1e7145",

];

new Chart("statusChart", {
    type: "pie",
    data: {
        labels: transaction_x,
        datasets: [{
            backgroundColor: barColors,
            data: transaction_y
        }]
    },
    options: {
        legend: { position: 'bottom', },
        title: {
            display: true,
            text: "Tỉ lệ trạng thái của đơn hàng",
        }
    }
});