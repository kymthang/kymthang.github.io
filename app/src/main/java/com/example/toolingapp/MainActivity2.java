package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //binding the xml view with java button using its id, R.id.btnTooling
        Button btnLoan = (Button)findViewById(R.id.btnLoan);
        Button btnReturn = (Button)findViewById(R.id.btnReturn);

        //Tooling Button click Listener
        btnLoan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(MainActivity2.this,ToolCategory.class);
                startActivity(intent);
            }
        });


        //Tooling Button click Listener
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}