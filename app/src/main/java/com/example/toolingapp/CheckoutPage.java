package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutPage extends AppCompatActivity {

    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        Button btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}