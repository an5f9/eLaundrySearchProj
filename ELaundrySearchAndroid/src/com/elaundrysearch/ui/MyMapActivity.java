/*package com.elaundrysearch.ui;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapController;
import com.google.android.maps.GeoPoint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.location.Geocoder;
import android.location.Address;

import com.google.android.maps.Overlay;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.List;
import java.util.Locale;
import java.io.IOException;

import android.os.Bundle;
import android.widget.Toast;

public class MyMapActivity extends MapActivity {
    *//** Called when the activity is first created. *//*
	private MapView mapView;
	private MapController mapController;
	private LocationManager locationManager;
    private LocationListener locationListener;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);    
        
        locationListener = new GPSLocationListener();
        
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 
            0, 
            0, 
            locationListener);
        
        mapView = (MapView) findViewById(R.id.accountButton);
        
        // enable Street view by default
        mapView.setStreetView(true);
        
        // enable to show Satellite view
        // mapView.setSatellite(true);
        
        // enable to show Traffic on map
        // mapView.setTraffic(true);
        mapView.setBuiltInZoomControls(true);
        
        mapController = mapView.getController();
        mapController.setZoom(16); 
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    private class GPSLocationListener implements LocationListener 
    {
       // @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                GeoPoint point = new GeoPoint(
                        (int) (location.getLatitude() * 1E6), 
                        (int) (location.getLongitude() * 1E6));
                
                 Toast.makeText(getBaseContext(), 
                        "Latitude: " + location.getLatitude() + 
                        " Longitude: " + location.getLongitude(), 
                        Toast.LENGTH_SHORT).show();
                                
                mapController.animateTo(point);
                mapController.setZoom(16);
                
                // add marker
                MapOverlay mapOverlay = new MapOverlay();
    			mapOverlay.setPointToDraw(point);
    			List<Overlay> listOfOverlays = mapView.getOverlays();
    			listOfOverlays.clear();
    			listOfOverlays.add(mapOverlay);
    			
                String address = ConvertPointToLocation(point);
                Toast.makeText(getBaseContext(), address, Toast.LENGTH_SHORT).show();

                mapView.invalidate();
            }
        }
        
        public String ConvertPointToLocation(GeoPoint point) {   
        	String address = "";
            Geocoder geoCoder = new Geocoder(
                    getBaseContext(), Locale.getDefault());
            try {
                List<Address> addresses = geoCoder.getFromLocation(
                	point.getLatitudeE6()  / 1E6, 
                    point.getLongitudeE6() / 1E6, 1);
	 
		        if (addresses.size() > 0) {
		            for (int index = 0; index < addresses.get(0).getMaxAddressLineIndex(); index++)
		            	address += addresses.get(0).getAddressLine(index) + " ";
		        }
            }
            catch (IOException e) {                
                e.printStackTrace();
            }   
            
            return address;
        }

		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		} 

        
    }
    
    class MapOverlay extends Overlay
    {
    	private GeoPoint pointToDraw;

    	public void setPointToDraw(GeoPoint point) {
    		pointToDraw = point;
    	}

    	public GeoPoint getPointToDraw() {
    		return pointToDraw;
    	}
    	
        @Override
        public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
            super.draw(canvas, mapView, shadow);                   
 
            // convert point to pixels
            Point screenPts = new Point();
            mapView.getProjection().toPixels(pointToDraw, screenPts);
 
            // add marker
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_search);
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y - 10, null); // 24 is the height of image        
            return true;
        }
    } 
}*/