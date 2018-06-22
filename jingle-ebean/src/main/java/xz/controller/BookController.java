package xz.controller;

import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.SqlRow;
import xz.model.Book;

import java.util.List;
import java.util.NoSuchElementException;

public class BookController {

    public Object listBook(Long userId) {
        Query<Book> query = Ebean.find(Book.class);
        if (userId >0) {
            query.where().eq("user_id", userId);
        }
        int count = query.findCount();
        PageSize pageSize = getPageSize();
        List<Book> books = query.orderBy("date asc")
                .setFirstRow(pageSize.getOffset())
                .setMaxRows(pageSize.getMaxRow())
                .findList();
        return JsonResp.create(count,books);
    }

    public Object listUserBook(Long userId) {
        String sql = "select user_id, user_name,count(*) from book where 1=1 %s group by user_id";
        String countSql = "select count(*) count from (%s) t_user_book";
        if (userId >0) {
            sql= String.format(sql,"and user_id = "+userId);
        }else{
            sql = (String.format(sql,""));
        }
        countSql = String.format(countSql,sql);
        PageSize pageSize = getPageSize();
        sql = sql + String.format(" order by user_id limit %d,%d",pageSize.getOffset(),pageSize.getSize());
        Integer count = Ebean.createSqlQuery(countSql).findOne().getInteger("count");
        List<SqlRow> rows = Ebean.createSqlQuery(sql).findList();
        return JsonResp.create(count,rows);
    }

    private PageSize getPageSize() {
        return new PageSize();
    }
}
