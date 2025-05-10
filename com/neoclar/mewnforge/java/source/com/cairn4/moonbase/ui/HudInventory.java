package com.neoclar.mewnforge.java.source.com.cairn4.moonbase.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cairn4.moonbase.ItemActions;
import com.cairn4.moonbase.ItemStack;
import com.cairn4.moonbase.Player;
import com.cairn4.moonbase.PlayerInventory;
import com.cairn4.moonbase.ui.ItemButton;
import com.cairn4.moonbase.ui.Localization;
import com.neoclar.jbi.java.Marker;
import com.cairn4.moonbase.ui.Hud;

public class HudInventory {
  private Hud hud;
  @SuppressWarnings({ "null", "unused" })
  public void update(final PlayerInventory playerInventory) {
    Marker.variableMarker(0);
    com.cairn4.moonbase.ui.HudInventory origThis = null;
    Marker.variableMarker(2);
    final PlayerInventory inventory = playerInventory;
    Marker.variableMarker(4);
    final ItemButton ib = null;
    Marker.variableMarker(8);
    String tooltipTextTemp="";
    Marker.variableMarker(9);
    String secondaryTextTemp="";
    Marker.variableMarker(12);
    boolean consumeHint = false;
    Marker.variableMarker(14);
    ItemActions action = null;
    Marker.lineMarker(29);
    if (action.type.equals("suitCharge")) {
      secondaryTextTemp = secondaryTextTemp + "\n";
      secondaryTextTemp = secondaryTextTemp + "[#56a3ea]" + Localization.format("inventory_hint_plusSuitPower", new Object[] { action.value });
      consumeHint = true;
    }
    Marker.plug();
    Marker.stopMarker();


    Marker.variableMarker(13);
    final String tooltipText = tooltipTextTemp;
    Marker.variableMarker(14);
    final String secondaryText = secondaryTextTemp;
    Marker.anonymusClassMarker(2, new ClickListener(0) {
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        HudInventory.this.hud.removeTooltip();
        Marker.deleteMarker(1);
        Marker.lineOneMarker(1);
        HudInventory.this.hud.resetBoosts();
        Marker.afterOneMarker();
        return;
      }
    });
  }
  @SuppressWarnings("unused")
  private void addStatBarBoost(ItemStack itemStack, Player player) {
    for (ItemActions ia : itemStack.item.actions) {
      Marker.variableMarker(4);
      ia = (ItemActions)ia;
      Marker.lineMarker(1);
      if (ia.type.equals("suitCharge")) {
        float boost = Float.valueOf(ia.value).floatValue();
        System.out.println("new level of suit power boost: " + boost);
        this.hud.updateSuitPowerBoost(boost);
        Marker.GoToMarker(22);
      }
      Marker.plug();
      Marker.stopMarker();
      if (ia.type.equals("eat")) {
        Marker.variableMarker(5);
        float boost = Float.valueOf(ia.value).floatValue();
        Marker.deleteMarker(4, 7);
        Marker.lineMarker(7);
        System.out.println("new level of hunger boost: " + boost);
        this.hud.updateHungerBoost(boost);
        Marker.stopMarker();
        continue;
      }
      if (ia.type.equals("gainOxygen")) {
        Marker.variableMarker(5);
        float boost = Float.valueOf(ia.value).floatValue();
        Marker.deleteMarker(11, 14);
        Marker.lineMarker(14);
        System.out.println("new level of oxygen boost: " + boost);
        this.hud.updateAirBoost(boost);
        Marker.stopMarker();
        continue;
      } 
      if (ia.type.equals("heal")) {
        Marker.variableMarker(5);
        float boost = Float.valueOf(ia.value).floatValue();
        Marker.deleteMarker(18, 21);
        Marker.lineMarker(21);
        System.out.println("new level of health boost: " + boost);
        this.hud.updateHealthBoost(boost);
        Marker.stopMarker();
        continue;
      } 
    } 
  }
}