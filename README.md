# demos
demos是个maven多模块项目，包含几个子模块  
jingle-demo 是在开发过程中的练手小程序   
jingle-ebean测试了简单使用ebean orm框架的情况  
jingle-jpa测试了简单使用jpa-hibernate orm框架的情况   
jingle-sever 是开发过程中累积的代码片段  
support 文件夹包含程序要用到的建表SQL语句、平时积累的小脚本、技术笔记备份

### 过滤在.gitignore中,却已经添加到版本控制的文件
同步远程库  
$ git pull  
在本地删除缓存  
$ git rm -r --cached .  
再次add所有文件  
$ git add .  
提交  
$ git commit -m "add ignore"  
上传  
$ git push  
  
同样的思路，删除部分缓存
git rm --cached logs/xx.log，  
更新 .gitignore 忽略掉目标文件，  
最后 git commit -m "We really don't want Git to track this anymore!"

### 我的IDEA常用插件
.gitignore  
bash  
python  
scala  
