package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddFundActivity extends AppCompatActivity {

    private ImageView back_btn;
    private TextView trans_btn, sacFund_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fund);

        ImageView back_btn = findViewById(R.id.back_btn);
        TextView trans_btn = findViewById(R.id.trans_btn);
        TextView sacFund_btn = findViewById(R.id.sacFund_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFundActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        sacFund_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFundActivity.this, SacFundActivity.class);
                startActivity(intent);
            }
        });

        trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFundActivity.this, BalanceActivity.class);
                startActivity(intent);
            }
        });


    }
}