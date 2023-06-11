

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import javax.swing.JPanel;


public class TrojanPlace {

    public static JFrame jframe = new JFrame();
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenuBar menubar2 = new JMenuBar();
    public static JLabel newGame = new JLabel();
    public static JLabel remain = new JLabel();
    public static JLabel totalTime = new JLabel();
    private final GameBoard gameBoard = new GameBoard();





    public TrojanPlace() {

        designScreen();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);

        jframe.setLocationRelativeTo(null);
        jframe.revalidate();
        jframe.repaint();
    }

    public void designScreen() {


        jframe.add(menuBar, BorderLayout.NORTH);
        jframe.add(menubar2, BorderLayout.CENTER);
        menubar2.add(remain);
        menubar2.add(new JPanel());

        menubar2.add(new JPanel());
        menubar2.add(totalTime);
        totalTime.setText("Time:000");

        gameBoard.check();
        jframe.pack();

    }
    public static void editscreenSize() {
        jframe.setLocationRelativeTo(null);
    }

}
