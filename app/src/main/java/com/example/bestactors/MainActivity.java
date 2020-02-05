package com.example.bestactors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    int[] itemImage={R.drawable.dwaynejohnson,R.drawable.tomhanks,R.drawable.adamsandler,R.drawable.jeromeallen,R.drawable.robertdowney,R.drawable.tomcruise,R.drawable.bradleycooper,R.drawable.chrishemsworth,R.drawable.leonardodicaprio,R.drawable.vindiesel,};
    String[] itemName={"Dwayne Johnson","Thomas Jeffrey Hanks","Adam Sandler","Jerome Allen","Robert Dovney","Tom Cruise","Bradley Cooper","Chris Hemsworth","Leonardo DiCaprio","Vin Diesel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        /*Button crashButton = new Button(this);
        crashButton.setText("Crash!");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        });

        addContentView(crashButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));*/


        RecyclerView rvList=findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));


        rvList.setAdapter(new UserAdapter(itemImage,itemName,MainActivity.this));

//        ImageButton backs=findViewById(R.id.ivBack);
//
//        backs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
