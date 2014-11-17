package com.miguelcr.cursoandroid.listview;

import java.util.List;

import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DeporteAdapter extends ArrayAdapter<DeporteItem> {
	
	List<DeporteItem> listadoDeportes;
	ListActivity contexto;
	int layoutPlantilla;

	public DeporteAdapter(ListActivity context, int plantilla, List<DeporteItem>listadoDeportes) {
		super(context, plantilla, listadoDeportes);
		
		this.listadoDeportes = listadoDeportes;
		this.contexto = context;
		this.layoutPlantilla = plantilla;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);


		LayoutInflater inflater = contexto.getLayoutInflater();
		convertView = inflater.inflate(layoutPlantilla, null);
		
		DeporteItem itemActual = listadoDeportes.get(position);
		
		// Modifico el icono del deporte de la plantilla
		ImageView iconoDeporte = (ImageView) convertView.findViewById(R.id.imageViewIconoDeporte);
		iconoDeporte.setImageResource(itemActual.getIcono());
		
		TextView nombreDeporte = (TextView) convertView.findViewById(R.id.textViewNombreDeporte);
		nombreDeporte.setText(itemActual.getNombre());
		
		
		
		return convertView;
	}
	
	
	

}
