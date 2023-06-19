package dao.impl;

import dao.Ink;

import java.awt.*;

public class GreyInk implements Ink {
    @Override
    public String getColor(int red, int green, int blue) {
        int c = (red + green + blue) / 3;
        Color color = new Color(c, c, c);
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }
}
