package com.example.dataentry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    EditText editText1, editText2, editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);
        editText3 = findViewById(R.id.edt3);

        btn1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(isEmpty()) return;

                ModelClass data = new ModelClass(editText1.getText().toString(),editText2.getText().toString());
                HelperClass df = new HelperClass(MainActivity.this);
                df.AddDataToTable(data);
                Toast.makeText(getApplicationContext(),"Data added successfully!",Toast.LENGTH_LONG).show();
                editText1.setText("");
                editText2.setText("");



            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this,ViewData.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                HelperClass df = new HelperClass(MainActivity.this);
                df.Delete_Bus(editText3.getText().toString());
                editText3.setText("");
            }
        });


    }


    public boolean isEmpty(){
        if(TextUtils.isEmpty(editText1.getText().toString())){
            editText1.setError("REQUIRED");
            return true;
        }
        if(TextUtils.isEmpty(editText2.getText().toString())){
            editText2.setError("REQUIRED");
            return true;
        }
        return false;
    }
}
