package com.cauataryck.gretabank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText login_user, login_senha;
    Button login_btn;
    TextView signupRedirectText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_user = findViewById(R.id.login_user);
        login_senha = findViewById(R.id.login_senha);
        login_btn = findViewById(R.id.login_btn);
        signupRedirectText = findViewById(R.id.signupRedirectText);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {
                } else {
                    checkUser();
                }
            }
        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    public Boolean validateUsername(){
        String val = login_user.getText().toString();
        if(val.isEmpty()){
            login_user.setError("Usuário não pode estar vazio");
            return false;
        } else {
            login_user.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = login_user.getText().toString();
        if(val.isEmpty()){
            login_senha.setError("Senha não pode estar vazio");
            return false;
        } else {
            login_senha.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String userUsuario = login_user.getText().toString();
        String userSenha = login_senha.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsuario);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    login_user.setError(null);
                    String passwordFromDB = snapshot.child(userUsuario).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userSenha)) {
                        login_user.setError(null);
                        String nameFromDB = snapshot.child(userUsuario).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsuario).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsuario).child("username").getValue(String.class);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        login_senha.setError("Invalid Credentials");
                        login_senha.requestFocus();
                    }
                } else {
                    login_user.setError("User does not exist");
                    login_user.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}