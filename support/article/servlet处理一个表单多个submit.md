## JSP:servlet处理一个表单多个submit  
 页面代码：
 ```
 <td>
 	<input type = "submit" name="action" value="action1">
 	<input type = "submit" name="action" value="action2">
 	<input type = "submit" name="action" value="action3">
 </td>
 ```
 servlet代码：  
 ```
 String action = req.getParameter("action");
 if(action.equals("action1")){
 	//语句块1
 }
 if(action.equals("action2")){
 	//语句块1
 }
 if(action.equals("action3")){
 	//语句块1
 }
 ```
