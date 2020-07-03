package ch.zli.m335.textpinion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;

public class TextEingabe extends AppCompatActivity {

    EditText textEingabe;
    Button txtPinion;
    ImageButton imageButton;
    String textView;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_eingabe);

        textEingabe = (EditText) findViewById(R.id.textEingabe);
        txtPinion = (Button) findViewById(R.id.txtPinion);
        imageButton = (ImageButton) findViewById(R.id.imageButton);

        textEingabe.setHint("Text eingeben");

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActiv= new Intent(TextEingabe.this, MainActivity.class);
                startActivity(intentMainActiv);
            }
        });

        txtPinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //txtPinion();
                Intent intentTxtPinion = new Intent(TextEingabe.this, TextPinion.class);
                startActivity(intentTxtPinion);
            }
        });
    }

    private void txtPinion(){

        TextAPIClient client = new TextAPIClient("5980b674", "be242863b1cc89da35f9034f597b762e");
        SentimentParams.Builder builder = SentimentParams.newBuilder();
        builder.setText("John is a very good football player");
        Sentiment sentiment = null;
        try {
            sentiment = client.sentiment(builder.build());
        } catch (TextAPIException e) {
            e.printStackTrace();
        }
        System.out.println(sentiment);
    }
}