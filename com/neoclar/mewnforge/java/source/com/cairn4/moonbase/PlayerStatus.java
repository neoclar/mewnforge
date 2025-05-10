package com.neoclar.mewnforge.java.source.com.cairn4.moonbase;

import com.neoclar.jbi.java.Marker;

public class PlayerStatus {
    float suitPower;
    float maxSuitPower;
    public float getSuitPowerPercent() {
        Marker.beforeOneMarker();
        return this.suitPower / this.maxSuitPower;
    }
}