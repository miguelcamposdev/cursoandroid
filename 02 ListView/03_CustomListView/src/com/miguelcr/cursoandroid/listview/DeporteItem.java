package com.miguelcr.cursoandroid.listview;

public class DeporteItem {
	private String nombre;
	private int icono;
	
	public DeporteItem(String nombre, int icono) {
		super();
		this.nombre = nombre;
		this.icono = icono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIcono() {
		return icono;
	}
	public void setIcono(int icono) {
		this.icono = icono;
	}
	
	
	
	
}
