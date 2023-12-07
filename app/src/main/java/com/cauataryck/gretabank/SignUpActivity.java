package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button signup_btn;
    EditText signup_user, signup_senha, signup_RepSenha;
    TextView loginRedirectText;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signup_btn = findViewById(R.id.signup_btn);
        TextView loginRedirectText = findViewById(R.id.loginRedirectText);
        EditText signup_user = findViewById(R.id.signup_user);
        EditText signup_senha = findViewById(R.id.signup_senha);
        EditText signup_RepSenha = findViewById(R.id.signup_RepSenha);
        DB = new DBHelper(this);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signup_user.getText().toString();
                String senha = signup_senha.getText().toString();
                String Rsenha = signup_RepSenha.getText().toString();
                
                if(user.isEmpty() || senha.isEmpty())
                    Toast.makeText(SignUpActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                else{
                    if(senha.equals(Rsenha)){
                        Boolean checkuser = DB.checkEmail(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user, senha);
                            if(insert==true){
                                Toast.makeText(SignUpActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUpActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this, "Usuário já cadastrado", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this, "As senhas não estão iguais, reescreva a senha", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}