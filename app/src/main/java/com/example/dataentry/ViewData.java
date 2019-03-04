package com.example.dataentry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);


        TextView tv = findViewById(R.id.textView);
        HelperClass df = new HelperClass(ViewData.this);


        String s="";
        String[] dataList = df.viewData();

        for( int i = 0; i<dataList.length; i++) {
            s=s+dataList[i]+"\n";

        }
        tv.setText(s);
    }
}
