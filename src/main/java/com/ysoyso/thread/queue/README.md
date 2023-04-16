| 类 | 数组  | 链表 | 有界 | 无界 |
|---|-----|---|---|----|
|LinkedBlockingQueue|     | √ | 可选 | 可选 |
|LinkedBlockingDeque| | √ | 可选 | 可选 |
|LinkedTransferQueue| | √ | | √  |
|ArrayBlockingQueue| √   | | √ |    |
|PriorityBlockingQueue| √   | | | √  |
|DelayQueue| √   | | | √  |
|SynchronousQueue| 无存储 | | |    |

| 方法 | 是否阻塞 |
| --- |------|
| add(E e) | 否    |
| put(E e) | 是    |
| offer(E e) | 否    |
| offer(E e, long timeout, TimeUnit unit) | 是    |
| E take() | 是    |
| E poll(long timeout, TimeUnit unit) | 是    |