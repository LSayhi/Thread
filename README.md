﻿### 多线程基础

1.继承Runnable接口 <br>
2.继承Thread类<br>
3.通过 Callable 和 Future 创建线程 <br>
4.锁对象<br>
 -   a.加锁lock()<br>
 -   b.解锁unlock()<br>
 
5.条件对象<br>
  - a.创建该锁相关的条件对象newCondition<br>
  - b.将线程放在等待集中await()<br>
  - c.解除该等待集中所有线程的阻塞状态signalAll()<br>
  - d.随机解除一个阻塞signal()<br>

6.synchronized关键字(内部锁)<br>
- a.  synchronized关键词可以用来替换lock,unlock
- b.  wait() 替换条件对象的await()
- c.  notify 替换条件对象的signal()
- d.  notifyAll替换条件对象的signalAll()

7.死锁<br>
所有线程互相等待，进入阻塞状态，这种状态就称为死锁。<br>

8.共享变量与线程局部变量

- 共享变量是所有线程共有的变量，存在被并发访问破坏的风险,是线程非安全的；<br>
- 线程局部变量，每个线程都独立拥有一个变量副本，是线程安全的；ThreadLocal<br>

9.锁测试与超时

- tryLock() 尝试获得锁，成功则获得锁，失败则返回False，然后去做其它事。<br>
- tryLock(100,TimeUnit.MILLISECONDS),阻塞时间不超过给定值<br>
- await(long time,TimeUnit unit) 指定时间后，就解除阻塞<br>

10.读锁、写锁


**参考资料：**<br>
《Java核心技术卷1》<br>
[https://www.runoob.com/java/java-multithreading.html][菜鸟教程]<br>
[https://www.cnblogs.com/felixzh/p/5985832.html][Java中继承thread类与实现Runnable接口的区别]<br>
