package es.salesianos;

import es.salesianos.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AndroidProjActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button boton = (Button) findViewById(R.id.buttonopen);
        
        boton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				final EditText simpleEditText = (EditText) findViewById(R.id.urltext);
				String urlValue = simpleEditText.getText().toString();
				
				// Intent expl’cito para visualizar la URL escrita por el usuario en 
				// el EditText.
				
				// Si el usuario no ha escrito nada en la URL, indico que
				// abra la URL http://www.miguelcr.com
				if (urlValue.equals("")) {
					urlValue = "http://www.miguelcr.com";
				}
				
				Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(urlValue));				
				startActivity(i);
			}
		});
        	        
       
    }
}