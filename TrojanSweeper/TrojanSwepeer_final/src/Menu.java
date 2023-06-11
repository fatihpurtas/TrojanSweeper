

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

public class Menu {
    private int menuWidth = 900;
    private int menuHeight = 592;
    public JFrame jframeMenu = new JFrame();

    JLabel easy = new JLabel();
    JLabel normal = new JLabel();
    JLabel veteran = new JLabel();

    JLabel exit = new JLabel();
    JLabel info = new JLabel();
    JLabel logo = new JLabel();
    JLabel background = new JLabel();
    TrojanPlace trojanPlace;
    Image back = (new ImageIcon(GameBoard.class.getResource("/Source/background.png"))).getImage();
    ImageIcon easyButton = new ImageIcon(Menu.class.getResource("/Source/easybutton.png"));
    ImageIcon trojanSweeperLogo = new ImageIcon(Menu.class.getResource("/Source/trojansweeperlogo.png"));
    ImageIcon normalButton = new ImageIcon(Menu.class.getResource("/Source/normalbutton.png"));
    ImageIcon veteranButton = new ImageIcon(Menu.class.getResource("/Source/veteranbutton.png"));
    ImageIcon exitButton = new ImageIcon(Menu.class.getResource("/Source/exitbutton.png"));
    ImageIcon infoButton = new ImageIcon(Menu.class.getResource("/Source/infobutton.png"));
    private final GameBoard gameBoard = new GameBoard();
    private int numberOfTrojan = 7;
    private int numberOfRow = 10;
    private int numberOfLine = 10;
    JLabel[][] labelArray;
    int[][] trojanArray;
    JPanel jpanel;
    public Random rdd;
    boolean oneTime;
    boolean counterRunOnce;

    int numberOfFlag;
    public Menu() {

        jframeMenu.setTitle("TrojanSweeper");

        this.labelArray = new JLabel[this.numberOfRow][this.numberOfLine];
        this.trojanArray = new int[this.numberOfRow][this.numberOfLine];
        this.jpanel = new JPanel();
        this.rdd = new Random();
        this.oneTime = true;
        this.counterRunOnce = true;

        this.numberOfFlag = this.numberOfTrojan;
        jframeMenu.setDefaultCloseOperation(2);
        jframeMenu.setVisible(true);
        jframeMenu.setResizable(false);
        jframeMenu.getContentPane().setBackground(Color.WHITE);
        this.setDimension();
        this.background.setIcon(new ImageIcon(this.back));
        this.background.setBounds(0, 0, this.menuWidth, this.menuHeight);


        this.easy.setText("EASY");
        this.easy.setFont(new Font("Monospaced", 1, 20));
        this.easy.setForeground(Color.black);
        this.easy.setHorizontalTextPosition(0);
        this.easy.setVerticalTextPosition(0);
        this.easy.setIcon(this.easyButton);


        this.normal.setText("NORMAL");
        this.normal.setFont(new Font("Monospaced", 1, 20));
        this.normal.setForeground(Color.black);
        this.normal.setHorizontalTextPosition(0);
        this.normal.setVerticalTextPosition(0);
        this.normal.setIcon(this.normalButton);


        this.veteran.setText("VETERAN");
        this.veteran.setFont(new Font("Monospaced", 1, 20));
        this.veteran.setForeground(Color.black);
        this.veteran.setHorizontalTextPosition(0);
        this.veteran.setVerticalTextPosition(0);
        this.veteran.setIcon(this.veteranButton);


        this.exit.setText("EXIT");
        this.exit.setFont(new Font("Monospaced", 1, 20));
        this.exit.setForeground(Color.black);
        this.exit.setHorizontalTextPosition(0);
        this.exit.setVerticalTextPosition(0);
        this.exit.setIcon(this.exitButton);

        this.logo.setIcon(this.trojanSweeperLogo);
        this.info.setIcon(this.infoButton);


        this.easy.setBounds(375, 240, 150, 50);
        this.normal.setBounds(375, 300, 150, 50);
        this.veteran.setBounds(375, 360, 150, 50);
        this.exit.setBounds(375, 420, 150, 50);
        this.info.setBounds(820, 492, 50, 50);
        this.logo.setBounds(100,72,700,104);
        jframeMenu.add(this.background);

        this.background.add(this.easy);
        this.background.add(this.normal);
        this.background.add(this.info);
        this.background.add(this.veteran);
        this.background.add(this.exit);
        this.background.add(this.logo);
        this.click();
    }

    public void setDimension() {
        Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();

        int PosX = 0;
        int PosY = 0;

        if (menuWidth + 100 > Dim.width) {
            menuWidth = Dim.width - 100;
        }
        if (menuHeight + 100 > Dim.height) {
            menuHeight = Dim.height - 100;
        }

        PosX = (Dim.width - menuWidth) / 2;
        PosY = (Dim.height - menuHeight) / 2;

        jframeMenu.setBounds(PosX, PosY, menuWidth, menuHeight);
    }

    private void click() {

        easy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberOfTrojan = 7;
                numberOfLine = 10;
                numberOfRow = 10;
                gameBoard.getSize(numberOfRow, numberOfLine, numberOfTrojan);
                jframeMenu.dispose();
                trojanPlace = new TrojanPlace();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        normal.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberOfTrojan = 40;
                numberOfLine = 16;
                numberOfRow = 16;
                gameBoard.getSize(numberOfRow, numberOfLine, numberOfTrojan);
                jframeMenu.dispose();
                trojanPlace = new TrojanPlace();

            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        veteran.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberOfTrojan = 99;
                numberOfLine = 20;
                numberOfRow = 20;
                gameBoard.getSize(numberOfRow, numberOfLine, numberOfTrojan);
                jframeMenu.dispose();
                trojanPlace = new TrojanPlace();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        info.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                new Info();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
