package com.neoclar.mewnforge.java.source.com.cairn4.moonbase;

import com.badlogic.gdx.ai.msg.MessageManager;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.cairn4.moonbase.PlayerStatus;
import com.cairn4.moonbase.World;
import com.neoclar.jbi.java.Marker;

public class Player implements Telegraph{
    
    public Player(World world, int x, int y) {
        Marker.lineOneMarker(88);
        MessageManager.getInstance().addListener(this, 51);
    }
    public void inventoryUpdate() {
        Marker.lineOneMarker(2);
        MessageManager.getInstance().dispatchMessage(49);
    }
    
    public PlayerStatus playerStatus;
    private void updateCurrentBase() {}
    public boolean handleMessage(Telegram msg) {
        Marker.beforeMarker();
        if (msg.message == 51) {
            this.playerStatus.updateCurrentHabitatModule();
            updateCurrentBase();
            return true;
        }
        Marker.plug();
        Marker.stopMarker();
        Marker.afterOneMarker();
        return false;
    }
}