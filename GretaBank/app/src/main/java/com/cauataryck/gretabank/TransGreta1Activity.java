package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TransGreta1Activity extends AppCompatActivity {

    private ImageView back_btn;
    private Button prox_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_greta1);

        ImageView back_btn = findViewById(R.id.back_btn);
        Button prox_btn = findViewById(R.id.prox_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransGreta1Activity.this, TransFundActivity.class);
                startActivity(intent);
            }
        });

        prox_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransGreta1Activity.this, TransGreta2Activity.class);
                startActivity(intent);
            }
        });
    }
}