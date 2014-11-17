package com.pmdm.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConsultaCondiciones extends Activity {
	
	private Button btnAceptar, btnRechazar;
	private TextView txt;
	private String nombreRegistro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_condiciones);
		
		Bundle datos =  getIntent().getExtras();
		nombreRegistro = datos.getString("nombreRegistro");
		
		// Personalizo el saludo con el nombre recibido.
		txt = (TextView)findViewById(R.id.txtNombreRegistro);
		txt.setText("Hola "+nombreRegistro+",");
		
		btnAceptar = (Button) findViewById(R.id.buttonAceptar);
		btnRechazar = (Button) findViewById(R.id.buttonRechazar);
		
		// SOLUCIÓN 2
		/*
		if(nombreRegistro.equals("")) {
			Intent resultado = new Intent(ConsultaCondiciones.this,MainActivity.class);
			setResult(RESULT_CANCELED, resultado);
			resultado.putExtra("resultado", "1");
			finish();
		}
		*/
		
		btnAceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				Intent resultado = new Intent(ConsultaCondiciones.this,MainActivity.class);	
				setResult(RESULT_OK, resultado);
				finish();
				
			}
		});
		
		btnRechazar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent resultado = new Intent(ConsultaCondiciones.this,MainActivity.class);
				setResult(RESULT_CANCELED, resultado);
				finish();
				
			}
		});

		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consulta_alumno, menu);
		return true;
	}

}
