package com.layon.agendacontato.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.widget.*;

public class RepositorioContato {

    private SQLiteDatabase conn;

    public RepositorioContato(SQLiteDatabase conn){

        this.conn = conn;
    }

    public void testeInserirContatos(){
        for(int i=0; i < 10; i++) {
            ContentValues values = new ContentValues();
            values.put("TELEFONE", "5555555");
            conn.insertOrThrow("CONTATO", null, values);
        }
    }

    public ArrayAdapter<String> buscaContatos(Context context){

        ArrayAdapter<String> adpContatos = new ArrayAdapter<String>(context,  android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("CONTATO", null, null, null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String telefone = cursor.getString(1);
                adpContatos.add(telefone);
            } while (cursor.moveToNext());
        }

        return adpContatos;
    }
}
