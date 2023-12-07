package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TransGreta2Activity extends AppCompatActivity {

    private ImageView back_btn;
    private EditText Usuario;
    private String Trans_valor;
    private Button Trans_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_greta2);

        ImageView back_btn = findViewById(R.id.back_btn);

        EditText Usuario = findViewById(R.id.Add_user);
        Button Trans_btn = findViewById(R.id.prox_btn);

        String Trans_valor = getIntent().getStringExtra("Valor");

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransGreta2Activity.this, TransGreta1Activity.class);
                startActivity(intent);
            }
        });

        Trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserDestinatario = Usuario.getText().toString();

                if (!UserDestinatario.isEmpty() && !Trans_valor.isEmpty()) {
                    String[] UsersValidos = {"robertin123", "Skiziz55", "teste3"};
                    boolean UserValido = false;

                    for (String user : UsersValidos) {
                        if (user.equals(UserDestinatario)) {
                            UserValido = true;
                            break;
                        }
                    }

                    if (!UserValido) {
                        Toast.makeText(v.getContext(), "Usuário do destinatário inválido.", Toast.LENGTH_SHORT).show();
                    } else {
                        double valorTrans = Double.parseDouble(Trans_valor);

                        GlobalData globalData = GlobalData.getInstance();
                        double saldoAtual = globalData.getSaldo();

                        if (saldoAtual >= valorTrans) {

                            globalData.setSaldo(saldoAtual - valorTrans);

                            Toast.makeText(v.getContext(), "Transferência realizada com sucesso!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(TransGreta2Activity.this, HomeActivity.class);
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