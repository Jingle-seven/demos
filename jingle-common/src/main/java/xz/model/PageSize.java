package xz.model;

public class PageSize {
    private int page = 0;
    private int size = 10;
    private int offset = 0;

    public int getPage() {
        return page;
    }

    public PageSize setPage(int page) {
        if(page<0) page=0;
        offset = offset==0?page:size*page;
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageSize setSize(int size) {
        if(size<0) size=0;
        offset = offset==0?size:size * page;
        this.size = size;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public int getMaxRow() {
        return offset + size;
    }

    @Override
    public String toString() {
        return "PageSize: {" +
                "page: " + page +
                ", size: " + size +
                '}';
    }
}
