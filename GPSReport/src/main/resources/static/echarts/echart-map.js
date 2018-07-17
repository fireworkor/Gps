
 var myChart5 = echarts.init(document.getElementById('map'));
    option = {
                 title : {
                     text: '用户分布',
                     x:'center'
                 },
                 tooltip : {
                     trigger: 'item'
                 },
                 legend: {
                     orient: 'vertical',
                     x:'left',
                     data:[]
                 },
                 dataRange: {
                     min: 0,
                     max: 2500,
                     x: 'left',
                     y: 'bottom',
                     text:['高','低'],           // 文本，默认为数值文本
                     calculable : true
                 },
                 toolbox: {
                     show: true,
                     orient : 'vertical',
                     x: 'left',
                     y: 'center',
                     feature : {
                         mark : {show: true},
                         dataView : {show: true, readOnly: false},
                         restore : {show: true},
                         saveAsImage : {show: true}
                     }
                 },

                 series : [
                     {
                         name: 'iphone5',
                         type: 'map',
                         mapType: 'china',
                         itemStyle:{
                             normal:{label:{show:true}},
                             emphasis:{label:{show:true}}
                         },
                         data:[]
                     }
                 ]
             }
    myChart5.setOption(option);
    var info = {
        "opt" : "map"
    };

    var mapOnlyKey1 = [];
    var mapKeyValue1 = [];
    var mapOnlyValue1 = [];
    $.post("/GetMapData", function(data) {
        for (var i = 0; i < data.length; i++) {
            mapOnlyKey1.push(data[i].address);
            mapKeyValue1.push({"name": data[i].address, "value": Math.round(data[i].num)});
            mapOnlyValue1.push(data[i].num);
        }
        console.log("======================================================")
        console.log(mapOnlyKey1)
        console.log(mapKeyValue1)
        console.log(mapOnlyValue1)

        myChart5.setOption({

            series : [ {
                data : mapKeyValue1
            } ]
        })
    },'json');
