package com.dam.pmdm.filechooserintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnSelectFile;
	private RadioButton opcionImagen, opcionVideo, opcionFichero;
	private static int PICKFILE_RESULT_CODE = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSelectFile = (Button) findViewById(R.id.buttonSelectFile);
        opcionImagen = (RadioButton) findViewById(R.id.opcionImagen);
        opcionVideo = (RadioButton) findViewById(R.id.opcionVideo);
        opcionFichero = (RadioButton) findViewById(R.id.opcionFichero);
        
        // Gestión del evento click del Botón de selección de fichero
        btnSelectFile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Vamos a lanzar una intención implícita para la selección
				// de un fichero de nuestro dispositivo
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				
				if(opcionFichero.isChecked()) {
					intent.setType("file/*");
				} else if(opcionImagen.isChecked()) {
					intent.setType("image/*");
				} else if(opcionVideo.isChecked()) {
					intent.setType("video/*");
				}
				
				// Con este método, lanzamos la intención y esperamos
				// una respuesta, que en este caso, será el fichero que el 
				// usuario seleccione. La respuesta será tratada en el método
				// de esta actividad: onActivityResult.
				// RECORDAR: además del intent, le pasamos como parámetro
				// el testigo que nos permite reconocer de qué activity
				// nos llega la respuesta.
			    startActivityForResult(intent,PICKFILE_RESULT_CODE);
				
			}
		});
    }
    
    

    // En este método gestionamos la respuesta
    // requestCode: el testigo que yo le pasé al activity al lanzarse
    // resultCode: si la acción del intent se ha realizado correctamente (RESULT_OK)
    // en otro caso, devuelve RESULT_CANCELED
    // data

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==PICKFILE_RESULT_CODE) {
			if(resultCode==RESULT_OK) {
				// con el método getPath() obtengo la ruta del fichero
				// que el usuario ha seleccionado
				String rutaFichero = data.getData().getPath();
				
				// Lanzo un mensaje emergente informando del fichero
				// que ha sido seleccionado.
				Toast toast = Toast.makeText(getApplicationContext(), "Seleccionado el fichero: "+rutaFichero, Toast.LENGTH_SHORT);
				toast.show();
			} else {
				Toast toast = Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
