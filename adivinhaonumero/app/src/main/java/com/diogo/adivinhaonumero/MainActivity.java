package com.diogo.adivinhaonumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener {

    EditText numero;
    TextView mensagem;
    int sorteio;
    int chutes;

    TextView tentativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagem = findViewById(R.id.mensagem);
        tentativas = findViewById(R.id.tentativas);
        numero = findViewById(R.id.numero);
        numero.setOnKeyListener(this);
        sorteio = (int) (Math.random() * 101);
        final Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                funcaoAcertou();
            }
        });

    }



    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() != KeyEvent.ACTION_DOWN){
            funcaoAcertou();
            return true;
        }
        return false;
    }

    private void funcaoAcertou() {
        int numerojogador = Integer.parseInt(numero.getText().toString());
        if (numerojogador == sorteio){
            chutes++;
            mensagem.setText("Você acertou o número");
            tentativas.setText(String.valueOf(chutes));
            numero.setText("");

            }else if( numerojogador > sorteio){
                chutes++;
                mensagem.setText("Tente um numero menor");
                tentativas.setText(String.valueOf(chutes));
                numero.setText("");
            }else {
                chutes++;
                mensagem.setText("Tente um número maior");
                tentativas.setText(String.valueOf(chutes));
                numero.setText("");
            }
        }
}
