package com.example.sayed.car_seervice;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import javax.xml.datatype.Duration;

/**
 * Created by Sayed on 14-Jun-17.
 */

class Route {
    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
