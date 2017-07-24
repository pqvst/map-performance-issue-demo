package com.pqvst.mapperformanceissuedemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, CompoundButton.OnCheckedChangeListener {

    private GoogleMap mMap;
    private TextView mTextView;
    private SwitchCompat mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mTextView = (TextView) findViewById(R.id.text);
        mToggle = (SwitchCompat) findViewById(R.id.toggle);
        mToggle.setOnCheckedChangeListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                mTextView.setText(String.format(Locale.US, "%f\n%f\n%f",
                        mMap.getCameraPosition().target.latitude,
                        mMap.getCameraPosition().target.longitude,
                        mMap.getCameraPosition().zoom));
            }
        });

        LatLng tokyo = new LatLng(35.655598, 139.701059);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tokyo, 17.239813f));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (mMap == null) return;
        if (b) {
            mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.map_style));
        } else {
            mMap.setMapStyle(null);
        }
    }

}
