package com.ysoyso.thread.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    public static void main(String[] args) throws InterruptedException {
//        final Map<Integer, String> map = new HashMap<>();
        final Map<Integer, String> map = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                map.put(i, Integer.toString(i));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                map.put(i, Integer.toString(i));
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("------------------");
        System.out.println("Size of map: " + map.size());
    }


//    -------------HashMap--------------------
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null); // 这里可能被覆盖
//        else {
//            HashMap.Node<K,V> e; K k;
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            else if (p instanceof HashMap.TreeNode)
//                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold) // ++size可能多执行
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }


//    ----------------ConcurrentHashMap------------------
//    final V putVal(K key, V value, boolean onlyIfAbsent) {
//        if (key == null || value == null) throw new NullPointerException();
//        int hash = spread(key.hashCode());
//        int binCount = 0;
//        for (ConcurrentHashMap.Node<K,V>[] tab = table;;) {
//            ConcurrentHashMap.Node<K,V> f; int n, i, fh;
//            if (tab == null || (n = tab.length) == 0)
//                tab = initTable(); // 初始化通过cas根据sizeCtl来初始桶
//            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
//                if (casTabAt(tab, i, null, // cas赋值
//                        new ConcurrentHashMap.Node<K,V>(hash, key, value, null)))
//                    break;                   // no lock when adding to empty bin
//            }
//            else if ((fh = f.hash) == MOVED)
//                tab = helpTransfer(tab, f); // cas改变桶的大小
//            else {
//                V oldVal = null;
//                synchronized (f) { // 监视器锁
//                    if (tabAt(tab, i) == f) { // cas获取索引
//                        if (fh >= 0) {
//                            binCount = 1;
//                            for (ConcurrentHashMap.Node<K,V> e = f;; ++binCount) {
//                                K ek;
//                                if (e.hash == hash &&
//                                        ((ek = e.key) == key ||
//                                                (ek != null && key.equals(ek)))) {
//                                    oldVal = e.val;
//                                    if (!onlyIfAbsent)
//                                        e.val = value;
//                                    break;
//                                }
//                                ConcurrentHashMap.Node<K,V> pred = e;
//                                if ((e = e.next) == null) {
//                                    pred.next = new ConcurrentHashMap.Node<K,V>(hash, key,
//                                            value, null);
//                                    break;
//                                }
//                            }
//                        }
//                        else if (f instanceof ConcurrentHashMap.TreeBin) {
//                            ConcurrentHashMap.Node<K,V> p;
//                            binCount = 2;
//                            if ((p = ((ConcurrentHashMap.TreeBin<K,V>)f).putTreeVal(hash, key, // cas 树处理
//                                    value)) != null) {
//                                oldVal = p.val;
//                                if (!onlyIfAbsent)
//                                    p.val = value;
//                            }
//                        }
//                    }
//                }
//                if (binCount != 0) {
//                    if (binCount >= TREEIFY_THRESHOLD)
//                        treeifyBin(tab, i); // 监视器锁和cas替换key对应的值
//                    if (oldVal != null)
//                        return oldVal;
//                    break;
//                }
//            }
//        }
//        addCount(1L, binCount); // cas修改数量
//        return null;
//    }
}
