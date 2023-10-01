package com.hzp.algorithm.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现
 * @param <E> 元素类型
 */
//TODO 单锁实现阻塞队列
@SuppressWarnings("all")
public class BlockingQueue1<E> implements BlockingQueue<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0; //元素个数 判断队列是否满了

    @SuppressWarnings("all")
    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    ReentrantLock lock = new ReentrantLock();
    Condition tailWaits = lock.newCondition();//用于poll方法中
    Condition headWaits = lock.newCondition();//用于offer方法中

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            //tail++;
            //防止tail长度溢出
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            //poll方法那边等待队列非空,那么我们就要唤醒poll方法的等待
            headWaits.signal();
        } finally {
            //利用try-finally:为了防止当我们try{}内有异常，那么我们的lock.unlock()解锁操作就没办法执行，所以我们要保证即使出现异常也要执行解锁操作
            lock.unlock();
        }
    }

    @Override
    //对于上面的Offer方法，我们又多了个选择：
    //我们确实可以等待该线程被唤醒,但是要等多久呢？如果我们不需要等那么久，那就可以给这个等待加一个时间上限
    //在规定时间内，我可以等待，但是超过了这个时间，还没有人来唤醒我，那我就不等了，直接提取结束这个等待,可以返回一个false，表示我添加失败
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);

            while (isFull()) {
                //在规定时间内，我可以等待，但是超过了这个时间，还没有人来唤醒我，那我就不等了，直接提取结束这个等待,可以返回一个false，表示我添加失败
                if (t <= 0) {
                    return false;
                }
                t = tailWaits.awaitNanos(t);//最多等待多少纳秒
            }
            array[tail] = e;
            //tail++;
            //防止tail长度溢出
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            //利用try-finally:为了防止当我们try{}内有异常，那么我们的lock.unlock()解锁操作就没办法执行，所以我们要保证即使出现异常也要执行解锁操作
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            //如果队列为空,我们就要让该线程等待，直到offer方法中headWaits.signal();将其唤醒
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null; // help GC
            if (++head == array.length) {
                head = 0;
            }
            size--;
            //offer方法那边等待队列非空,那么我们就要唤醒offer方法的等待
            tailWaits.signal();
            return e;
        } finally {
            //利用try-finally:为了防止当我们try{}内有异常，那么我们的lock.unlock()解锁操作就没办法执行，所以我们要保证即使出现异常也要执行解锁操作
            lock.unlock();
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }
}
