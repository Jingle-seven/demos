/**
 * Created by admin on 2018/4/22.
 */
// import 'test.js';//有些浏览器不支持es6的导入语法,所以要么用webpack,要么在html里写js文件,辣鸡js
require.config({//所以使用requirejs,和本文件同一目录的js可以直接引用,否则要在config里声明路径,然并卵还是没解决
    paths: {
        "test": "test",
        "jquery": "lib/jquery-3.3.1",
        "react": "lib/react.min"
    },
    shim: {

        'test':{
            exports: "test"
        },

        'jquery': {
            deps: ['', ''],
            exports: '$'
        }

    }
});
require(['test', 'jquery'], function (test,js){
    // 加载完所有模块后执行此函数,参数为加载的模块
});
console.log(test.say('fine'));
JQuery.get('http://localhost:5974/users',function(data,status) {
    console.log(JSON.stringify(data));
});
// document.write('fine');