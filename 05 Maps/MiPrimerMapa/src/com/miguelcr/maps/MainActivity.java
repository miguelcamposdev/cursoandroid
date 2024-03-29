package com.miguelcr.maps;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends Activity implements OnMarkerClickListener,
		OnMarkerDragListener, LocationListener {

	private GoogleMap mMap;
	private int numClicks = 0;
	private int zoom = 5;
	private Marker marcador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.miPrimerMapa)).getMap();
		marcador = mMap.addMarker(new MarkerOptions()
				.position(new LatLng(10, 10))
				.draggable(true)
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker))
				.title("Hola Mundo!"));

		mMap.setOnMarkerClickListener(this);
		mMap.setOnMarkerDragListener(this);

		Polyline line = mMap.addPolyline(new PolylineOptions()
				.add(new LatLng(-37.81319, 144.96298),
						new LatLng(-31.95285, 115.85734)).width(25)
				.color(Color.BLUE).geodesic(true));

		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-31.95285,
				115.85734), 5));
		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.zoom_menu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.itemZoom:
			CameraPosition cameraPosition = new CameraPosition.Builder()
					.target(new LatLng(-31.95285, 115.85734)) // Sets the center
																// of the map to
																// Mountain View
					.zoom(17) // Sets the zoom
					.bearing(90) // Sets the orientation of the camera to east
					.tilt(30) // Sets the tilt of the camera to 30 degrees
					.build(); // Creates a CameraPosition from the builder
			mMap.animateCamera(CameraUpdateFactory
					.newCameraPosition(cameraPosition));

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		Toast.makeText(this, "Marker seleccionado " + numClicks + " veces",
				Toast.LENGTH_SHORT).show();
		numClicks++;
		return false;
	}

	@Override
	public void onMarkerDrag(Marker marker) {
		LatLng posicionActual = marker.getPosition();
		Log.i("SEGUIMIENTO", "Posicion: " + posicionActual.latitude + ","
				+ posicionActual.longitude);

	}

	@Override
	public void onMarkerDragEnd(Marker marker) {
		LatLng posicionActual = marker.getPosition();
		marker.setTitle("Has llegado!");
		marker.setSnippet("Posicion: " + posicionActual.latitude + ","
				+ posicionActual.longitude);
		marker.showInfoWindow();

	}

	@Override
	public void onMarkerDragStart(Marker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(Location location) {
		LatLng posicionMapa = new LatLng(location.getLatitude(), location.getLongitude());
		marcador.setPosition(posicionMapa);
		marcador.setSnippet(getCity(posicionMapa));
		marcador.showInfoWindow();
		mMap.animateCamera(CameraUpdateFactory.newLatLng(posicionMapa));
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public String getCity(LatLng posicion) {
		Geocoder geocoder;
		List<Address> addresses;
		String city = "";
		geocoder = new Geocoder(this, Locale.getDefault());
		try {
			addresses = geocoder.getFromLocation(posicion.latitude,
					posicion.longitude, 1);

			city = addresses.get(0).getAddressLine(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return city;
	}
}
