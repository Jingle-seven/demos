
let page = 0;
let maxPage = 0;
let pageBtnArr =[];
function initData(dataUrl,resFunc){
    fetch(dataUrl)
        .then(resp=>resp.json())
        .then(result=>{
            //分页按钮
            for(let i=1;(i-1)*10<result.count;i++){
                maxPage = i-1;
                pageBtnArr [i-1] = i;//按钮显示的数字,以1开始
                //$('#lastPageBtn').before(`<li class="page-item"><a class="page-link">${i}</a></li>`);
            }
            //page-num用来方便选择要删除的节点
            getEllipsisPageArr(pageBtnArr,1,4).forEach(e=>
                $('#lastPageBtn').before(`<li class="page-item page-num"><a class="page-link">${e}</a></li>`)
            );
            //第一页按钮高亮
            $($('.page-item')[1]).attr('class','page-item page-num active');
            //如果数据量小, 不显示分页
            if(result.count<10) $('.page-item').remove();
            //调用回调函数
            // result.data.forEach(resFunc);
            resFunc(result);
        });
}
//绑定页面按钮事件,因为按钮是动态加载的, 所以一般的click绑定方法不行
function bindPageClick(pageStr,func){
    if('Previous'==pageStr){
        page --;
    }else if('Next'==pageStr){
        page ++;
    }else if(!isNaN(pageStr)){
        page = pageStr - 1;
    }
    page = checkPageNum(page);
    $('.page-num').remove();//移除点击之前的页码
    // console.log(page);
    getEllipsisPageArr(pageBtnArr,page+1,4).forEach(e=>
        $('#lastPageBtn').before(`<li class="page-item page-num"><a class="page-link">${e}</a></li>`)
    );
    // console.log($('li.active a')[0]);//选择父元素为li,父元素类为active的a元素
    // console.log($('.page-item:eq(2)')[0]);//选择类为.page-item的第二个元素
    // $(`.page-item:eq(${page + 1})`).attr('class', 'page-item page-num active');
    if(page>=0 || page<maxPage) {//防止preview被高亮
        //取消原页码高亮, 设置现页码高亮
        $('li.active').attr('class','page-item page-num');
        $('.page-item').each((i,e)=>{
            if(page+1 == $(e).children()[0].innerHTML){
                $(e).attr('class','page-item page-num active');
            }
        });
    }
    func(page);//发请求获取数据
}
function checkPageNum(pageNum){
    if(pageNum<1) page = 0;
    if(pageNum>maxPage) page = maxPage;
    return page
}
//获取带省略号的页码数组,arr原数组,cur当前页码,range当前页码到省略号的范围
function getEllipsisPageArr(arr,cur,range){
    arr = JSON.parse(JSON.stringify(arr));//复制一份
    // let cur = 7;
    // let range = 5;
    for(let idx=0;idx<arr.length;idx++){
        if(arr[idx]==1 || idx==arr.length-1) continue;
        if(arr[idx]==cur-range || arr[idx]==cur+range){
            arr[idx]='...';continue;
        }
        if(arr[idx]>cur-range && arr[idx]<cur+range) continue;
        arr.splice(idx,1);
        idx--;
        //delete arr[idx];
    }
    //arr.forEach(e=>console.log(e))//会跳过null元素
    //for(let idx=0;idx<arr.length;idx++){ console.log(arr[idx]); }
    // console.log(arr);
    return arr;
}