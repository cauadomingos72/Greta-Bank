package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SacFundActivity extends AppCompatActivity {

    private ImageView back_btn;
    private TextView trans_btn, addFund_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sac_fund);

        GlobalData globalData = GlobalData.getInstance();
        double saldo = globalData.getSaldo();

        TextView saldoTextView = findViewById(R.id.textView6);

        saldoTextView.setText(String.format("$%.2f", saldo));

        ImageView back_btn = findViewById(R.id.back_btn);
        TextView trans_btn = findViewById(R.id.trans_btn);
        TextView addFund_btn = findViewById(R.id.addF_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SacFundActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        addFund_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SacFundActivity.this, AddFundActivity.class);
                startActivity(intent);
            }
        });

        trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SacFundActivity.this, BalanceActivity.class);
                startActivity(intent);
            }
        });
    }
}