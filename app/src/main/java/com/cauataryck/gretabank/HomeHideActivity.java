package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeHideActivity extends AppCompatActivity {

    private LinearLayout saldo_btn, loja_btn, convert_btn, invest_btn;
    private ImageView show_btn, profile_btn;
    private Button addFund_btn, transf_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hide);

        LinearLayout saldo_btn = findViewById(R.id.saldo_btn);
        LinearLayout loja_btn = findViewById(R.id.loja_btn);
        LinearLayout convert_btn = findViewById(R.id.convert_btn);
        LinearLayout invest_btn = findViewById(R.id.invest_btn);
        ImageView show_btn = findViewById(R.id.show_btn);
        ImageView profile_btn = findViewById(R.id.profile_btn);
        Button addFund_btn = findViewById(R.id.addFund_btn);
        Button transf_btn = findViewById(R.id.transfFund_btn);

        saldo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, BalanceActivity.class);
                startActivity(intent);
            }
        });

        invest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, InvestActivity.class);
                startActivity(intent);
            }
        });

        convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, ConvertActivity.class);
                startActivity(intent);
            }
        });

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });

        loja_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        addFund_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, AddFundActivity.class);
                startActivity(intent);
            }
        });

        transf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, TransFundActivity.class);
                startActivity(intent);
            }
        });

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeHideActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}