package com.example.user.symptomchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    String question[]={ "How severe is your fever fever?",
                        "Do you have body ache and fatigue?",
                        "Do you have a runny or stuffy nose?",
                        "Do you have a sore throat?",
                        "Do you have a loss of appetite?",
                        "Do you sneeze a lot?",
                        "Since how many days are you experiencing these symptoms?"};
    String option[][]={{"No Fever","Mild","Severe"},
                        {"None","Mild","Severe"},
                        {"None","Common","Less Common"},
                        {"None","Common","Less Common"},
                        {"No loss","Reduced","Loss"},
                        {"None","Common","Less Common"},
                        {"1-2","3-10","11-15"}};
    int answer[]={0,0,0};
    int count=0;
    final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
    final TextView text=(TextView)findViewById(R.id.textQuestion);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setRadioButtonText();
    }
    public void next(View v){
        int selectID=(rg.getCheckedRadioButtonId());
        if(selectID==-1) {
            Toast.makeText(getApplicationContext(),
                    "Select an option!!",
                    Toast.LENGTH_LONG).show();
        } else
        {
            count++;
            if(count==question.length)
            {

                Intent goToThird2 = new Intent();
                goToThird2.setClass(this,ThirdActivity.class);
                goToThird2.putExtra("disease",getDisease());
                startActivity(goToThird2);
            }
            else
            {
                int index = rg.indexOfChild(findViewById(selectID));
                answer[index]++;
                setRadioButtonText();
            }
        }
    }
    public void setRadioButtonText()
    {
        text.setText(question[count]);
        for(int i=0;i<rg.getChildCount();i++)
            ((RadioButton)rg.getChildAt(i)).setText(String.valueOf(option[count][i]));
    }
    public String getDisease()
    {
        int max=0;
        for(int i=1;i<answer.length;i++)
            if(answer[i]>answer[max])
                max=i;
        switch(max)
        {
            case 1:return "Cold";
            case 2:return "Flu";
        }
        return "Others";

    }
}

