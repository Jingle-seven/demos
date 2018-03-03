##  mybatis 传入String参数进行like模糊查询  
直接贴可正确运行的代码：  
```
	@Select("select * from t_place where name like '%${_parameter}%' ")
	public List<Place>findByName(String Name );
```
其中有两点要注意，一是#改为$,这两者作用类似,#{}可以防止注入攻击所以更经常使用，而此处需要用${}。
二是参数要写为_parameter而非name，因为某些版本的mybatis中会用OGNL方式在String类中寻找getName方法导致错误。这一问题也可用@Param(value="name")解决，如下：
```
	public List<Place>findByName(@Param(value="name")String Name );
```
这个解决方案只针对一个参数的情况，要传入多个参数可使用JavaBean或者Map。
   
