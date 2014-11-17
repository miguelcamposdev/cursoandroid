package com.miguelcr.miguelbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText editTextUrl;
	Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editTextUrl = (EditText) findViewById(R.id.editTextUrl);
        btnEnviar = (Button) findViewById(R.id.button1);
        
        editTextUrl.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(editTextUrl.getText().toString().length()==0) {
					btnEnviar.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_error, 0, 0, 0);
				} else {
					btnEnviar.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_ok, 0, 0, 0);
				}
				
				return false;
			}
		});
    }
    
    public void abrirUrl(View v) {
    	
    	String url = editTextUrl.getText().toString();
    	
    	Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
    	startActivity(i);
    }
}
