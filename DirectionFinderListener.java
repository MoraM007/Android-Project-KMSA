package com.example.sayed.car_seervice;

import java.util.List;

/**
 * Created by Sayed on 14-Jun-17.
 */

interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
