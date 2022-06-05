package com.example.hmwk31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button send_msg;
private EditText email;
private EditText theme;
private EditText write_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        send_msg = findViewById(R.id.send_msg);
        theme = findViewById(R.id.theme);
        write_msg = findViewById(R.id.write_msg);
        send_msg.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.getText().toString(), null));
            intent.putExtra(Intent.EXTRA_EMAIL, email.getText().toString());
            intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, write_msg.getText().toString());
            startActivity(Intent.createChooser(intent, "send"));
        });

    }
}