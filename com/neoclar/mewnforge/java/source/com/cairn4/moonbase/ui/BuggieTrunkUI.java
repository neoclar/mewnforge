package com.neoclar.mewnforge.java.source.com.cairn4.moonbase.ui;

import com.badlogic.gdx.ai.msg.MessageManager;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.cairn4.moonbase.MoonBase;
import com.cairn4.moonbase.PlayerInventory;
import com.cairn4.moonbase.entities.BuggieTrunk;
import com.cairn4.moonbase.ui.GameScreen;
import com.neoclar.jbi.java.Marker;

public class BuggieTrunkUI implements Telegraph {
    public BuggieTrunkUI(GameScreen gameScreen, BuggieTrunk itemStorage, PlayerInventory playerInventory) {
        Marker.lineOneMarker(6);
        MessageManager.getInstance().addListener(this, 49);
    }
    public void hide() {
        Marker.lineOneMarker(1);
        MessageManager.getInstance().removeListener(this, 49);
    }
    private PlayerInventory playerInventory;
    @SuppressWarnings("unused")
    private void moveToStorage(int inventoryIndex, boolean moveStack) {
        Marker.lineOneMarker(11);
        playerInventory.getPlayer().inventoryUpdate();
    }
    
    private void updateGrid() {}
    public boolean handleMessage(Telegram msg) {
        Marker.deleteMarker(0,4);
        Marker.beforeMarker();
        if (msg.message == 31) {
            MoonBase.log("trunk ui handling change message");
            updateGrid();
            return true;
        }
        if ((msg.message == 49)) {
            updateGrid();
            return true;
        }
        Marker.plug();
        Marker.stopMarker();
        Marker.afterOneMarker();
        return false;
    }
}