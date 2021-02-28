package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;


public class LayoverKitPage extends AppCompatActivity {

    CheckBox ckScrew, ckGrip, ckRachet;
    SharedPreferences prf;
    String screwdriver, grip, rachet, result1;

    private static final String TAG_RESULT1 = "result1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layover_kit_page);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        ckScrew = findViewById(R.id.ckScrew);
        ckGrip = findViewById(R.id.ckGrip);
        ckRachet = findViewById(R.id.ckRachet);


        //sub1 Button click Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("");
                if(ckScrew.isChecked()){
                    result.append("\n" + ckScrew.getText().toString());
                    screwdriver = ckScrew.getText().toString();

                }
                if(ckGrip.isChecked()){
                    result.append("\n" + ckGrip.getText().toString());
                    grip = ckGrip.getText().toString();

                }
                if(ckRachet.isChecked()){
                    result.append("\n" + ckRachet.getText().toString());
                    rachet = ckRachet.getText().toString();

                }
                if(!ckScrew.isChecked() && !ckGrip.isChecked() && !ckRachet.isChecked())
                    result.append("\nNone");




                Message.message(LayoverKitPage.this, result.toString());

               // screwdriver = ckScrew.getText().toString();
               // grip = ckGrip.getText().toString();
              //  rachet = ckRachet.getText().toString();
               // prf = getSharedPreferences("tools", MODE_PRIVATE); //Open sharedPreference
                //SharedPreferences.Editor editor = prf.edit(); //set Editor mode
               // editor.putString("screwdriver", screwdriver);
               // editor.putString("grip", grip);
               // editor.putString("rachet", rachet);
               // editor.commit();

                result1 = result.toString();
                Intent intent = new Intent(LayoverKitPage.this, LayoverKitSubmission.class);
                intent.putExtra("result1", result1);
                startActivity(intent);
            }
        });

        //back1 Button click Listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LayoverKitPage.this, ToolCategory.class);
                startActivity(intent);
            }
        });

    }

}