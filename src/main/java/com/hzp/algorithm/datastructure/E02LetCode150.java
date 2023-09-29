package com.hzp.algorithm.datastructure;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-29  14:43
 * @Description: TODO
 * @Version: 1.0
 */
public class E02LetCode150 {

    /*
什么叫中缀、后缀？
答：  1 + 2  ：中缀
	  1 2 +  ：后缀

	"4","13","5","/","+"

	第一步:	| 5 | ----顶部
			| 13|
			| 4 | ----底部
			_____

	第二步:	| 5 | ----顶部
			| 13|
			| 4 | ----底部

	第三步:	| 5 | ----顶部
			| 13|
			| 4 | ----底部
		将5、13 pop()出来然后继续“/”操作，将"/"操作后的结果（13/5==2）再压栈

	第四步:	|  	| ----顶部
			| 2	|
			| 4 | ----底部
			_____
		将2、4 pop()出来然后继续“+”操作，将"+"操作后的结果(2+4==6)再压栈
    "4","13","5","/","+"
	第五步：当字符串都执行完毕以后，栈中就只剩下最后的结果值

    - 遇到数字压入栈
    - 遇到运算符, 就从栈弹出两个数字做运算, 将结果压入栈
    - 遍历结束, 栈中剩下的数字就是结果
 */

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+" :{
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a + b);
                    break;
                }
                case "-" : {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a - b);
                    break;
                }
                case "*" : {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a * b);
                    break;
                }
                case "/" : {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a / b);
                    break;
                }
                //t是字符串，所以我们要转换成数字再压栈
                default :numbers.push(Integer.parseInt(t));
            }
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        String[] tokens={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new E02LetCode150().evalRPN(tokens));
    }



}
