package com.example.user.symptomchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    String disease="-";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.diseases));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void goSecondActivity(View v)
    {

        Intent goToSecond=new Intent(this,SecondActivity.class);
        startActivity(goToSecond);
        finish();
    }

    public void goThirdActivity(View v)
    {
        Intent goToThird=new Intent();
        goToThird.setClass(this,ThirdActivity.class);
        if(disease.equals("-"))
            Toast.makeText(getApplicationContext(),"Select an option!!",
                    Toast.LENGTH_LONG).show();
        else
        {
            goToThird.putExtra("disease",disease);
            startActivity(goToThird);
            finish();
        }

    }

    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        disease=parent.getItemAtPosition(pos).toString();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}