
let page = 0;
let maxPage = 0;
function initData(dataUrl,rowFunc){
    fetch(dataUrl)
        .then(resp=>resp.json())
        .then(result=>{
            console.log(result);
            //分页按钮
            for(let i=1;(i-1)*10<result.count;i++){//TODO 页码过多时添加省略号
                maxPage = i;
                $('#lastPageBtn').before(`<li class="page-item"><a class="page-link">${i}</a></li>`);
            }
            //第一页按钮高亮
            $($('.page-item')[1]).attr('class','page-item active');
            //如果数据量小, 不显示分页
            if(result.count<10) $('.page-item').remove();
            //表格内容
            result.data.forEach(rowFunc)
        });
}
//因为要监听动态加载的元素, 所以一般的click绑定方法不行
function bindPageClick(pageStr,func){
    if('Previous'==pageStr){
        page --;
    }else if('Next'==pageStr){
        page ++;
    }else {
        page = pageStr - 1;
    }
    //设置页码高亮
    $('.page-item').each((i,e)=>{
        if(checkPageNum(page)+1 == $(e).children()[0].innerHTML){
            $(e).attr('class','page-item active');
        }else {
            $(e).attr('class','page-item');
        }
    });
    func();//发请求获取数据
}
function checkPageNum(pageNum){
    if(pageNum<1) page = 0;
    if(pageNum>maxPage) page = maxPage-1;
    return page
}