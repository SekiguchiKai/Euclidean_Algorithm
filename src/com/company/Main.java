package com.company;

import java.io.*;

class Main {
    private static final String caution = "自然数を半角空白区切りで2つ入力してください(ただし、本プログラムでは自然に0は含めないものとする)";

    public static void main(String[] args) {
        System.out.println(caution);
        int[] inputs = readInput();
        System.out.println(doEuclideanAlgorithm(inputs[0], inputs[1]));
    }

    private static int[] readInput() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            if (x <= 0 || y <= 0) {
                throw new Exception("");
            }
            return new int[]{x, y};
        } catch (Exception e) {
            System.out.println("入力が不適切です。" + caution);
            return readInput();
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