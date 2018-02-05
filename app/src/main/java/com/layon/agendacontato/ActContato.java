package com.layon.agendacontato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class ActContato extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_contato);

        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActCadContatos.class);
        startActivity(it);
    }
}
