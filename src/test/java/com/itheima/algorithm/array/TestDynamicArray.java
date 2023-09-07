package com.itheima.algorithm.array;

import com.hzp.algorithm.array.DynamicArray;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.List;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.itheima.algorithm.array
 * @Author: ASUS
 * @CreateTime: 2023-09-07  14:41
 * @Description: TODO
 * @Version: 1.0
 */
public class TestDynamicArray {

    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.foreach((e)->{
            System.out.println(e);
        });
    }


    @Test
    //测试迭代器遍历
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        //我们使用的是迭代器遍历，默认会调用hasNext()、next()方法
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    //测试流的遍历
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.stream().forEach((e)->{
            System.out.println(e);
        });
    }

    @Test
    //测试删除
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        int remove = dynamicArray.remove(2);
        //以下注释掉的可以简化：
//        System.out.println(remove);
//        System.out.println("-----------------");
//        dynamicArray.stream().forEach(ele->{
//            System.out.println(ele);
//        });
        //简化版:
        Assert.assertEquals(3,remove);
        //注意：
        //使用这个assertIterableEquals方法前，要保证你的参数dynamicArray实现了Iterable接口
        //Assert.assertIterableEquals(List.of(1,2,4,5),dynamicArray);

    }

}
