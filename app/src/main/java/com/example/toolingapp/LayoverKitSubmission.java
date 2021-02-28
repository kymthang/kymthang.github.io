package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LayoverKitSubmission extends AppCompatActivity {

    TextView tvScrew;
    String sname, number, tools;
    EditText etName, etNum;
    SharedPreferences prf;

    private static final String TAG_SNAME = "sname";
    private static final String TAG_NUMBER = "number";
    private static final String TAG_TOOLS = "tools";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layover_kit_submission);

        Bundle bundle = getIntent().getExtras();
        String result1 = bundle.getString("result1");

        tvScrew = (TextView) findViewById(R.id.tvScrew);
        tvScrew.setText(result1);




        //binding the xml view with java button using its id, R.id.btnTooling
        Button btnBack2 = (Button)findViewById(R.id.btnBack2);
        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);

        etName = (EditText) findViewById(R.id.etName);
        etNum = (EditText) findViewById(R.id.etNum);

        //Button click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                sname = etName.getText().toString();
                number = etNum.getText().toString();
                tools = tvScrew.getText().toString();

                prf = getSharedPreferences("staffname", MODE_PRIVATE); //Open sharedPreference
                SharedPreferences.Editor editor = prf.edit(); //set Editor mode
                editor.putString("sname", sname);
                editor.putString("number", number);
                editor.putString("tools", tools);
                editor.commit();
                finish();
                Intent intent= new Intent(LayoverKitSubmission.this,SummaryPage.class);
                startActivity(intent);
            }
        });

        //Button click Listener
        btnBack2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(LayoverKitSubmission.this,LayoverKitPage.class);
                startActivity(intent);
            }
        });
    }
}