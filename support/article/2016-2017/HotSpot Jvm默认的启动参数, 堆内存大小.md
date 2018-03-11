## HotSpot Jvm默认的启动参数,堆内存大小  
转载自栈溢出  
一般最小内存(Xms)是物理机内存的1/64,最大(Xmx)是1/4.
也可以用命令行查看当前的默认设定.
Win:
java -XX:+PrintFlagsFinal -version | findstr HeapSize

Unix/Linux:

java -XX:+PrintFlagsFinal -version | grep HeapSize

找到参数:
MaxHeapSizede> (for -Xmx) 
InitialHeapSizede>(for -Xms) 
单位不是M,不是K,是B
1GB 
= 1024 MB 
= 1024 *1024 KB 
= 1024 *1024 *1024 B
