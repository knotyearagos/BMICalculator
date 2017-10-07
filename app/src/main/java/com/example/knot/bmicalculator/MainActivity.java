package com.example.knot.bmicalculator;

//import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    private EditText nHeightEditText, nWeightEditText;
    private Button nCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        nWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        nCalculateButton = (Button) findViewById(R.id.calculate_button);

        //สร้าง object ที่ทำหน้าที่เป็น listener ของปุ่ม
        //MyListener listenner = new MyListener();
        //กำหนด object ที่เป็น listener ของปุ่ม
        nCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = nHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(nWeightEditText.getText().toString());

                final Double bmi = weight / ((height / 100) * (height / 100));
                String bmiText = getBmiText(bmi);
                //String result = String.format("ค่า BMI ที่ได้ คือ %.2f\n\nอยูในเกณฑ์ : %s",bmi,bmiText);

                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish(); //ปิด activity
                        nHeightEditText.setText("");
                        nWeightEditText.setText("");
                        nCalculateButton.requestFocus();

                    }

                });
                dialog.show();*/

                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
                intent.putExtra("int value",bmi);
                intent.putExtra("string value",bmiText);
                startActivity(intent);
            }

    /*private class MyListener implements View.OnClickListener {

        @Override
        public  void onClick(View v){
            Toast t = Toast.makeText(
                    MainActivity.this,  //context ตัวชี้ว่าใช้คำสั่งในคลาสไหน
                    "Hello",            //คำที่ต้องการแสดงใน toast
                    Toast.LENGTH_SHORT  //ระยะเวลาในการแสดง
            );
            t.show();
        }
    }*/


/*การสร้าง Listener มี 3 วิธี
    1. ใช้ inner Class เป็น Listener คือการสร้าง class มาเก็บ listener ใหม่
    2. ใช้แอคทิวิตี้เป็น Listener ใช้ implements ใน class mainactivity
    3. ใช้ annonimous inner class เป็น Listener คือการสร้าง object โดยไม่ต้องสร้าง class
    ตัวอย่าง
    Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
 */
        });
    }
    private String getBmiText(Double bmi) {

        String bmiText = "";
        if(bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }
        else if (bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }
        else if (bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }
        else{
            bmiText = "น้ำหนักมากกว่าปกติ (อ้วน)";
        }
        return bmiText;
    }
}