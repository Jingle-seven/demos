
function genBarChart(echart,elementId,title,legend,kvArr){
    let keys = kvArr.reduce(getKV('key'),[]);
    let values = kvArr.reduce(getKV('value'),[]);
    let myChart = echart.init(document.getElementById(elementId),'light');
    let option = {
        title: {text: title},
        grid: {left: '15%',right: '10%',bottom: '30%',top: '20%',containLabel: false},
        tooltip: {},
        legend: {data:[legend]},
        xAxis: {
            type: 'category',
            data: keys,
            axisLabel:{
                rotate:-60
            }
        },
        yAxis: {name: legend,type: 'value'},
        series: [{
            name: legend,
            type: 'bar',
            data: values
        }]
    };
    myChart.setOption(option);
}
getKV=(property)=>{
    return (sum,cur)=> {
        sum.push(cur[property]);
        return sum;
    }
};