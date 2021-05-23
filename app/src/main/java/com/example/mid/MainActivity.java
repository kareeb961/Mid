package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvTitle , tvSubtitle , tvDate1 ;
ImageView imgEdit , img1 , imgAdd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Create_list.class);
                startActivity(intent);
                
            }
        });
    }
    private void init(){
        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvDate1 = findViewById(R.id.tvDate1);
        imgEdit = findViewById(R.id.imgEdit);
        img1 = findViewById(R.id.img1);
        imgAdd = findViewById(R.id.imgAdd);
    }
}