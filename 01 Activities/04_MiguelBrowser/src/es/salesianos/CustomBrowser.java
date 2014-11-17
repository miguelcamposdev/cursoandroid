package es.salesianos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class CustomBrowser extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    String url = "";
	    
	    Uri data = getIntent().getData();
	    // Obtengo la url que el usuario solicit— para visualizar.
	    url = data.toString();
	    
	    WebView webview = new WebView(this);
	    setContentView(webview);
	    webview.loadUrl(url);

	}

}
