package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TransBan1Activity extends AppCompatActivity {

    private ImageView back_btn;
    private Button prox_btn;
    private EditText valor_transf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_ban1);

        GlobalData globalData = GlobalData.getInstance();
        double saldo = globalData.getSaldo();

        TextView saldoTextView = findViewById(R.id.textView6);

        saldoTextView.setText(String.format("$%.2f", saldo));

        ImageView back_btn = findViewById(R.id.back_btn);
        Button prox_btn = findViewById(R.id.prox_btn);
        EditText valor_transf = findViewById(R.id.Qtd_fundos);

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
                String valorTransf = valor_transf.getText().toString();

                if (!valorTransf.isEmpty()) {
                    Intent intent = new Intent(TransBan1Activity.this, TransBan2Activity.class);
                    intent.putExtra("Valor", valorTransf);
                    startActivity(intent);
                }
            }
        });
    }
}