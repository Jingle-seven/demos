##  从零开始的树莓派搭建mysql之旅  
所需工具:	 树莓派3, micro SD卡, 读卡器, win7 PC, 无线路由器, 网线


### 第一步:给树莓派写入系统

树莓派3使用micro SD卡作为存储介质, 把系统写入SD卡就可以开机了.
1. 准备micro SD卡,也就是普通手机用的SD卡,
2.在树莓派官网下载镜像,
3.下载刻录工具win32 disk imager
4. 将下载的压缩包解压出*.img文件,用imager把img镜像写入SD卡
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632384980629046560.png)   

 
5. 在SD卡根目录新建一个空白的全名为ssh的文件,以开启ssh服务(据说树莓派3ssh默认未开启)
6.给树莓派插上SD卡, 通电开机

### 第二步: 通过ssh配置wifi连接
1.下载x-shell作为ssh连接工具
2.用网线连接树莓派和PC
3.互联PC上的本地连接和无线连接(似乎这样才能开启dhcp给树莓派分配地址?或许是不必要的一步)
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632256337768606213.png) 


4.执行ipconfig 和arp -a命令找出树莓派ip, 即找出本地连接中的动态ip(PC本身用的是静态ip)
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632115600282918166.png) 

![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632482837163928025.png) 
  
3. 新建x-shell连接,ip为树莓派ip,用户密码初始为pi和raspberry
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632159580748034151.png)  
4. 设置root密码并启用root账户, 更改pi用户密码, 不知道sudo passwd --unlock root是否必要
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632051828608513662.png)  
5. 树莓派3 自带无线网卡,只需修改wifi配置文件即可使用(然而我用ssh修改无效, 捂脸). 用界面修改后配置文件如下:
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6632006748631770205.png)  
6. 为了方便, 在无线路由器上给pi分配一个固定ip. 以后就可以不插网线用ssh连接pi了, 此步骤完成
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6631922086236438262.png) 
![photo](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6631948474515504444.png) 

7. 关机:
sudo shutdownd -h now  
 sudo halt  
 sudo power off  
 sudo init 0  
重启方法:  
 sudo   reboot  
 shutdown -r now 
 shutdownd -r 18:23:52  #定时重启在18点23分52秒关闭 
 
### 第三步:安装mysql

sudo apt-get update 				#更新软件库
sudo apt-get install mysql-server 		#安装mysql,期间要求输入两次密码
sudo mysql -u root -p 				#登录mysql查看是否安装成功

\> show databases; 									#在mysql命令行输入命令查看数据库  
\> grant all on \*.\* to 'username'@% identified by 'password'; 	#新增用户并允许远程登录  
\> flush privileges; 									#刷新mysql系统权限表  
\> quit; 											#退出mysql命令行   

sudo /etc/mysql/my.cnf  				#修改/etc/mysql/my.cnf文件，把bind-address一行注释掉
sudo service mysql restart 			#重启mysql服务器

此时, 已经可以重远端连接树莓派上的mysql服务器
