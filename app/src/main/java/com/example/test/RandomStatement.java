package com.example.test;

import java.util.Random;

public class RandomStatement {

    private int first_number;
    private int second_number;
    private int result;
    private int tmp_oper;
    private String operation;
    private static int round = 0;

    public void generate_expression() {
        int max = 200;
        Random r = new Random();
        first_number = r.nextInt(max-1) + 1;
        tmp_oper = r.nextInt(4);
        switch (tmp_oper) {
            case 0:
                operation = "+";
                second_number = r.nextInt(max - first_number);
                result = first_number + second_number;
                break;
            case 1:
                operation = "-";
                second_number = r.nextInt(first_number);
                result = first_number - second_number;
                break;
            case 2:
                operation = "*";
                int a = Math.round(max / first_number);
                second_number = r.nextInt((int) (a));
                result = first_number * second_number;
                break;
            case 3:
                operation = "/";
                int b = Math.round(max / first_number);
                int c = Math.max(first_number,b);
                second_number = Math.min(first_number,b);
                first_number = c*second_number;
                result = first_number/second_number;
                break;
        }
    }

    public String get_expression() {
        round++;
        return Integer.toString(first_number) + operation + Integer.toString(second_number);
    }

    public int get_result() {
        return result;
    }

    public int getRound() {
        return round;
    }
    public void zeroRound(){
        round = 0;
    }
}
