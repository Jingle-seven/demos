# demos
demos是个maven多模块项目，包含三个子模块  
jingle-app 原本计划用做手机app的后台，但计划一直只是计划  
jingle-demo 是在开发过程中的练手小程序  
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
