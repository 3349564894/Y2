package dao.impl;

import dao.Ink;

import java.awt.*;

public class ColorInk implements Ink {
    @Override
    public String getColor(int red, int green, int blue) {
        Color color = new Color(red, green, blue);
        return "#" + Integer.toHexString(color.getRGB());
    }
}
