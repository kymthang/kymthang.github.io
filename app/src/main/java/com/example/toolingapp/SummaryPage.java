package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryPage extends AppCompatActivity {

    SharedPreferences prf;
    String sname, number;
    TextView tvStaff, tvStaffNum, tvTools;
    Button btnOk;

    private static final String TAG_SNAME = "sname";
    private static final String TAG_NUMBER = "number";
    private static final String TAG_TOOLS = "tools";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);

        tvStaff = (TextView) findViewById(R.id.tvStaff);
        tvStaffNum = (TextView) findViewById(R.id.tvStaffNum);
        tvTools = (TextView) findViewById(R.id.tvTools);

        prf = getSharedPreferences("staffname", MODE_PRIVATE);
        tvStaff.setText(prf.getString("sname", null));
        tvStaffNum.setText(prf.getString("number", null));
        tvTools.setText(prf.getString("tools", null));

        //binding the xml view with java button using its id, R.id.btnTooling
        Button btnOk = (Button)findViewById(R.id.btnOk);

        //Tooling Button click Listener
        btnOk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(SummaryPage.this,CheckoutPage.class);
                startActivity(intent);
            }
        });
    }
}