package com.example.a16pablovc.almacenar_permanente;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnGuardar, btnRecuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", "viraboa@gmail.com");
                editor.putString("nombre", "Viraboa Plus");

                editor.apply();
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String correo = prefs.getString("email", "email_defectivo@email.com");
                String nombre = prefs.getString("eombre", "nombre_defectivo");

                Log.i("Preferencias", "Correo: " + correo);
                Log.i("Preferencias", "Nombre: " + nombre);
            }
        });

    }
}
