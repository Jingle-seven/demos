$("li").each(function(i,e){//jq中因为经常要用this选择器,所以一般不使用箭头函数
    console.log($(this));//jq对象
    console.log(e);//dom对象
    console.log($(e));//dom对象转jq对象
    console.log($(this)[0]);//jq对象转dom对象
});