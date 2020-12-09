package org.olianda.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.RadioGroup.OnCheckedChangeListener;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, OnMarkerClickListener, OnCheckedChangeListener {
    private MapView mapView;
    private GoogleMap gmap;
    private String MAP_VIEW_BUNDLE_KEY = "AIzaSyBrsznW-SA2gC3k7WYYKKCtIq2KPJzDY90";
    private String HOST;
    private TextView selectParkMessageArea;
    private TextView freeParksArea;
    private TextView parkIdLb;
    private TextView parkIdArea;
    private TextView parkTypeLb;
    private TextView parkTypeArea;
    private TextView parkAddressLb;
    private TextView parkAddressArea;
    private TextView parkLatLb;
    private TextView parkLatArea;
    private TextView parkLonLb;
    private TextView parkLonArea;
    private List<Marker> markers;
    private RadioGroup vehicleTypeRadio;
    private Button refreshBtn;
    private Marker selectedMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        markers = new LinkedList<>();
        HOST = getString(R.string.host);
        ((RadioButton) findViewById(R.id.carRadioButton)).performClick();
        vehicleTypeRadio = (RadioGroup) findViewById(R.id.vehicleType);
        vehicleTypeRadio.setOnCheckedChangeListener(this);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }
        selectParkMessageArea = (TextView) findViewById(R.id.selectParkMessageArea);
        freeParksArea = (TextView) findViewById(R.id.freeParksArea);
        parkIdLb = (TextView) findViewById(R.id.parkIdLb);
        parkIdArea = (TextView) findViewById(R.id.parkIdArea);
        parkTypeLb = (TextView) findViewById(R.id.parkTypeLb);
        parkTypeArea = (TextView) findViewById(R.id.parkTypeArea);
        parkAddressLb = (TextView) findViewById(R.id.parkAddressLb);
        parkAddressArea = (TextView) findViewById(R.id.parkAddressArea);
        parkLatLb = (TextView) findViewById(R.id.parkLatLb);
        parkLatArea = (TextView) findViewById(R.id.parkLatArea);
        parkLonLb = (TextView) findViewById(R.id.parkLonLb);
        parkLonArea = (TextView) findViewById(R.id.parkLonArea);
        parkIdLb.setVisibility(View.INVISIBLE);
        parkIdArea.setVisibility(View.INVISIBLE);
        parkTypeLb.setVisibility(View.INVISIBLE);
        parkIdArea.setVisibility(View.INVISIBLE);
        parkAddressLb.setVisibility(View.INVISIBLE);
        parkAddressArea.setVisibility(View.INVISIBLE);
        refreshBtn = (Button) findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckedChanged(vehicleTypeRadio, vehicleTypeRadio.getCheckedRadioButtonId());
            }
        });
        MapsInitializer.initialize(this);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        gmap.setMinZoomPreference(12);
        LatLng myPosition = new LatLng(44.4085142,8.9139984);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
        gmap.setOnMarkerClickListener(this);
        new RetrieveParkTask(this).execute(HOST, "{\"type\": \"car\", \"pos\": {\"lat\": 44.4574293, \"lon\": 8.8914264}}");
        new GetFreeParksCountTask(this).execute(HOST, "{\"type\": \"car\"}");
    }

    public void retrieveParkCallback(JSONArray res) {
        selectedMarker = null;
        for(Marker m : markers) {
            m.remove();
        }

        markers = new LinkedList<>();
        for(int i=0; i<res.length(); i++) {
            LatLng currPos = new LatLng(res.optJSONObject(i).optDouble("lat"), res.optJSONObject(i).optDouble("lon"));
            Marker currMarker = gmap.addMarker(new MarkerOptions().position(currPos));
            currMarker.setTag(res.optJSONObject(i));
            markers.add(currMarker);
        }
        if(!markers.isEmpty()) {
            onMarkerClick(markers.get(0));
        }
    }

    public void getFreeParkCountCallback(Integer count) {
        freeParksArea.setText(count.toString());
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d("MainActivity", "onMarkerClick");
        JSONObject currInfo = (JSONObject) marker.getTag();
        if(currInfo != null) {
            Log.d("MainActivity", "onMarkerClick: marker found");
            parkIdArea.setText(String.valueOf(currInfo.optInt("parkid")));
            parkTypeArea.setText(currInfo.optString("type"));
            parkAddressArea.setText(currInfo.optString("address"));
            parkLatArea.setText(String.valueOf(currInfo.optDouble("lat")));
            parkLonArea.setText(String.valueOf(currInfo.optDouble("lon")));
            parkIdLb.setVisibility(View.VISIBLE);
            parkIdArea.setVisibility(View.VISIBLE);
            parkTypeLb.setVisibility(View.VISIBLE);
            parkIdArea.setVisibility(View.VISIBLE);
            parkAddressLb.setVisibility(View.VISIBLE);
            parkAddressArea.setVisibility(View.VISIBLE);
            parkLatLb.setVisibility(View.VISIBLE);
            parkLatArea.setVisibility(View.VISIBLE);
            parkLonLb.setVisibility(View.VISIBLE);
            parkLonArea.setVisibility(View.VISIBLE);
            selectParkMessageArea.setVisibility(View.INVISIBLE);
            if(selectedMarker != null) {
                selectedMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            }
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            selectedMarker = marker;
            return true;
        } else{
            Log.d("MainActivity", "onMarkerClick: marker not found");
            return false;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Log.d("MainActivity", "onCheckedChanged: i="+i);
        switch(i) {
            case R.id.carRadioButton:
                Log.d("MainActivity", "onCheckedChanged: car");
                new RetrieveParkTask(this).execute(HOST, "{\"type\": \"car\", \"pos\": {\"lat\": 44.4574293, \"lon\": 8.8914264}}");
                new GetFreeParksCountTask(this).execute(HOST, "{\"type\": \"car\"}");
                break;
            case R.id.motoRadioButton:
                Log.d("MainActivity", "onCheckedChanged: moto");
                new RetrieveParkTask(this).execute(HOST, "{\"type\": \"moto\", \"pos\": {\"lat\": 44.4574293, \"lon\": 8.8914264}}");
                new GetFreeParksCountTask(this).execute(HOST, "{\"type\": \"moto\"}");
                break;
            case R.id.handicapRadioButton:
                Log.d("MainActivity", "onCheckedChanged: hadicap");
                new RetrieveParkTask(this).execute(HOST, "{\"type\": \"handicap\", \"pos\": {\"lat\": 44.4574293, \"lon\": 8.8914264}}");
                new GetFreeParksCountTask(this).execute(HOST, "{\"type\": \"handicap\"}");
                break;
            default:
                Log.d("MainActivity", "onCheckedChanged: default");
                return;
        }
    }
}