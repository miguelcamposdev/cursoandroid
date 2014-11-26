package com.miguelcr.cursonandroid.listactivity;

public class SistemaOperativo {
	private String nombre;
	private int anyo;
	private int icono;
	
	public SistemaOperativo(String nombre, int anyo, int icono) {
		super();
		this.nombre = nombre;
		this.anyo = anyo;
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getIcono() {
		return icono;
	}

	public void setIcono(int icono) {
		this.icono = icono;
	}
	
	
	
	
}
