package com.diogo.adivinhaonumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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
        sorteio = (int)(Math.random()*101);
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
            mensagem.setText("Acertou");
            tentativas.setText(chutes);

            }else if( numerojogador > sorteio){
                chutes++;
                mensagem.setText("Tente um número menor");
                tentativas.setText(chutes);
            }else {
            chutes++;
            mensagem.setText("Tente um número maior");
            tentativas.setText(chutes);
            }
        }
}
