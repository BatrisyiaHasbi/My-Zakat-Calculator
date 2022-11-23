package com.example.myzakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etweightvalue, etgoldvalue;
    RadioButton radioKeep, radioWear;
    String goldType;
    Button submit, reset;
    Double weightV, goldV, tValue, uruf, zakatpay, tZakat;
    TextView totalGold, zakatPay, totalZakat; //display answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etweightvalue = findViewById(R.id.etweightvalue);
        etgoldvalue = findViewById(R.id.etgoldvalue);
        radioKeep = findViewById(R.id.radioKeep);
        radioWear = findViewById(R.id.radioWear);
        submit = findViewById(R.id.submitButton);
        reset = findViewById(R.id.resetButton);
        totalGold = findViewById(R.id.totalGold);
        zakatPay = findViewById(R.id.zakatPay);
        totalZakat = findViewById(R.id.totalZakat);
        Clicklistener();
    }
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about1:
                //Toast.makeText(this, "About", Toast.LENGTH_LONG.show();
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void Clicklistener(){
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etweightvalue.setText("");
                etgoldvalue.setText("");
                totalGold.setText(" Total Value of Gold:");
                zakatPay.setText(" Zakat Payable :");
                totalZakat.setText(" Total Zakat :");
            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (etweightvalue.getText().toString().isEmpty() &&
                        etgoldvalue.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Input Missing!!", Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }

                weightV=Double.parseDouble(etweightvalue.getText().toString());
                goldV=Double.parseDouble(etgoldvalue.getText().toString());
                if (radioKeep.isChecked()) {
                    goldType = radioKeep.getText().toString();
                    tValue = weightV * goldV;
                    uruf = weightV - 85;
                    if(uruf >= 0.0){
                        zakatpay = uruf * goldV;
                        tZakat = zakatpay * 0.025;
                    }
                    else{
                        zakatpay = 0.00;
                        tZakat = zakatpay * 0.025;
                    }
                    totalGold.setText(" Total Value of Gold: RM" +
                            String.valueOf(tValue));
                    zakatPay.setText(" Zakat Payable : RM" +
                            String.valueOf(zakatpay));
                    totalZakat.setText(" Total Zakat : RM" +
                            String.valueOf(tZakat));
                }
                else if (radioWear.isChecked()) {
                    goldType = radioKeep.getText().toString();
                    tValue = weightV * goldV;
                    uruf = weightV - 200;
                    if(uruf >= 0.0){
                        zakatpay = uruf * goldV;
                        tZakat = zakatpay * 0.025;
                    }
                    else{
                        zakatpay = 0.00;
                        tZakat = zakatpay * 0.025;
                    }
                    totalGold.setText(" Total Value of Gold: RM"+
                            String.valueOf(tValue));
                    zakatPay.setText(" Zakat Payable : RM" +
                            String.valueOf(zakatpay));
                    totalZakat.setText(" Total Zakat : RM" +
                            String.valueOf(tZakat));
                }
            }
        });
    }
}