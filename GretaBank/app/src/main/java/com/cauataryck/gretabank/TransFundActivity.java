package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TransFundActivity extends AppCompatActivity {

    private ImageView back_btn;

    private LinearLayout paraGreta_btn, paraBanco_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_fund);

        LinearLayout paraGreta_btn = findViewById(R.id.paraGreta_btn);
        LinearLayout paraBanco_btn = findViewById(R.id.paraBanco_btn);
        ImageView back_btn = findViewById(R.id.back_btn);

        paraGreta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransFundActivity.this, TransGreta1Activity.class);
                startActivity(intent);
            }
        });

        paraBanco_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransFundActivity.this, TransBan1Activity.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransFundActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}