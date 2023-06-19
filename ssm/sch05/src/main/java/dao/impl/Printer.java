package dao.impl;

import dao.Ink;
import dao.Paper;

public class Printer {
    private Ink ink = null;
    private Paper paper = null;

    public void print(String message) {
        System.out.println("使用" + ink.getColor(255, 200, 0));
        for (int i = 0; i < message.length(); i++) {
            paper.putInChar(message.charAt(i));
        }
        System.out.println(paper.getContent());
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
