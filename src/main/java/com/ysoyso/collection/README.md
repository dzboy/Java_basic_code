## 说明

集合课程源码

### 介绍

- 类图
- Iterator
- Iterable
- foreach

### List

- List
- LinkedList
- ArrayList

### Set

- HashSet
- TreeSet
- LinkedHashSet

### Queue

- Queue
- Deque
- LinkedList
- PriorityQueue

| Queue | 抛异常       | 返回特定值    |
|-------|-----------|----------|
| 插入    | add(e)    | offer(e) |
| 移除    | remove()  | poll()   |
| 检查    | element() | peek()   |

| Deque | 	First Element (Head)	 |                | Last Element (Tail) |               |
|-------|------------------------|----------------|---------------------|---------------|
|       | 抛异常                    | 	返回特定值         | 	抛异常	               | 返回特定值         |
| 插入    | 	addFirst(e)           | 	offerFirst(e) | 	addLast(e)         | 	offerLast(e) |
| 移除	   | removeFirst()          | 	pollFirst()   | 	removeLast()       | 	pollLast()   |
| 检查    | 	getFirst()	           | peekFirst()    | getLast()	          | peekLast()    |

### Map

- HashMap
- TreeMap
- LinkedHashMap
- IdentityHashMap

### 枚举

- Enum
- EnumSet
- EnumMap

### 小集合

***jdk8***

- Arrays.asList()

***jdk9***

- List.of
- Set.of
- Map.of
- Map.ofEntries

### 子集合

- subList
- subSet
- headSet
- tailSet
- subMap
- headMap
- tailMap

### 不可修改的集合

- Collection.unmodifiableXXX

### 线程安全的集合

  HashMap
t1   k1    ->     1
t2     k1  ->  2        k1 -> 1

- ConcurrentHashMap
  t1   k1->1
  t2         k1->2   k1->2

  ArrayList
- CopyOnWriteArrayList
- Collection.synchronizedMap

### 集合中的算法

- 排序
- 混排
- 查找


