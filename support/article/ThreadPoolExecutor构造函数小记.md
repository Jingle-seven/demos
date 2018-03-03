##  ThreadPoolExecutor构造函数小记  
```
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
```
corePoolSize：核心（最少）线程数
workQueue：工作队列，当任务数超过corePoolSize时会放入这里
maximumPoolSize：最大线程数，当workQueue满了后会开启新线程直到线程数为maximumPoolSize
handler：当线程数已经是最大还有新任务时，由handler处理
keepAliveTime：当线程数大于核心线程数时，如果线程空闲了keepAliveTime时间，则销毁线程
unit：keepAliveTime的时间单位
threadFactory：线程工厂

Executors类的四个工厂方法都是由ThreadPoolExecutor实现：  
```
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
public ScheduledThreadPoolExecutor(int corePoolSize) {
    super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
          new DelayedWorkQueue());
}
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
```
   
