##  Django访问静态文件问题  
用django做demo,其中在页面中引用了一个本地css文件,但一直报404错误找不到文件,弄了一个多钟才解决

搜的中文资料基本是在乱扯,反正我用那些什么在urls.py中加配置的方法是没成功过,那些方法对别人的环境或许有用

转念一下想这不是有官方文档吗,于是果然在django官网上看到了对statis文件的位置约定,在项目的某个app下建立一个名为static的文件夹即可,用/static/xxx.css的形式访问


官网更推荐的是这样的形式,用以隔离不同app的资源文件:  
	project_dir/app_dir/static/app_dir/xxx.css  
在页面访问:  
```
{% load staticfiles %}
<link rel="stylesheet" type="text/css" href="{% static 'polls/style.css' %}" />
```
也可以在浏览器中输入地址访问:http://127.0.0.1:8888/static/app_dir/xxx.css

官网链接:
	[django1.8版本static文件约定](https://docs.djangoproject.com/en/1.8/intro/tutorial06/)
   
