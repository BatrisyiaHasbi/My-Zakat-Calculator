package com.example.myzakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textViewLink);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        back = findViewById(R.id.backButton);
        Clicklistener();
    }
    public void Clicklistener(){
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}