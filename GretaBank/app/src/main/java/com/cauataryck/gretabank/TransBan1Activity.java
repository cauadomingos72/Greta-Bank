package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TransBan1Activity extends AppCompatActivity {

    private ImageView back_btn;
    private Button prox_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_ban1);

        ImageView back_btn = findViewById(R.id.back_btn);
        Button prox_btn = findViewById(R.id.prox_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransBan1Activity.this, TransFundActivity.class);
                startActivity(intent);
            }
        });

        prox_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransBan1Activity.this, TransBan2Activity.class);
                startActivity(intent);
            }
        });
    }
}