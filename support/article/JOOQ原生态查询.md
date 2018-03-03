##  JOOQ原生态查询  
```

//原生态查询
public Result<Record> findAllSpans(){
   DSLContext DSLctx = null;
   try {
      DSLctx = ctx.get(ds.getConnection());
   } catch (SQLException e) {
      e.printStackTrace();
   }
   Table<Record> table = DSL.table("zipkin_spans");
   SelectQuery<Record> selectQuery = DSLctx.selectQuery(table);//获取查询对象
   Condition condition = DSL.field("name").eq("span_a");//查询条件
   selectQuery.addConditions(condition);//添加查询条件
   Result<Record> res = selectQuery.fetch();
   return res;
}
  
  
//妖艳贱货查询
public Result<Record> queryWithCondition(TableImpl<Record> table, Condition ...cdtn){
   try (Connection conn = ds.getConnection()) {
      Result<Record> rcds = ctx.get(conn)
            .selectFrom(table)
            .where(cdtn)
            .fetch();

      return rcds;
   } catch (SQLException e) {
      e.printStackTrace();
      return null;
   }
}
```
   
