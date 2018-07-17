var data = [];
    	var markLineData = [];
    	for ( var i = 1; i < data.length; i++) {
    		markLineData.push([ {
    			xAxis : i - 1,
    			yAxis : data[i - 1],
    			value : (data[i] + data[i - 1]).toFixed(2)
    		}, {
    			xAxis : i,
    			yAxis : data[i]
    		} ]);
    	}
    	// 定义图表option
    	option = {
    		//图表标题
    		title : {
    			//正标题
    			text : '用户每分钟的速度变化',
    			//副标题
    			subtext : '单位:km/h'
    		},
    		//数据提示框配置
    		tooltip : {
    			trigger : 'axis'
    		},
    		//X轴配置
    		xAxis : {
    			data : []
    		},
    		//Y轴配置
    		yAxis : {},
    		series : [ {
    			type : 'line',
    			data : data,
    			markPoint : {
    				data : [ {
    					type : 'max',
    					name : '最大值'
    				}, {
    					type : 'min',
    					name : '最小值'
    				} ]
    			},
    			//效果样式
    			markLine : {
    				smooth : true,
    				effect : {
    					show : true
    				},
    				distance : 10,
    				label : {
    					normal : {
    						position : 'middle'
    					}
    				},
    				symbol : [ 'none', 'none' ],
    				data : markLineData
    			}
    		} ]
    	};
    	// 基于准备好的dom，初始化echarts实例
    	var myChart = echarts.init(document.getElementById('line-echart'));
    	// 为echarts对象加载数据
    	myChart.setOption(option);
    	// 异步加载数据
    	var mapOnlyKey = [];
    	var mapKeyValue = [];
    	var mapOnlyValue = [];
    	var info = {
    		"opt" : "line"
    	};
    	$.post("./getlinedata", info, function(data) {
    		mapOnlyKey.length = 0;
    		mapKeyValue.length = 0;
    		mapOnlyValue.length = 0;

    		for ( var i = 0; i < data.length; i++) {
    			mapOnlyKey.push(data[i].time);
    			mapKeyValue.push({
    				"value" : Math.round(data[i].speed),
    				"name" : data[i].time
    			});
    			mapOnlyValue.push(data[i].speed);
    		}
    		console.log(mapOnlyKey)
    		console.log(mapKeyValue)
    		console.log(mapOnlyValue)
    		// 填入数据
    		myChart.setOption({
    			legend : {
    				//类别
    				data : mapOnlyKey
    			},
    			xAxis : [ {
    				data : mapOnlyKey
    			} ],
    			series : [ {
    				// 根据名字对应到相应的系列
    				name : '速度',
    				data : mapKeyValue
    			} ]
    		});
    		// 使用刚指定的配置项和数据显示图表。
    	}, 'json');