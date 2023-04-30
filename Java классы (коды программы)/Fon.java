package NewKursovaya;

import javax.swing.*;
import java.awt.*;

public class Fon {
    Image grass;
    ImageIcon fon;

    public int x = 0;
    public int y = 0;
    public int hf;
    public int wf;

    Fon(ImageIcon fon, int w, int h) {
        this.fon = fon;
        wf = w;
        hf = h;
        grass = fon.getImage();
    }

    Fon(ImageIcon fon, int w, int h, int x, int y) {
        this.fon = fon;
        this.x = x;
        this.y = y;
        wf = w;
        hf = h;
        grass = fon.getImage();
    }

    public void paint(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        g1.drawImage(grass, x, y, wf, hf, null);
    }

    public void setFon(ImageIcon fon) {
        this.fon = fon;
    }

    public ImageIcon getFon() {
        return fon;
    }

    public void setHf(int hf) {
        this.hf = hf;
    }

    public void setWf(int wf) {
        this.wf = wf;
    }
    public int setHf() {
       return hf;
    }

    public int setWf() {
        return wf;
    }

    public void getX(int x) {
        this.x = x;
    }

    public void getY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
