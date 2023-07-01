var transactionToday_x = orderStatusCountToday.map(x => x[0]);
var transactionToday_y = orderStatusCountToday.map(x => x[1]);
var barColors = [
    "#FFD700",
    "#0096FF",
    "#7CFC00",
    "#EE4B2B",
    "#BF40BF",
    "#d5563d",
    "#1e7145",

];

new Chart("statusChartToday", {
    type: "pie",
    data: {
        labels: transactionToday_x,
        datasets: [{
            backgroundColor: barColors,
            data: transactionToday_y
        }]
    },
    options: {
        legend: { position: 'bottom', },
        title: {
            display: true,
            text: "Tỉ lệ trạng thái của đơn hàng hôm nay",
        }
    }
});