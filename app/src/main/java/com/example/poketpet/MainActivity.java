package com.example.poketpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_main);

        Button button = findViewById(R.id.profileButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ProfileFix.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.profileButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), CheckPetProfile.class);
                startActivity(intent);
            }
        });

        //화면크기 얻기
        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int displayWidth = display.getWidth();
        int displayHeight = display.getHeight();



        GridView gridView = (GridView) findViewById(R.id.profileGrid1);
        //gridView.setAdapter(new ImageAdapter(this));
        //ImageAdapter adapter = new ImageAdapter(this);
        ImageAdapter adapter = new ImageAdapter(this,displayWidth); //가로크기의 정보를 같이 넘긴다.
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), position+"클릭함",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}