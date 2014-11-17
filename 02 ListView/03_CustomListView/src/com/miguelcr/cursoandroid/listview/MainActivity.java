package com.miguelcr.cursoandroid.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private List<DeporteItem> listadoDeportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listadoDeportes = new ArrayList<DeporteItem>();
        listadoDeportes.add(new DeporteItem("Pesas", R.drawable.ic_pesas));
        listadoDeportes.add(new DeporteItem("Tenis", R.drawable.ic_tenis));
        listadoDeportes.add(new DeporteItem("Ciclismo", R.drawable.ic_ciclismo));
        
        DeporteAdapter adaptadorDeportes = new DeporteAdapter(this, R.layout.list_item_deporte, listadoDeportes);
        
        setListAdapter(adaptadorDeportes);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Toast.makeText(this, "Click en elemento "+listadoDeportes.get(position), Toast.LENGTH_LONG).show();
		
	}
    
    
}
