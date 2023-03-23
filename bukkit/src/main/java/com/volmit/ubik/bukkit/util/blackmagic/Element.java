 

package com.volmit.ubik.bukkit.util.blackmagic;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Element {
    MaterialBlock getMaterial();

    Element setMaterial(MaterialBlock b);

    boolean isEnchanted();

    Element setEnchanted(boolean enchanted);

    String getId();

    String getName();

    Element setName(String name);

    double getProgress();

    Element setProgress(double progress);

    short getEffectiveDurability();

    int getCount();

    Element setCount(int c);

    ItemStack computeItemStack();

    Element setBackground(boolean bg);

    boolean isBackgrond();

    Element addLore(String loreLine);

    List<String> getLore();

    Element call(ElementEvent event, Element context);

    Element onLeftClick(Callback<Element> clicked);

    Element onRightClick(Callback<Element> clicked);

    Element onShiftLeftClick(Callback<Element> clicked);

    Element onShiftRightClick(Callback<Element> clicked);

    Element onDraggedInto(Callback<Element> into);

    Element onOtherDraggedInto(Callback<Element> other);
}
