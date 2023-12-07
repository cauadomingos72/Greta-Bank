package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TransBan2Activity extends AppCompatActivity {

    private ImageView back_btn;
    private EditText Cpf;
    private String Trans_valor;
    private Button Trans_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_ban2);

        ImageView back_btn = findViewById(R.id.back_btn);

        EditText Cpf = findViewById(R.id.Add_cpf);
        Button Trans_btn = findViewById(R.id.prox_btn);

        String Trans_valor = getIntent().getStringExtra("Valor");

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TransBan2Activity.this, TransBan1Activity.class);
                startActivity(intent);
            }
        });

        Trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpfDestinatario = Cpf.getText().toString();

                if (!cpfDestinatario.isEmpty() && !Trans_valor.isEmpty()) {
                    String[] cpfsValidos = {"12345678901", "98765432109", "11122233344"};
                    boolean cpfValido = false;

                    for (String cpf : cpfsValidos) {
                        if (cpf.equals(cpfDestinatario)) {
                            cpfValido = true;
                            break;
                        }
                    }

                    if (!cpfValido) {
                        Toast.makeText(v.getContext(), "CPF do destinatário inválido.", Toast.LENGTH_SHORT).show();
                    } else {
                        double valorTrans = Double.parseDouble(Trans_valor);

                        GlobalData globalData = GlobalData.getInstance();
                        double saldoAtual = globalData.getSaldo();

                        if (saldoAtual >= valorTrans) {

                            globalData.setSaldo(saldoAtual - valorTrans);

                            Toast.makeText(v.getContext(), "Transferência realizada com sucesso!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(TransBan2Activity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(v.getContext(), "Saldo insuficiente para realizar a transferência.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(v.getContext(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}