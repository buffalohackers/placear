package com.snowneedle.placear.location;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.snowneedle.placear.Place;

public class PlacearLocationManager implements Observer{
	
	private LocationManager locationManager;
	private PlacearLocationListener locationListener;
	private Location lastKnownLocation;
	private final int updateMs = 0;
	private final int updateDist = 0;
	
	private SensorManager sensorManager;
	private Sensor sensor;
	private PlacearSensorEventListener sensorListener;
	
	public PlacearLocationManager(LocationManager locationManager, SensorManager sensorManager,
			String googleAccessToken, String facebookAccessToken) {
		Log.v("PLM", "Starting.");
		locationListener = new PlacearLocationListener(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER),
				sensorListener, googleAccessToken, facebookAccessToken);		
		this.locationManager = locationManager;
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
				updateMs, updateDist, locationListener);
		

	}
	
	public Location getLastKnownLocation() {
		return locationListener.getLastKnownLocation();
	}
	
	public double getLastLong() {
		return locationListener.getLastLong();
	}
	
	public double getLastLat() {
		return locationListener.getLastLat();
	}

	@Override
	public void update(Observable observable, Object data) {
		ArrayList<Place> places = (ArrayList<Place>)data;
	}
	
	
	
	
	
	


}
