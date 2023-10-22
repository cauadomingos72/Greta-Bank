package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShopActivity extends AppCompatActivity {

    private ImageView back_btn;

    private LinearLayout loja1_btn, loja2_btn, loja3_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ImageView back_btn = findViewById(R.id.back_btn);
        LinearLayout loja1_btn = findViewById(R.id.loja1_btn);
        LinearLayout loja2_btn = findViewById(R.id.loja2_btn);
        LinearLayout loja3_btn = findViewById(R.id.loja3_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        loja1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, ShopStore1Activity.class);
                startActivity(intent);
            }
        });

        loja2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, ShopStore2Activity.class);
                startActivity(intent);
            }
        });

        loja3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, ShopStore3Activity.class);
                startActivity(intent);
            }
        });
    }
}