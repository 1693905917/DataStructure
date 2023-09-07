package com.hzp.algorithm.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.array
 * @Author: ASUS
 * @CreateTime: 2023-09-07  11:10
 * @Description: TODO
 * @Version: 1.0
 */
public class DynamicArray implements Iterable<Integer>{

    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};
   // private int[] array = new int[capacity];

    //添加单个数据
    public void addLast(int element){
//        array[size]=element;
//        size++;
        add(size,element);
    }

    public void add(int index,int element){
        //查询数组容量
        checkAndGrow();
        //判断用户输入的index是否符合我们数组规定的大小内的
        if(index>=0 && index<size){
            //System.arraycopy(A数组,想要从A数组哪个下标开始复制,B数组,将从B数组哪个下标开始粘贴,粘贴多少个)
            System.arraycopy(array,index,array,index+1,size-index);
        }
        //相当于addLast()方法
        array[index]=element;
        size++;
    }

    private void checkAndGrow() {
        if(size==0){
            //容量检查
            array = new int[capacity];
        }else if(size==capacity){
            //进行扩容 我们进行1.5倍的扩容
            capacity+=capacity>>1;
            int[] newArray=new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array=newArray;
        }
    }

    /*
    查询元素
    Params:index-索引位置,在[0,size)区间内
    Return:该索引位置的元素
     */
    public int get(int index){
        return array[index];
    }

    /*
     * @description:
     * @author:  HZP
     * @date: 2023/9/7 14:44
     * 注意：Consumer<不能是基础类型，只能用包装类型>
     * 遍历方法1
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     **/
    public void foreach(Consumer<Integer> consumer){
        for (int i=0;i<size;i++){
            //提供array[i]
            //返回void
            consumer.accept(array[i]);
        }
    }


    //遍历方法2
    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=0;
            @Override
            public boolean hasNext() {  //有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {  //返回当前元素，并且移动到下一个元素
                return array[i++];
            }
        };
    }


    /*
     * @description:遍历方法3  stream遍历
     * @author:  HZP
     * @date: 2023/9/7 14:58
     * @param:
     * @return: stream 流
     **/
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
        //这种方法会把无效的数字也遍历出来，比如我们数组存在一些还没有进行赋值的索引，它默认是给0，这个0就是无效的数值
        //return IntStream.of(array);
    }

    //删除对应的索引元素
    public int remove(int index){
        int removed=array[index];
        //判断我们删除的是否是最后一个元素时
        if(index<size-1){
            System.arraycopy(array,index+1,array,index,size-index-1);
        }
        size--;
        return removed;
    }





}
