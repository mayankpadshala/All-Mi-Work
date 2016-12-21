package com.example.android.educationalquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup groupOne;
    RadioGroup groupTwo;
    RadioGroup groupThree;
    RadioGroup groupFour;
    RadioGroup groupFive;
    RadioGroup groupSix;
    RadioGroup groupSeven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groupOne = (RadioGroup) findViewById(R.id.grp1);
        groupTwo = (RadioGroup) findViewById(R.id.grp2);
        groupThree = (RadioGroup) findViewById(R.id.grp3);
        groupFour = (RadioGroup) findViewById(R.id.grp4);
        groupFive = (RadioGroup) findViewById(R.id.grp5);
        groupSix = (RadioGroup) findViewById(R.id.grp6);
        groupSeven = (RadioGroup) findViewById(R.id.grp7);
    }

    public void submitQuiz(View view) {
        int checkedRadioButtonId = groupOne.getCheckedRadioButtonId();

        if (checkedRadioButtonId == -1) {
            Context context = getApplicationContext();
            CharSequence text = "Please Select an Option for Question One";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            if (checkedRadioButtonId == R.id.opt_1_Q_1) {

            }
        }

    }




}
