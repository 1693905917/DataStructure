package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-16  20:15
 * @Description: TODO  杨辉三角
 * @Version: 1.0
 */
public class E03PascalTriangle {

    //普通版
    //利用行列的i,j进行遍历
    private static int element(int i,int j){
        if(j==0|| i==j){  //最左与最右都是1
            return 1;
        }
        return element(i-1,j-1)+element(i-1,j);  //其他都是本行列的数字（i,j）=(i-1,j-1)+(i-1,j);
    }

    private static void printSpace(int n,int i){
        int num=(n-1-i)*2;//(n-1-i)*2的“2”与你打印的%-4d有关系，如果是%-4d则是2  如果是%-6d则是3
        for (int j=0;j<num;j++){
            System.out.print(" ");
        }
    }
    //打印多少行
    public static void print(int n){  //以等边三角形显示
        for (int i=0;i<n;i++){
            printSpace(n,i);
            for (int j=0;j<=i;j++){
                System.out.printf("%-4d", element(i,j));
            }
            System.out.println();
        }
    }


    //二维数组记忆版
    //利用行列的i,j进行遍历
    private static int elementMemory(int[][] triangle,int i,int j){
        //对于已经存储到二维数组中的值进行判断
        //由于triangle数组初始化为0进行判断
        if(triangle[i][j]>0){
            return triangle[i][j];
        }

        if(j==0|| i==j){  //最左与最右都是1
            triangle[i][j]=1;
            return 1;
        }
        return elementMemory(triangle,i-1,j-1)+elementMemory(triangle,i-1,j);  //其他都是本行列的数字（i,j）=(i-1,j-1)+(i-1,j);
    }

    //打印多少行
    public static void PrintMemory(int n){  //以等边三角形显示
        //用二维数组来存储数值
        int[][] triangle=new int[n][];
        for (int i=0;i<n;i++){
            //每当创建一行来创建对应的列  实现动态创建
            triangle[i]=new int[i+1];
            printSpace(n,i);
            for (int j=0;j<=i;j++){
                System.out.printf("%-4d", elementMemory(triangle,i,j));
            }
            System.out.println();
        }
    }


    //一维数组记忆版
    private static void createRow(int[] row,int i){
        if(i==0){
            row[0]=1;
            return;
        }
        for (int j=i;j>0;j--){
            row[j]=row[j]+row[j-1];
        }
    }

    private static void printMemoryPlus(int n){
        int[] row=new int[n];
        for (int i=0;i<n;i++){
            createRow(row,i);
            printSpace(n,i);
            for (int j=0;j<=i;j++){
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }






    public static void main(String[] args) {
        printMemoryPlus(10);
    }



}
