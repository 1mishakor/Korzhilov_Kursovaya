package NewKursovaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static java.awt.event.KeyEvent.*;

public class Game extends JComponent implements KeyListener, ActionListener {
    static JFrame f = new JFrame();
    static Fon fon0, fon1, fon2, fon3;
    static ObjectGame tree, fier;
    static ObjectGame oblako1;
    static ObjectGame oblako2;
    static ObjectGame oblako3;
    static ObjectGame oblako4;
    static ObjectGame oblako5;
    static ObjectGame oblako6;
    static ObjectGame oblako7;
    static Person person;
    public Timer t = new Timer(60, this);

    static int px;
    static int speed;

    public static void main(String[] PascalABC) {
        Game game = new Game();

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

        ImageIcon ZF0 = new ImageIcon("res\\Zad_Fon_0.png");
        ImageIcon ZF = new ImageIcon("res\\Zad_Fon.png");
        ImageIcon PF = new ImageIcon("res\\Per_Fon.png");
        ImageIcon[] oblako = new ImageIcon[]{new ImageIcon("res\\Oblako.png")};
        ImageIcon[] TreeSP = new ImageIcon[]{
                new ImageIcon("res\\Sprite\\Tree1.png"),
                new ImageIcon("res\\Sprite\\Tree1.png"),
                new ImageIcon("res\\Sprite\\Tree2.png"),
                new ImageIcon("res\\Sprite\\Tree2.png")
        };
        ImageIcon[] FierSP = new ImageIcon[]{new ImageIcon("res\\Sprite\\Fier\\Fier1.png"),
                new ImageIcon("res\\Sprite\\Fier\\Fier1.png"),
                new ImageIcon("res\\Sprite\\Fier\\Fier1.png"),
                new ImageIcon("res\\Sprite\\Fier\\Fier2.png"),
                new ImageIcon("res\\Sprite\\Fier\\Fier2.png"),
                new ImageIcon("res\\Sprite\\Fier\\Fier2.png")};
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        px = (int) (screenSize.getWidth() / 2 - 170 + 100);
        speed = (int) (20 / (1920 / screenSize.getWidth()));

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

        person = new Person(sprite, speed, 60, (int) (570 / (1920 / screenSize.getWidth())), (int) (750 / (1080 / screenSize.getHeight())), (int) (170 / (1920 / screenSize.getWidth())), (int) (220 / (1080 / screenSize.getHeight())));
        tree = new ObjectGame(TreeSP, 0, (int) (120 / (1920 / screenSize.getWidth())), (int) (36 / (1080 / screenSize.getHeight())), (int) ((200 * 3 + 270) / (1920 / screenSize.getWidth())), (int) ((200 * 3 + 300) / (1080 / screenSize.getHeight())));
        fier = new ObjectGame(FierSP, 1, (int) (700 / (1920 / screenSize.getWidth())), (int) (851 / (1080 / screenSize.getHeight())), (int) (85 / (1920 / screenSize.getWidth())), (int) (85 / (1080 / screenSize.getHeight())));

        oblako1 = new ObjectGame(oblako, 0, (int) (250 / (1920 / screenSize.getWidth())), (int) (555 / (1080 / screenSize.getHeight())), (int) (270 / (1920 / screenSize.getWidth())), (int) (175 / (1080 / screenSize.getHeight())));
        oblako2 = new ObjectGame(oblako, 0, (int) (15 / (1920 / screenSize.getWidth())), (int) (470 / (1080 / screenSize.getHeight())), (int) (255 / (1920 / screenSize.getWidth())), (int) (122 / (1080 / screenSize.getHeight())));
        oblako3 = new ObjectGame(oblako, 0, (int) (0 / (1920 / screenSize.getWidth())), (int) (400 / (1080 / screenSize.getHeight())), (int) (421 / (1920 / screenSize.getWidth())), (int) (234 / (1080 / screenSize.getHeight())));
        oblako4 = new ObjectGame(oblako, 0, (int) (1000 / (1920 / screenSize.getWidth())), (int) (307 / (1080 / screenSize.getHeight())), (int) (231 / (1920 / screenSize.getWidth())), (int) (123 / (1080 / screenSize.getHeight())));
        oblako5 = new ObjectGame(oblako, 0, (int) (314 / (1920 / screenSize.getWidth())), (int) (430 / (1080 / screenSize.getHeight())), (int) (564 / (1920 / screenSize.getWidth())), (int) (237 / (1080 / screenSize.getHeight())));
        oblako6 = new ObjectGame(oblako, 0, (int) (1213 / (1920 / screenSize.getWidth())), (int) (195 / (1080 / screenSize.getHeight())), (int) (634 / (1920 / screenSize.getWidth())), (int) (423 / (1080 / screenSize.getHeight())));
        oblako7 = new ObjectGame(oblako, 0, (int) (0 / (1920 / screenSize.getWidth())), (int) (55 / (1080 / screenSize.getHeight())), (int) (564 / (1920 / screenSize.getWidth())), (int) (237 / (1080 / screenSize.getHeight())));
        fon0 = new Fon(ZF0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        fon1 = new Fon(ZF, (int) screenSize.getWidth() + 420, (int) screenSize.getHeight());
        fon1.x = -50;
        fon2 = new Fon(PF, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        fon3 = new Fon(PF, (int) screenSize.getWidth(), (int) screenSize.getHeight(), fon2.wf, 0);

        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        f.getContentPane().setCursor(blankCursor);

        f.getContentPane().add(game);
        f.addKeyListener(game);
        f.setVisible(true);
    }

    public void paint(Graphics g) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                t.start();
            }
        });

        Graphics2D g1 = (Graphics2D) g;
        fon0.paint(g1);
        oblako1.paint(g1);
        if (oblako1.x >= 1920) {
            oblako1.setX(-oblako1.w);
        } else {
            oblako1.setX(oblako1.x + 2);
        }
        oblako2.paint(g1);
        if (oblako2.x >= 1920) {
            oblako2.setX(-oblako2.w);
        } else {
            oblako2.setX(oblako2.x + 3);
        }
        oblako3.paint(g1);
        if (oblako3.x >= 1920) {
            oblako3.setX(-oblako3.w);
        } else {
            oblako3.setX(oblako3.x + 2);
        }

        fon1.paint(g1);
        fon2.paint(g1);
        fon3.paint(g1);

        oblako4.paint(g1);
        if (oblako4.x >= 1920) {
            oblako4.setX(-oblako4.w);
        } else {
            oblako4.setX(oblako4.x + 2);
        }
        oblako5.paint(g1);
        if (oblako5.x >= 1920) {
            oblako5.setX(-oblako5.w);
        } else {
            oblako5.setX(oblako5.x + 3);
        }
        oblako6.paint(g1);
        if (oblako6.x >= 1920) {
            oblako6.setX(-oblako6.w);
        } else {
            oblako6.setX(oblako6.x + 4);
        }
        oblako7.paint(g1);
        if (oblako7.x >= 1920) {
            oblako7.setX(-oblako7.w);
        } else {
            oblako7.setX(oblako7.x + 2);
        }

        thread.start();

        tree.paint(g1);
        fier.paint(g1);
        person.paint(g1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fier.actionPerformed(e);
        person.actionPerformed(e);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        person.keyPressed(e);

        if (person.x <= 0) {
            person.speedL = 0;
        } else if (person.x + person.w >= fon2.wf - 50) {
            person.speedR = 0;
        } else if (person.x >= px + 100 && fon3.x + fon3.wf != fon2.wf && fon3.x + fon3.wf >= fon2.wf) {
            fon2.x -= speed;
            fon3.x -= speed;
            if ((fon2.x % 200) == 0) {
                fon1.x -= speed;
            }
            fier.x -= speed;
            tree.x -= speed;
            person.speedR = 0;
        } else if (person.x <= px - 100 && fon2.x != 0 && fon2.x <= 0) {
            fon2.x += speed;
            fon3.x += speed;
            if ((fon2.x % 200) == 0) {
                fon1.x += speed;
            }
            fier.x += speed;
            tree.x += speed;
            person.speedL = 0;
        } else {
            person.speedL = speed;
            person.speedR = speed;
        }
        if (e.getKeyCode() == VK_ESCAPE) {
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        person.keyReleased(e);
    }
}
