 var myChart4 = echarts.init(document.getElementById('zifu'));
// var myChart4 =require('echarts').init(document.getElementById('zifu'))
    	function createRandomItemStyle() {
    	    return {
    	        normal: {
    	            color: 'rgb(' + [
    	                Math.round(Math.random() * 160),
    	                Math.round(Math.random() * 160),
    	                Math.round(Math.random() * 160)
    	            ].join(',') + ')'
    	        }
    	    };
    	}

    	myChart4.setOption( {
    	    title: {
    	        text: '活动省份',
    	        x:'center'
    	    },
    		tooltip : {},
    	    series: [{
    	        name: 'zifu',
    	        type: 'wordCloud',
    	        size: ['80%', '80%'],
    	        textRotation : [0, 45, 90, -45],
    	        textPadding: 0,
    	        autoSize: {
    	            enable: true,
    	            minSize: 14
    	        },
    	        data: [ { } ]
    	    }]
    	});
    	var ZifuOnlyKey = [];
    	var ZifuKeyValue = [];
    	var ZifuOnlyValue = [];
    	var info = {
    		"opt" : "wordCloud"
    	};
    	$.post("/getzifudata", info, function(data) {
//    		var e = eval(datas);

//    		ZifuOnlyKey.length=0;
//    		ZifuKeyValue.length=0;
//    		ZifuOnlyValue.length=0;
    		for(var i=0; i < data.length; i++){
				ZifuOnlyKey.push(data[i].address);
				ZifuKeyValue.push({"value":data[i].num*10,"name":data[i].address,"itemStyle":createRandomItemStyle()});
				ZifuOnlyValue.push(data[i].num*10);
			}

    		console.log("=====================================================");
    		console.log(ZifuOnlyKey);
    		console.log(ZifuKeyValue);
    		console.log(ZifuOnlyValue);
    		myChart4.setOption({
		        series: [{
		            data: ZifuKeyValue,
		        }]
		    });
        // 使用刚指定的配置项和数据显示图表。
		});