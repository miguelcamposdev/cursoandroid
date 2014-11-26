package com.cursoandroid.resttemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends ListActivity {

	User[] usuarios = null;
	UserAdapter adaptadorFruta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new Thread(new Runnable() {
			public void run() {
				// Create a new RestTemplate instance
				RestTemplate restTemplate = new RestTemplate(true);

				// The URL for making the GET request
				final String url = "http://rest.miguelcr.com/index.php/api/example/users";

//				List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//				messageConverters.add(new FormHttpMessageConverter());
//				messageConverters.add(new StringHttpMessageConverter());
//				messageConverters.add(new MappingJackson2HttpMessageConverter());
//				restTemplate.setMessageConverters(messageConverters);
				//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());				// Instantiate the HTTP GET request, expecting an array of
				// Product objects in response
			      List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			     List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
			     MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
			     supportedMediaTypes.add(mediaType);
			     MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
			     jacksonConverter.setSupportedMediaTypes(supportedMediaTypes);
			     messageConverters.add(jacksonConverter);
			     restTemplate.setMessageConverters(messageConverters);
				
				usuarios = restTemplate.getForObject(url, User[].class);
				
				// adaptadorFruta = new
				// UserAdapter(MainActivity.this,R.layout.list_item_user,
				// Arrays.asList(usuarios));

				// setListAdapter(adaptadorFruta);
			}
		}).start();

	}
}
