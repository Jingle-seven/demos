package xz.model;


import xz.util.XKit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/6/28 10:08.
 */
public class PageSize {
    private Integer page;
    private Integer size;
    private Boolean all;
    private int resPage;
    private int resSize;
    
    public<T> List<T> getSubList(List<T> data) {
        if(all!=null && all)
            return data;
        resPage= page!=null&&page>0?page:1;
        resSize = size!=null&&size>0?size:10;
        int begin = (resPage - 1)*resSize;
        int end = begin + resSize;
        int dataSize = data.size();
        if(begin<dataSize && end<=dataSize){
            return data.subList(begin,end);
        }else if(begin<dataSize && end>dataSize){
            return data.subList(begin,dataSize);
        }else {
            return  new ArrayList<>();
        }
    }
    
    public PageSize setPage(Integer page) {
        this.page = page;
        return this;
    }
    
    public PageSize setSize(Integer size) {
        this.size = size;
        return this;
    }
    
    public PageSize setAll(Boolean all) {
        this.all = all;
        return this;
    }
    
    public String[] concatMeta(String... meta){
        if(all!=null && all)
            return meta;
        return XKit.concat(meta,new String[]{"page:"+resPage,"size:"+resSize});
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageSize{");
        sb.append("page=").append(page);
        sb.append(", size=").append(size);
        sb.append(", resPage=").append(resPage);
        sb.append(", resSize=").append(resSize);
        sb.append('}');
        return sb.toString();
    }
}
