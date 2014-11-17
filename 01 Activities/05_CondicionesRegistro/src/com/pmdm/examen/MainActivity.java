package com.pmdm.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	// 1. Declaraci—n de variables
	// y definici—n de las constantes que definir‡ cada
	// acci—n que el usuario puede realizar
	
	private Button btnConsultaCondiciones;
	private EditText nombreRegistro;
	private TextView textoResultado;
	
	public static int TESTIGO_CONSULTA_CONDICIONES = 2345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnConsultaCondiciones = (Button) findViewById(R.id.buttonConsultarNombre);
        nombreRegistro = (EditText) findViewById(R.id.numeroMatricula);
        
        btnConsultaCondiciones.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String nombre = nombreRegistro.getText().toString();
				
				if(nombre.equals("")) {
					Toast t = Toast.makeText(MainActivity.this, "No indic— nombre en el registro", Toast.LENGTH_LONG);
					t.show();
				} else {
					// Intent expl’cito, esto es, quiero lanzar un Activity en concreto,
					// que en este caso es ConsultaCondiciones.class
					Intent i = new Intent(MainActivity.this,ConsultaCondiciones.class);
					i.putExtra("nombreRegistro", nombre);
					startActivityForResult(i, TESTIGO_CONSULTA_CONDICIONES);
				}
			}
		});
       
    }
    
    
    

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	String mensaje = "";
    	if(requestCode==TESTIGO_CONSULTA_CONDICIONES) {
    		if(resultCode==RESULT_CANCELED) {
				mensaje = "Rechaz— las condiciones del registro";
    		} else {
    			mensaje = "Acept— las condiciones del registro";
			}
		}
		
		Toast t = Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG);
		t.show();
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
