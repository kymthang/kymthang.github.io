package com.example.toolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ToolCategory extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_category);

        //#2 Bind java and xml
        listView = (ListView) findViewById(R.id.list);

        //#3 Defined Array values to show in ListView

        ArrayList<String> listItems = new ArrayList<String>();

        //#4 Adding items to arrayList
        listItems.add("Layover Kit");


        //#5 create ArrayAdapter with listItems

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);




        // ListView Item Click Listener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                //Move page
                Intent intent = new Intent(ToolCategory.this, LayoverKitPage.class);
                intent.putExtra("Tools", listView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });

        //#6 Assign adapter to ListView, show the items in the listView
        listView.setAdapter(adapter);

        //binding the xml view with java button using its id, R.id.btnTooling
        Button btnBack2 = (Button)findViewById(R.id.btnBack2);
       // Button btnReturn = (Button)findViewById(R.id.btnReturn);

        //Tooling Button click Listener
        btnBack2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(ToolCategory.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}