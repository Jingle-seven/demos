package xz.controller;

import io.ebean.Ebean;
import io.ebean.ExpressionList;
import io.ebean.Query;
import io.ebean.SqlRow;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xz.model.Book;
import xz.model.JsonResp;
import xz.model.PageSize;
import xz.model.TermBookCount;

import java.time.LocalDate;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @RequestMapping(value = "user", method = GET,produces = "application/json")
    public Object listBook_(Long userId, PageSize pageSize) {
        return listBook(userId,pageSize);
    }
    @RequestMapping(value = "user/{userId}", method = GET,produces = "application/json")
    public Object listBook(@PathVariable Long userId, PageSize pageSize) {
        Query<Book> query = Ebean.find(Book.class);
        if (userId >0) query.where().eq("user_id", userId);
        int count = query.findCount();
        List<Book> books = query.orderBy("date,name")
                .setFirstRow(pageSize.getOffset()).setMaxRows(pageSize.getSize())
                .findList();
        return JsonResp.create(count,books);
    }
    @RequestMapping(value = "user/{userId}/periodBookCount", method = GET,produces = "application/json")
    public Object listUserPeriodBook(@PathVariable Long userId) {
        ExpressionList<Book> query = Ebean.find(Book.class).where().eq("user_id", userId);
        List<Book> books = query.orderBy("date,name").findList();
        List<TermBookCount> termBookCountList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TermBookCount counter1 = new TermBookCount()
                    .setTerm("第"+(i+1)+"学年上学期").setCount(0)
                    .setStartDate(LocalDate.of(2012+i,9,1))
                    .setEndDate(LocalDate.of(2012+i+1,2,1));
            TermBookCount counter2 = new TermBookCount()
                    .setTerm("第"+(i+1)+"学年下学期").setCount(0)
                    .setStartDate(LocalDate.of(2012+i+1,2,1))
                    .setEndDate(LocalDate.of(2012+i+1,9,1));
            termBookCountList.add(counter1);
            termBookCountList.add(counter2);
        }
        for(Book book:books){
            for(TermBookCount count:termBookCountList){
                if(count.isInTheTerm(book.date())){
                    count.setCount(count.count+1);
                }
            }
        }
        return JsonResp.create(termBookCountList.size(),termBookCountList);
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
