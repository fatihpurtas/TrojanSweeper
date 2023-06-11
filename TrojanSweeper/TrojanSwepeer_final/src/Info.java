import javax.swing.*;
import java.awt.*;

public class Info {

    public static JFrame jframeMenu = new JFrame();
    JLabel background = new JLabel();
    JLabel text = new JLabel();
    Image back = new ImageIcon(GameBoard.class.getResource("/Source/background.png")).getImage();
    ImageIcon infotext = new ImageIcon(Info.class.getResource("/Source/infotext.png"));
    private int menuWidth = 900;
    private int menuHeight = 592;

    public Info() {
        jframeMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframeMenu.setVisible(true);
        jframeMenu.setResizable(false);

        jframeMenu.setLayout(null);
        jframeMenu.getContentPane().setBackground(Color.WHITE);
        setDimension();

        background.setIcon(new ImageIcon(back));
        background.setBounds(0, 0, menuWidth, menuHeight);
        jframeMenu.add(background);





        text.setIcon(infotext);
        text.setBounds(300, 0, 300, 592);

        background.add(text);

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

}
