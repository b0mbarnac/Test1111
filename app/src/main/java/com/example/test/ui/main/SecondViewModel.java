package com.example.test.ui.main;

import androidx.lifecycle.ViewModel;

import com.example.test.Check;
import com.example.test.RandomStatement;

public class SecondViewModel extends ViewModel {

    Check ansCheck = Check.getInstance();
    RandomStatement randomStatement;
    public int CheckAnswer()
    {
        return ansCheck.getCheck();
    }
    public void restart()
    {
        ansCheck.zeroScore();
        randomStatement = new RandomStatement();
        randomStatement.zeroRound();
    }
}
