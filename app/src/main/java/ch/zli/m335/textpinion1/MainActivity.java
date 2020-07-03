package ch.zli.m335.textpinion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonTxtAnal;
    Button buttonOptionen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOptionen = (Button) findViewById(R.id.buttonOptionen);
        buttonTxtAnal = (Button) findViewById(R.id.buttonTxtAnal);

        buttonTxtAnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTxtAnal = new Intent(MainActivity.this, TextEingabe.class);
                startActivity(intentTxtAnal);
            }
        });
        buttonOptionen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOptionen = new Intent(MainActivity.this, Optionen.class);
                startActivity(intentOptionen);
            }
        });
    }

}