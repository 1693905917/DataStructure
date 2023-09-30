package com.hzp.algorithm.deque;

/*
 * @description:  Deque:  Double  ended  queue
 * @author:  HZP
 * @date: 2023/9/30 9:32
 * @param:
 * @return:
 **/

public interface Deque <E>{
    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
