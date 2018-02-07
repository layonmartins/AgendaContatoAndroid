package com.layon.agendacontato;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.database.sqlite.*;
import android.database.*;

public class ActContato extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAdicionar;
    private EditText edtPesquisa;
    private ListView lstContatos;
    private DataBase dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_contato);

        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        edtPesquisa = (EditText)findViewById(R.id.edtPesquisa);
        lstContatos = (ListView)findViewById(R.id.lstContatos);
        btnAdicionar.setOnClickListener(this);
        try {
            dataBase = new DataBase(this);
            conn = dataBase.getReadableDatabase();

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso!");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }catch(SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco: " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActCadContatos.class);
        startActivity(it);
    }
}
