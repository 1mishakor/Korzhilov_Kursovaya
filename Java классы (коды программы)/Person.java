package NewKursovaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Person extends JComponent implements KeyListener, ActionListener {
    public boolean bool = true;
    public int i;
    public int j;
    ImageIcon[][] sprite;
    Image grass_sp;
    public int x;
    public int y;
    public int h;
    public int w;
    int delay;
    public int speed;
    public int speedL = speed;
    public int speedR = speed;
    Rectangle rectangle;
    Thread thread;

    public Person(ImageIcon[][] sprite, int speed, int delay, int x, int y, int w, int h) {
        this.sprite = sprite;
        this.speed = speed;
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        grass_sp = sprite[2][0].getImage();
        rectangle = new Rectangle(x, y, w, h);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g1 = (Graphics2D) g;
        g1.drawImage(grass_sp, rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
    }

    class Sides {
        public void Left() {
            bool = false;
            x -= speedL;
            rectangle.setLocation(rectangle.x - speedL, rectangle.y);
            i = 1;
            j = j + 1;
            if (j > sprite[i].length - 1) {
                j = 0;
            }
            for (int del = 0; del <= delay; del++)
                grass_sp = sprite[i][j].getImage();
        }

        public void Right() {
            bool = true;
            x += speedR;
            rectangle.setLocation(rectangle.x + speedR, rectangle.y);
            i = 0;
            j = j + 1;
            if (j > sprite[i].length - 1) {
                j = 0;
            }
            for (int del = 0; del <= delay; del++)
                grass_sp = sprite[i][j].getImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Sides sides = new Sides();
        if ((e.getKeyCode() == VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
            sides.Right();
        } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
            sides.Left();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (bool && (e.getKeyCode() == VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
            j = 0;
            grass_sp = sprite[2][0].getImage();
        } else if (!bool && (e.getKeyCode() == VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
            j = 0;
            grass_sp = sprite[2][1].getImage();

        }

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

    public ImageIcon[][] getSprite() {
        return sprite;
    }

    public void setSprite(ImageIcon[][] sprite) {
        this.sprite = sprite;
    }

    public Image getGrass_sp() {
        return grass_sp;
    }

    public void setGrass_sp(Image grass_sp) {
        this.grass_sp = grass_sp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
