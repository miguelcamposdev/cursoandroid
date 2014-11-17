package com.miguelcr.cursoandroid.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView lista;
	private String[] listadoDeportes = {"Baloncesto","Fœtbol","Footing","P‡del","Tenis","Atletismoi","Badminton"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lista = (ListView) findViewById(R.id.listViewDeportes);
        
        ArrayAdapter<String> adaptadorDeportes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listadoDeportes);
        
        lista.setAdapter(adaptadorDeportes);
    }
}
