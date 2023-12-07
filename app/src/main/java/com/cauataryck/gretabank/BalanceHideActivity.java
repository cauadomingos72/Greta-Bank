package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BalanceHideActivity extends AppCompatActivity {

    ImageView show_btn, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_hide);

        ImageView show_btn = findViewById(R.id.show_btn);
        ImageView back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceHideActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceHideActivity.this, BalanceActivity.class);
                startActivity(intent);
            }
        });
    }
}