package com.miguelcr.pmdm.onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText operandoUno, operandoDos;
	private TextView labelResultado;
	private String op1, op2;
	static final int DO_SUMA = 1;
	static final int DO_RESTA = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		operandoUno = (EditText) findViewById(R.id.editTextOperando1);
		operandoDos = (EditText) findViewById(R.id.editTextOperando2);
		labelResultado = (TextView) findViewById(R.id.textViewResult);
		
	}

	public void realizarSuma(View v) {
		op1 = operandoUno.getText().toString();
		op2 = operandoDos.getText().toString();
		
		Intent i = new Intent(this, SumaActivity.class);
		i.putExtra("operandoUno", op1);
		i.putExtra("operandoDos", op2);
		startActivityForResult(i, DO_SUMA);
	}

	public void realizarResta(View v) {
		op1 = operandoUno.getText().toString();
		op2 = operandoDos.getText().toString();
		
		Intent i = new Intent(this, RestaActivity.class);
		i.putExtra("operandoUno", op1);
		i.putExtra("operandoDos", op2);
		startActivityForResult(i, DO_RESTA);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		Bundle extras = data.getExtras();
		int resultadoOperacion = extras.getInt("resultado");
		
		if(resultCode==Activity.RESULT_OK) {
			if(requestCode==DO_SUMA) {
				labelResultado.setText("Resultado: "+op1+"+"+op2+"="+resultadoOperacion);
			} else if(requestCode==DO_RESTA) {
				labelResultado.setText("Resultado: "+op1+"-"+op2+"="+resultadoOperacion);
			}
			
		} else { // cuando el resultCode===Activity.RESULT_CANCELED
			Toast.makeText(this, "Error al realizar la operación", Toast.LENGTH_LONG).show();
		}
	}
	
	
}
