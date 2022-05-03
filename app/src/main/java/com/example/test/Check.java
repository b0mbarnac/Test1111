package com.example.test;

public class Check {
    private int n;
    private int check = 0;

    public void getScore(String result, Integer res) {
        try {
            n = Integer.parseInt(result);
            if (res == n) {
                check += 20;
            }
        } catch (NumberFormatException e ) {

        }
    }
    public String getHelp(int n){
        check -= 10;
        return n+"...";
    }

    public int getCheck(){
        return check;
    }
    private Check(){ }
    private static final Check instance = new Check();
    public static Check getInstance(){
        return instance;
    }
    public void zeroScore()
    {
        check = 0;
    }
}
