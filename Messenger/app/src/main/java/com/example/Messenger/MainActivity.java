package com.example.Messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener((view) -> {
            Intent intent = new Intent(this, ReceiveMessageActivity.class);
            startActivity(intent);
        });*/
    }

    public void onSendMessage(View view)  {
        EditText messageView = (EditText) findViewById(R.id.message);
        String message = messageView.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("message",message);
        startActivity(intent);
    }


}