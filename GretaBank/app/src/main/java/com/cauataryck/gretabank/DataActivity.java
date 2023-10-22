package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DataActivity extends AppCompatActivity {

    private ImageView back_btn;

    private Button sair_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ImageView back_btn = findViewById(R.id.back_btn);
        Button sair_btn = findViewById(R.id.sair_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        sair_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}