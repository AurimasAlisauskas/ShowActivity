package com.example.showactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button nextButton;
    private final int request_code = 2;
    private TextView goBackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goBackText = findViewById(R.id.backTextViewID);
        nextButton = findViewById(R.id.buttonID);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Message", "Hello from the other side");
                intent.putExtra("Numbers", 867006657);
                startActivityForResult(intent, request_code);

                //startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("returnText");
                goBackText.setText(result);

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
