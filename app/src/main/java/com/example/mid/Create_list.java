package com.example.mid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Create_list extends AppCompatActivity {
TextView tvClist , tvAddItem , tvPriority , tvChooseDate , tvChooseTime , tvRepeat , tvDate2 , tvTime , tvCancel ;
ImageView  imgAddItem , img2 , imgCalendar , imgClock , imgRepeat ;
Button btnHigh ,btnMedium , btnLow , btnSave ;
EditText etName;
int t1Hour , t1Minute ;
    DatePickerDialog.OnDateSetListener setListener;
    final static int ADD_ITEM = 1;
    ArrayList<AddItems> addItem;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ITEM) {
            if (requestCode == RESULT_OK) {
                AddItems i = new AddItems();
                i.setItemName(data.getStringExtra("itemName"));
                addItem.add(i);
                Toast.makeText(this, "Item added Successfully", Toast.LENGTH_SHORT).show();


            }
            else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Add Item Please", Toast.LENGTH_SHORT).show();
            }
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        imgAddItem = findViewById(R.id.imgAddItem);
        imgAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create_list.this, Add_item.class);
                startActivityForResult(intent, ADD_ITEM);
            }
        });

        imgClock = findViewById(R.id.imgClock);
        imgClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Create_list.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                String time = t1Hour +  ":" + t1Minute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    tvTime.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t1Hour,t1Minute);
                timePickerDialog.show();
            }
        });
        imgCalendar = findViewById(R.id.imgCalendar);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Create_list.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate2.setText(date);
            }
        };

        init();
    }
    private void init(){
tvClist = findViewById(R.id.tvClist);
tvAddItem = findViewById(R.id.tvAddItem);
tvPriority = findViewById(R.id.tvPriority);
tvChooseDate = findViewById(R.id.tvChooseDate);
tvChooseTime = findViewById(R.id.tvChooseTime);
tvCancel = findViewById(R.id.tvCancel);
tvRepeat = findViewById(R.id.tvRepeat);
tvDate2 = findViewById(R.id.tvDate2);
tvTime = findViewById(R.id.tvTime);

img2 = findViewById(R.id.img2);

imgRepeat = findViewById(R.id.imgRepeat);
btnHigh = findViewById(R.id.btnHigh);
btnMedium = findViewById(R.id.btnMedium);
btnLow = findViewById(R.id.btnLow);
btnSave = findViewById(R.id.btnSave);
etName = findViewById(R.id.etName);
addItem = new ArrayList<>();
    }
}