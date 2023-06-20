## 说明

### 线程
- 线程和进程
- 线程状态
- 线程创建
- start
- sleep
![线程状态图](../../../../resources/threadstate.png)
### 线程的一些其他方法
- 线程名
- 线程优先级 和 yield()
- 守护线程
- 未捕获异常处理
### 中断线程
- 标志位
- interrupt中断线程
- InterruptedException
- 中断状态恢复
```
 Thread.currentThread().interrupt() // 设置当前线程的中断状态
 Thread.interrupted() // 返回当前状态，清除中断状态
 Thread.currentThread().isInterrupted() // 判断当前线程中断状态
```
### 同步代码块
- join
- synchronized
- 监视器锁
- 静态锁/对象锁
- 条件队列
  - wait
  - notify
  - notifyAll
### 线程安全：状态安全 可见性和原子性
- 属性变量和race condition
- final
- 本地变量
- ThreadLocal
- AtomicXXX
- synchronized
- volatile
### 线程安全：顺序安全 有序性
- 指令重排序
- synchronized和监视器锁
- 显示锁
- Lock
- 显示条件队列
  - Condition
### 同步工具类
- CountDownLatch
- CyclicBarrier
- Semaphore
- Phaser
- Exchanger
- Callable
- Future/结束
### 线程安全的集合
- CopyOnWriteArrayList
- ConcurrentHashMap
- SynchronizedXXX
### 阻塞队列
- 阻塞队列
- 生产者消费者模式
- 中断
### 线程池
- Executor
- ExecutorService
  - ThreadPoolExecutor
    - RejectedExecutionHandler
    - ThreadFactory
    - BlockingQueue
  - ScheduledThreadPoolExecutor
- ForkJoinPool
- Executors
- Callable
- Future
- CompletionService
### 性能和活跃性
- 锁竞争/死锁
- 饥饿/响应性
- 线程开销 
   
  Java线程的创建和销毁都需要一定的开销，这些开销主要包括以下几个方面： 
  - 内存开销：每个线程都需要一定的内存空间来存储线程状态、程序计数器、栈信息等。 
  - 同步开销：如果多个线程需要访问共享资源，就需要使用同步机制来保证线程安全，而同步机制的实现也会带来一定的开销。 
  - 线程池维护开销：当使用线程池时，线程的创建和管理都由线程池负责，从而增加了一定的线程池维护开销。 
  - 上下文切换开销：在多线程环境下，CPU需要不断地进行线程切换，从而增加了一定的上下文切换开销。 
  
  因此，在编写高并发程序时，我们需要充分考虑到线程的开销问题，避免不必要的线程创建和销毁，尽可能地利用线程池和同步机制来优化程序性能。
  
