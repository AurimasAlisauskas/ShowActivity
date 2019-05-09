package com.example.showactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView showMessage;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extra = getIntent().getExtras();

        showMessage = findViewById(R.id.textViewID);
        goBackButton = findViewById(R.id.goBackButtonID);

        if (extra != null) {
            String message = extra.getString("Message");
            int myInt = extra.getInt("Numbers");
            showMessage.setText(message + " " + myInt);
        }

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();

                returnIntent.putExtra("returnText", "Well, Hello Hello!");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}
