package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Add_item extends AppCompatActivity {
TextView tv3 ;
EditText etItemName;
Button btnAddItem , btnCancel3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName ;
                itemName = etItemName.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("itemName",itemName);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btnCancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        init();

    }
    private void init(){
        tv3 = findViewById(R.id.tv3);
        etItemName = findViewById(R.id.etItemName);
        btnAddItem = findViewById(R.id.btnAddItem);
        btnCancel3 = findViewById(R.id.btnCancel3);
    }
}