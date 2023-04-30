package NewKursovaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjectGame extends JComponent implements ActionListener {
    public int i = 0;
    ImageIcon[] sprite;
    Image grass_sp;
    public int x;
    public int y;
    public int h;
    public int w;
    int delay;
    Rectangle rectangle;
    public Timer t;
    Thread thread;

    public ObjectGame(ImageIcon[] sprite, int delay, int x, int y, int w, int h) {
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        rectangle = new Rectangle(x, y, w, h);
        t = new Timer(delay, this);
        this.sprite = sprite;
        grass_sp = sprite[0].getImage();
    }

    public void paint(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        g1.drawImage(grass_sp, x, y, w, h, null);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (i > sprite.length - 1) {
                    i = 0;
                }
                grass_sp = sprite[i].getImage();
                i++;
                t.start();
            }
        });
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}
