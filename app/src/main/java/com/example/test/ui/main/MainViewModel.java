package com.example.test.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.Check;
import com.example.test.RandomStatement;

public class MainViewModel extends ViewModel {
    private int n;
    private final RandomStatement rs = new RandomStatement();
    private static int res = 0;
    public final MutableLiveData <String> question = new MutableLiveData<>();
    public void setQuestion() {

        rs.generate_expression();
        question.postValue(rs.get_expression());
        res = rs.get_result();
    }

    public int getRound() {
        return rs.getRound();
    }

    public String getHelp(){
        Check ansChech = Check.getInstance();
        return ansChech.getHelp(res);
    }

    public void addScore(String result) {
        Check ansChech = Check.getInstance();
        ansChech.getScore(result, res);
    }
}