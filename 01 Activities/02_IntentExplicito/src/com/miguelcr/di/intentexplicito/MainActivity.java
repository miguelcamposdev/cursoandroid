package com.miguelcr.di.intentexplicito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // Muy importante: cuando se define el atributo android:onClick
    // en un componente View, en este caso en un Button, el nombre que
    // indicamos como valor del atributo se debe corresponder con un método
    // declarado en el Activity, que debe cumplir los siguientes requisitos:
    
    // 1. que sea un método public
    // 2. que retorne void
    // 3. debe recibir un parámetro de tipo View
    
    public void lanzarActivitySecundario (View v) {
    	Intent i = new Intent(this, SecondActivity.class);
    	startActivity(i);
    }
}
