package com.example.a16pablovc.almacenar_permanente;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
    RadioButton brojo,bazul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tv=(TextView)findViewById(R.id.tv);
        brojo=(RadioButton)findViewById(R.id.brojo);
        bazul=(RadioButton)findViewById(R.id.bazul);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int color = prefs.getInt("color", 0);
        switch(color) {

            case 0:tv.setTextColor(Color.BLACK); break;
            case 1: tv.setTextColor(Color.BLUE); bazul.setChecked(true);brojo.setChecked(false);break;
            case 2: tv.setTextColor(Color.RED);brojo.setChecked(true);bazul.setChecked(false); break;

    }}


    public void on_casa(View v){
    if(brojo.isChecked()){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("color", 2);

        editor.apply();


    }else{

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("color", 1);


        editor.apply();

    }

    }



}
