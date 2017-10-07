package com.example.knot.bmicalculator;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("int value",0);
        String bmiText = intent.getStringExtra("string value");

        TextView textData = (TextView)findViewById(R.id.textData);
        textData.setText("ค่า BMI ที่ได้คือ "
                +String.format("%.2f",bmi));

        TextView textData2 = (TextView)findViewById(R.id.textData2);
        textData2.setText("อยูในเกณฑ์ : " +bmiText);

    }

}
