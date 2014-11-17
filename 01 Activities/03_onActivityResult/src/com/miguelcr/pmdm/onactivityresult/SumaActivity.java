package com.miguelcr.pmdm.onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SumaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suma);

		Bundle extras = getIntent().getExtras();
		Intent resultadoIntent = new Intent(this, MainActivity.class);

		if (extras == null) {
			setResult(RESULT_CANCELED, resultadoIntent);
		} else {

			int operandoUno = extras.getInt("operandoUno");
			int operandoDos = extras.getInt("operandoDos");

			int resultado = operandoUno + operandoDos;

			
			resultadoIntent.putExtra("resultadoOperacion", resultado);
			setResult(RESULT_OK, resultadoIntent);
		}
		
		finish();
	}
}
