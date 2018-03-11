## Mysql 根据本表一个字段更新本表另一个字段  
某表有四个字段: id, ip, 父id, 父ip, 现在的数据中前三个都有值, 现在要根据前三个值填充父ip字段.
思路是更新一条记录时, 根据本记录的父id找到父记录, 在把父记录的ip字段填充到本记录的父ip字段.

于是写了语句1:  
`
update spans set parent_ip=(
	select span_temp.endpoint_ipv4 ip from spans span_temp where span_temp.span_id=spans.parent_id
)`  
报错: you can't specify target table for update in from clause

mysql 不支持一边查询一边更新, 根据网上解决方案更改语句加了层子查询, 语句2: 
```
update spans A set parent_ip= (
	select endpoint_ipv4 from(
		select B.endpoint_ipv4 from spans B where B.span_id=A.parent_id
	) as C      
)
```
报错: Unknown column 'A.parent_id' in 'where clause'
嗯... 这就尴尬了. 

再找了找csdn论坛类似问题, 改成内连接, 语句3:
```
update spans  A join spans B on B.span_id=A.parent_id
set A.parent_ip = B.endpoint_ipv4 
```
执行成功,  代码简洁明了, 功能完备, 简直完美! 