package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int LOCATION_REQUEST = 500;
    ArrayList<LatLng> listPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        listPoints = new ArrayList<>();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                if (listPoints.size() == 2) {
                    listPoints.clear();
                    mMap.clear();
                }
                // first point saved
                listPoints.add(latLng);
                // create a marker
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);

                if (listPoints.size() == 1) {
                    // add the fist marker in map
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
                } else {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                }
                mMap.addMarker(markerOptions);
                if (listPoints.size() == 2) {
                    // create url to get request fmor first to second marker
//                String url = getRequestUrl(listPoints.get(0),listPoints.get(1));
//                TaskRequestDirections taskRequestDirections = new TaskRequestDirections();
//                taskRequestDirections.execute(url);
                    MapsActivity.this.getRequestUrl(listPoints.get(0), listPoints.get(1));
                }

            }
        });
    }

    private String getRequestUrl(LatLng origin, LatLng destination) {
        //Value of origin
        String str_org = "origin=" + origin.latitude + "," + origin.longitude;
        //Value of destination
        String str_dest = "destination=" + destination.latitude + "," + destination.longitude;
        //Set value enable the sensor
        String sensor = "sensor=false";
        //Mode for find direction
        String mode = "mode=walking";
        // add api key in url
        String api_key = "key=" + getString(R.string.google_maps_key);
        //Build the full param
        String param = str_org + "&" + str_dest + "&" + sensor + "&" + mode + "&" + api_key;
        //Output format
        String output = "json";
        //Create url to request
        String url = "https://m...content-available-to-author-only...s.com/maps/api/directions/" + output + "?" + param;

        String uri = "http://maps.google.com/maps?saddr=" + origin.latitude + "," + origin.longitude + "&daddr=" + destination.latitude + "," + destination.longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
        return url;
    }
}
