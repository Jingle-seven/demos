package xz.controller;

import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.SqlRow;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xz.model.Book;
import xz.model.JsonResp;
import xz.model.PageSize;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @RequestMapping(value = "user", method = GET,produces = "application/json")
    public Object listBook(@RequestParam Long userId,PageSize pageSize) {
        Query<Book> query = Ebean.find(Book.class);
        if (userId >0) {
            query.where().eq("user_id", userId);
        }
        int count = query.findCount();
//        PageSize pageSize = getPageSize();
        List<Book> books = query.orderBy("date asc")
                .setFirstRow(pageSize.getOffset())
                .setMaxRows(pageSize.getSize())
                .findList();
        return JsonResp.create(count,books);
    }

    @RequestMapping(value = "count", method = GET)
    public Object listUserBook(@RequestParam(required = false,defaultValue = "0") Long userId,
               PageSize pageSize) {
        String sql = "select user_id, user_name,count(*) from book where 1=1 %s group by user_id";
        String countSql = "select count(*) count from (%s) t_user_book";
        if (userId >0) {
            sql= String.format(sql,"and user_id = "+userId);
        }else{
            sql = (String.format(sql,""));
        }
        countSql = String.format(countSql,sql);
        sql = sql + String.format(" order by user_id limit %d,%d",pageSize.getOffset(),pageSize.getSize());
        Integer count = Ebean.createSqlQuery(countSql).findOne().getInteger("count");
        List<SqlRow> rows = Ebean.createSqlQuery(sql).findList();
        return JsonResp.create(count,rows);
    }

}
