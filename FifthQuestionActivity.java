package com.example.android.mathquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class FifthQuestionActivity extends AppCompatActivity {
    public boolean answerQuestion5 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.answer1:
                if (checked) {
                    answerQuestion5 = false;
                    Intent intentSecondQuestion =  new Intent(view.getContext(),FailActivity.class);
                    startActivity(intentSecondQuestion);
                    break;}
            case R.id.answer2:
                if (checked){
                    answerQuestion5 = false;
                    Intent intentSecondQuestion =  new Intent(view.getContext(),FailActivity.class);
                    startActivity(intentSecondQuestion);
                    break;}
            case R.id.answer3:
                if (checked){
                    answerQuestion5 = true;
                    boolean checkAnswer = checkAnswers(FirstQuestionActivity.answerQuestion1,SecondQuestionActivity.answerQuestion2,
                            ThirdQuestionActivity.answerQuestion3,FourthQuestionActivity.answerQuestion4,answerQuestion5);
                    if(!checkAnswer ) {
                        Intent intentFail =  new Intent(view.getContext(),FailActivity.class);
                        startActivity(intentFail);
                    }
                    else {
                        Intent intentCongrats = new Intent(view.getContext(), CongratsActivity.class);
                        startActivity(intentCongrats);
                        break;
                    }
                }

        }}

    public static boolean checkAnswers(boolean ans1, boolean ans2, boolean ans3, boolean ans4, boolean ans5){
        if(ans1 == true && ans2 == true && ans3 == true && ans4 == true && ans5 == true)
            return true;
        return  false;
    }

}
