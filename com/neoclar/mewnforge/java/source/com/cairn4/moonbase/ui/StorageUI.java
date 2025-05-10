package com.neoclar.mewnforge.java.source.com.cairn4.moonbase.ui;

import com.cairn4.moonbase.PlayerInventory;
import com.neoclar.jbi.java.Marker;

public class StorageUI {
   private PlayerInventory playerInventory;
    @SuppressWarnings("unused")
    private void moveToStorage(int inventoryIndex, boolean moveStack){
        Marker.lineOneMarker(11);
        playerInventory.getPlayer().inventoryUpdate();
    }
}