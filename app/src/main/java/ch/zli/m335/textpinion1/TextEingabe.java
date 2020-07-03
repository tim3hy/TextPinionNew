package ch.zli.m335.textpinion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;

public class TextEingabe extends AppCompatActivity {

    EditText textEingabe;
    Button txtPinion;
    ImageButton imageButton;
    TextView textView;
    TextView textView1;
    RequestQueue queue;
    String message = "Sie haben eine TextPinion erhalten, Hier klicken um sie zu sehen.";
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
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        TextEingabe.this
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("TextPinion")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intentTxtPinion = new Intent(TextEingabe.this, TextPinion.class);
                startActivity(intentTxtPinion);
                intentTxtPinion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentTxtPinion.putExtra("message",message);
                PendingIntent pendingIntent = PendingIntent.getActivity(TextEingabe.this,0,intentTxtPinion, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());
            }
        });
    }

    /*private void txtPinion(){
        String url = "https://api.aylien.com/api/v1/sentiment";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        TextAPIClient client = new TextAPIClient("5980b674", "be242863b1cc89da35f9034f597b762e");
        SentimentParams.Builder builder = SentimentParams.newBuilder();
        builder.setText("John is a very good football player");
        Sentiment sentiment = null;
        try {
            sentiment = client.sentiment(builder.build());
        } catch (TextAPIException e) {
            e.printStackTrace();
        }
        textView1.setText((CharSequence) sentiment);
    }*/
}