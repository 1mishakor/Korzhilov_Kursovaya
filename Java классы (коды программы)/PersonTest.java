package NewKursovaya;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    ImageIcon[][] sprite = new ImageIcon[][]{
            {new ImageIcon("res\\Sprite\\Person\\S_R_2.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_3.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_2.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_3.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_R_4.png")},
            {new ImageIcon("res\\Sprite\\Person\\S_L_2.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_3.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_2.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_4.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_3.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_4.png")},
            {new ImageIcon("res\\Sprite\\Person\\S_R_1.png"),
                    new ImageIcon("res\\Sprite\\Person\\S_L_1.png")}};
    Person person = new Person(sprite, 20,30,50,50,170,220);
    @Test
    void setX() {
        person.setX(100);
        assertEquals(100, person.getX());
    }

    @Test
    void setY() {
        person.setY(120);
        assertEquals(120, person.getY());
    }

    @Test
    void setH() {
        person.setH(200);
        assertEquals(200, person.getH());
    }

    @Test
    void setW() {
        person.setW(185);
        assertEquals(185, person.getW());
    }

    @Test
    void getX() {
        assertEquals(50, person.getX());
    }

    @Test
    void getY() {
        assertEquals(50, person.getY());
    }

    @Test
    void getH() {
        assertEquals(220, person.getH());
    }

    @Test
    void getW() {
        assertEquals(170, person.getW());
    }

    @Test
    void getSpeed() {
        assertEquals(20, person.getSpeed());
    }

    @Test
    void setSpeed() {
        person.setSpeed(50);
        assertEquals(50, person.getSpeed());
    }

    @Test
    void getSprite() {
        assertEquals(sprite, person.getSprite());
    }
}