package com.neoclar.mewnforge.java.source.com.cairn4.moonbase.ui;

import java.util.Observable;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.cairn4.moonbase.Player;
import com.neoclar.jbi.java.Marker;

public class Hud {
    private float airBoost;
    private float healthBoost;
    private float hungerBoost;
    private float suitPowerBoost;
    private Group powerGroup;
    private Player player;
    private ProgressBar airProgress;
    private ProgressBar airProgressIncrease;
    private ProgressBar powerProgress;
    private ProgressBar powerProgressIncrease;
    private ProgressBar healthProgress;
    private ProgressBar healthProgressIncrease;
    private ProgressBar hungerProgress;
    private ProgressBar hungerProgressIncrease;
    private ProgressBar.ProgressBarStyle boostLeftBarStyle;
    public void setup() {
        Marker.lineMarker(65);
        this.powerProgressIncrease = new ProgressBar(0.0F, 1.0F, 0.01F, false, this.boostLeftBarStyle);
        this.powerProgressIncrease.setSize(179.0F, 18.0F);
        this.powerProgressIncrease.setPosition(62.0F, 0.0F, 10);
        this.powerGroup.addActor((Actor)this.powerProgressIncrease);
        Marker.stopMarker();
        Marker.deleteMarker(282); // hideProgressBarIncrease();
        Marker.lineOneMarker(282);
        resetBoosts();
    }
    
    public void update(@SuppressWarnings("deprecation") Observable observable, Object o) {
        Marker.lineOneMarker(3);
        this.airProgressIncrease.setValue(this.airProgress.getValue() + this.airBoost/this.player.playerStatus.getMaxAir());
        Marker.deleteMarker(5,7);
        Marker.lineMarker(5);
        this.powerProgress.setValue(this.player.playerStatus.getSuitPowerPercent());
        this.powerProgressIncrease.setValue(this.powerProgress.getValue() + this.suitPowerBoost/this.player.playerStatus.getMaxSuitPower());
        Marker.stopMarker();
        Marker.deleteMarker(22); // hideProgressBarIncrease();
        Marker.lineOneMarker(22);
        resetBoosts();
        Marker.deleteMarker(30,31);
        Marker.lineMarker(31);
        this.healthProgress.setValue(1.0F - this.player.playerStatus.getHealthPercent());
        this.healthProgressIncrease.setValue(this.healthProgress.getValue() - this.healthBoost/this.player.playerStatus.getMaxHealth());
        Marker.stopMarker();
        Marker.lineOneMarker(67);
        this.hungerProgressIncrease.setValue(this.hungerProgress.getValue() - this.hungerBoost/this.player.playerStatus.getMaxHunger());
    }

    public void showLoosingHealthGlow(boolean on) {}
	
    public void updateHungerProgressBarIncrease(float value) {
        Marker.deleteMethodMarker();
    }

    public void updateAirProgressBarIncrease(float value) {
        Marker.deleteMethodMarker();
    }

    public void updateHealthProgressBarIncrease(float value) {
        Marker.deleteMethodMarker();
    }

    public void hideProgressBarIncrease() {
        Marker.deleteMethodMarker();
    }

    public void updateHungerBoost(float boost) {
        Marker.beforeOneMarker();
        this.hungerBoost = boost;
        Marker.plug();
        Marker.afterOneMarker();
        return;
    }

    public void updateAirBoost(float boost) {
        Marker.beforeOneMarker();
        this.airBoost = boost;
        Marker.plug();
        Marker.afterOneMarker();
        return;
    }

    public void updateHealthBoost(float boost) {
        Marker.beforeOneMarker();
        this.healthBoost = boost;
        Marker.plug();
        Marker.afterOneMarker();
        return;
    }

    public void updateSuitPowerBoost(float boost) {
        Marker.beforeOneMarker();
        this.suitPowerBoost = boost;
        Marker.plug();
        Marker.afterOneMarker();
        return;
    }

    public void resetBoosts() {
        Marker.beforeMarker();
        this.hungerBoost = 0F;
        this.airBoost = 0F;
        this.healthBoost = 0F;
        this.suitPowerBoost = 0F;
        Marker.stopMarker();
        Marker.afterOneMarker();
        return;
    }
}