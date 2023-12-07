package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BalanceActivity extends AppCompatActivity {

    ImageView hide_btn, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        GlobalData globalData = GlobalData.getInstance();
        double saldo = globalData.getSaldo();

        TextView saldoTextView = findViewById(R.id.qtd_saldo);

        saldoTextView.setText(String.format("$%.2f", saldo));

        ImageView hide_btn = findViewById(R.id.hide_btn);
        ImageView back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        hide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceActivity.this, BalanceHideActivity.class);
                startActivity(intent);
            }
        });
    }
}