package com.company;

import java.io.*;

class Main {
    private static int x = -1;
    private static int y = -1;
    private static final String caution = "自然数を半角空白区切りで2つ入力してください(ただし、本プログラムでは自然に0は含めないものとする)";

    public static void main(String[] args) throws Exception {
        System.out.println(caution);
        readInput();
        System.out.println(doEuclideanAlgorithm(x, y));
    }

    private static void readInput() throws Exception {
        try {
            while (x <= 0 || y <= 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String[] str = bufferedReader.readLine().split(" ");
                x = Integer.parseInt(str[0]);
                y = Integer.parseInt(str[1]);
                if (x <= 0 || y <= 0) {
                    System.out.println("入力が不適切です" + caution);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("入力が不適切です" + caution);
            readInput();
        } catch (NumberFormatException ne) {
            System.out.println("入力が不適切です" + caution);
            readInput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int doEuclideanAlgorithm(int x, int y) {
        int biggerNum = Math.max(x, y);
        int smallerNum = Math.min(x, y);

        // 大きい方から小さい方を割った余を求める
        int surplus = biggerNum % smallerNum;

        // 割り切れていれば、それを返す
        if (surplus == 0) {
            return smallerNum;
        }
        // 割り切れなければ再帰的に自信を呼び出す
        surplus = doEuclideanAlgorithm(smallerNum, surplus);

        return surplus;
    }
}