package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFundActivity extends AppCompatActivity {

    private ImageView back_btn;
    private TextView trans_btn, sacFund_btn;
    private EditText editTextValor;
    private Button dep_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fund);

        GlobalData globalData = GlobalData.getInstance();
        double saldo = globalData.getSaldo();

        editTextValor = findViewById(R.id.Qtd_fundos);

        TextView saldoTextView = findViewById(R.id.textView6);

        saldoTextView.setText(String.format("$%.2f", saldo));

        ImageView back_btn = findViewById(R.id.back_btn);
        TextView trans_btn = findViewById(R.id.trans_btn);
        TextView sacFund_btn = findViewById(R.id.sacFund_btn);
        Button dep_btn = findViewById(R.id.dep_btn);

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

        dep_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorDigitado = editTextValor.getText().toString();

                if (!valorDigitado.isEmpty()) {
                    double valor = Double.parseDouble(valorDigitado);
                    GlobalData globalData = GlobalData.getInstance();
                    double saldoAtual = globalData.getSaldo();
                    globalData.setSaldo(saldoAtual + valor);
                    Intent intent = new Intent(AddFundActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "Saldo adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(v.getContext(), "Erro em adicionar o saldo!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}