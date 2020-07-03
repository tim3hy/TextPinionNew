package ch.zli.m335.textpinion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class TextEingabe extends AppCompatActivity {

    EditText textEingabe;
    Button txtPinion;
    ImageButton imageButton;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_eingabe);

        textEingabe = (EditText) findViewById(R.id.textEingabe);
        txtPinion = (Button) findViewById(R.id.txtPinion);
        imageButton = (ImageButton) findViewById(R.id.imageButton);

    }
}