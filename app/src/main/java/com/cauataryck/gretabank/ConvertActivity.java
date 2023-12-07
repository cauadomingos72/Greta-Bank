package com.cauataryck.gretabank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;


public class ConvertActivity extends AppCompatActivity {

    private ImageView back_btn;
    Double valorConvertido = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        Spinner spinner = findViewById(R.id.selectMoedas);
        ImageView back_btn = findViewById(R.id.back_btn);
        EditText numConv = findViewById(R.id.numConv);
        TextView resul = findViewById(R.id.resul);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.opcoes,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (numConv != null && !numConv.getText().toString().isEmpty()) {
                    try {
                        // Tenta converter o valor apenas se numConv não estiver vazio
                        Double valorReal = Double.parseDouble(numConv.getText().toString());

                        String moedaSelecionada = parentView.getItemAtPosition(position).toString(); // Obtendo o valor selecionado no Spinner

                        switch (moedaSelecionada) {
                            case "Real":
                                valorConvertido = valorReal / 1;
                                break;
                            case "Peso Argentino":
                                valorConvertido = valorReal / 0.014;
                                break;
                            case "Dólar Americano":
                                valorConvertido = valorReal / 4.90;
                                break;
                            case "Euro":
                                valorConvertido = valorReal / 5.28;
                                break;
                            case "Libra esterlina":
                                valorConvertido = valorReal / 6.15;
                                break;
                            case "Yuan":
                                valorConvertido = valorReal / 0.69;
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + moedaSelecionada);
                        }

                        resul.setText("Valor em " + moedaSelecionada + ": " + String.valueOf(valorConvertido.floatValue()));

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConvertActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}