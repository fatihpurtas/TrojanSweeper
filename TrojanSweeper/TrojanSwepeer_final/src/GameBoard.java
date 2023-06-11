

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;

public class GameBoard {
    boolean forOnes = true;
    boolean runCounter = true;
    JPanel jpanel = new JPanel();
    private static int line ;
    private static int row ;
    private final int gapSize = 15;
    private static int trojanNumber ;
    private Random random = new Random();
    int[][] gameNumber;
    JLabel arrayLabel[][];
    boolean openSquare[][];
    boolean[][] isFlag;
    Time time = new Time();

    Image Box = new ImageIcon(GameBoard.class.getResource("/Source/box.png")).getImage();
    Image empty = new ImageIcon(GameBoard.class.getResource("/Source/empty.png")).getImage();
    Image trojan = new ImageIcon(GameBoard.class.getResource("/Source/trojan.png")).getImage();
    Image one = new ImageIcon(GameBoard.class.getResource("/Source/1.png")).getImage();
    Image two = new ImageIcon(GameBoard.class.getResource("/Source/2.png")).getImage();
    Image three = new ImageIcon(GameBoard.class.getResource("/Source/3.png")).getImage();
    Image four = new ImageIcon(GameBoard.class.getResource("/Source/4.png")).getImage();
    Image five = new ImageIcon(GameBoard.class.getResource("/Source/5.png")).getImage();
    Image six = new ImageIcon(GameBoard.class.getResource("/Source/6.png")).getImage();
    Image seven = new ImageIcon(GameBoard.class.getResource("/Source/7.png")).getImage();
    Image eight = new ImageIcon(GameBoard.class.getResource("/Source/8.png")).getImage();
    Image flag = new ImageIcon(GameBoard.class.getResource("/Source/flag.png")).getImage();
    int flagNumber = trojanNumber;
    public static JFrame jframe = new JFrame();



    public void getSize(int line, int row, int trojanNumber) {
        this.trojanNumber = trojanNumber;
        GameBoard.line = line;
        GameBoard.row = row;
        check();
    }
    public void setSize() {

        Dimension dimension = new Dimension(line * gapSize, row * gapSize);
        jpanel.setPreferredSize(dimension);

    }


    public void place() {
        runCounter = true;
        gameNumber = new int[line][row];
        arrayLabel = new JLabel[line][row];
        isFlag = new boolean[line][row];
        openSquare = new boolean[line][row];
        int rndRow;
        int rndLine;
        flagNumber = trojanNumber;
        int[][] sameplaceTrojan = new int[line][row];

        TrojanPlace.remain.setText("Flag:" + flagNumber);
        if (forOnes) {
            time.oneTime();
            forOnes = false;
        }


        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                sameplaceTrojan[i][j] = i * row + j;
            }
        }

        //It prevents trojans from falling in the same place
        for (int i = 0; i < trojanNumber; i++) {
            while (true) {
                rndLine = random.nextInt(line);
                rndRow = random.nextInt(row);
                if (sameplaceTrojan[rndLine][rndRow] != -1) {
                    gameNumber[rndLine][rndRow] = 10;

                    sameplaceTrojan[rndLine][rndRow] = -1;
                    break;
                }

            }
        }

        //It create numbers on the gameboard
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (gameNumber[j][i] == 10) {
                    for (int k = j - 1; k <= j + 1; k++) {
                        for (int l = i - 1; l <= i + 1; l++) {
                            try {
                                if (k >= 0 && k < line && l >= 0 && l < row) {
                                    if (gameNumber[k][l] != 10) {
                                        gameNumber[k][l] += 1;
                                    }
                                }
                            } catch (Exception e) {

                                e.getStackTrace();
                            }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                System.out.print(gameNumber[j][i] + " ");
            }
            System.out.println("");
        }
        System.out.println("*****************************************************");

        for (int i = 0; i < GameBoard.line; i++) {
            for (int j = 0; j < GameBoard.row; j++) {
                arrayLabel[i][j] = new JLabel();
                arrayLabel[i][j].setBounds(15 * i, 15 * j, 15, 15);
                arrayLabel[i][j].setIcon(new ImageIcon(Box));
                jpanel.add(arrayLabel[i][j]);
                arrayLabel[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (e.getButton() == 1) {
                            if (runCounter) {
                                time.timerResume();
                                runCounter = false;
                            }

                            onMouseClicked(e);
                        } else if (e.getButton() == 3) {
                            onMouseClickedflag(e);
                            if (runCounter) {
                                time.timerResume();
                                runCounter = false;
                            }

                        }
                    }

                    private void onMouseClicked(MouseEvent e) {
                        for (int i = 0; i < line; i++) {
                            for (int j = 0; j < row; j++) {
                                if (e.getSource() == arrayLabel[i][j]) {

                                    arrayLabel[i][j].setIcon(null);
                                    openSquare[i][j] = true;
                                    if (gameNumber[i][j] == 0) {
                                        openSpace(i, j);


                                    } else if (gameNumber[i][j] == 10) {
                                        time.stopTimer();
                                        arrayLabel[i][j].setIcon(new ImageIcon(trojan));
                                        TrojanPlace.newGame.setIcon(null);

                                        int result = JOptionPane.showConfirmDialog(jpanel, "Y̸̛̯̩͉͚̗̅͌̈́́o̸̩̿ṵ̷͚͛͊̓ ̵̦͖̺̜̃̉̆̔̀ḩ̷͔̃a̶̢͚͖̲̝̽͂̑͋̂͘͠v̷̨͌̀͗ẹ̴́̿̀̈͠ ̸̧̐̔̇̀b̵̜̬͙̠̖̳̄͒̋̇̄̈͜è̶̻̲͔͎̲̥̿͠ͅḙ̴̥̦͖̳̘̋̑ǹ̸̖̯͉͖̹̝́̃̍̇̉͠ ̸̬͎̾͛͒̉͊ḩ̷̟̼̗̃a̴̬͒̈̀̊̉͂̚c̴̰̪͍̻͇̄́ͅķ̸̛̼̿̉͂̽̚͜è̵͇̬͐̐ḑ̸͈̿̆̒̈́̒͗̈́!̴̪̣̤̫̌̀!̴̗̜̝̝̫̤̝͌̔͐͠ ̵̛̟̗͕̒̓̿̀̅͜͜Ẁ̴̘͍͔͔͇͑̏͘ȏ̵̱́̎u̸͈̙̞̗̲̾̍͐̄͘͝l̶̘̱͙̈́̌͋̒̏̚ͅd̵̳̼̥̥̞̰̍͜ ̵͕͑̂͜y̵̿͐̃̅͒̔͊ͅơ̷̱̙̠̘̈́̊̋̾u̷̱̳͓̝̝̳̽̑ ̴̥̹̙̮͉̣͆͒̄ḻ̴̋̈́̓͌̈i̶̛͈̼̐͌̃̕k̷̛͓̟͙̼̗̦̅͑̾͜ȇ̸͖̝̠̝̬̝̍͛̓̓͝ ̷̨̧̢̨͓̟̱̽̔̃̂t̶͎͔͂̅ó̷̝͓͕̌͗ ̵̡̜̞̑̀̑̐͂̈́̎p̴̯̞̤̙̌̒͋͒́̕l̴̤̯̯̎̒͑̐̕a̷̛͎̒͊̌͛y̵̧̡̤͊̚ ̸̭̫͕̍͊ͅa̴̧̬̥̘͎͑̓̈́̍͝ģ̸̛̀̈̓á̶̧̖̻͓͓͇̉̏i̵̢̟̙̺͌͐̽͌͂͐͝n̷̹̫͓̋̊͌̉͋?̶̧̛̝͍̦̾́̆̐̔", "H̶̻̥̭̭͔̃͊͒̓͆̿̄̀́͒͊͐̽̓̍̃̇̌̈̋̇̓̔͒̉̈́͆̈́̕̚͘͘͠E̸̡̧͔̤͙͉̪̻͙̭̼̭̗̲̯͖̤͚̗͉͕͇͇̗̙͇̓̓͒̌͌̀́͗͑̕͝ͅL̷̻̗͍̱̲͓͚̠͍̠͔̬͎̜͚̫͔̜͚͖̔̉̀͑̃͆͐̉̑̆̎̆͌̑̋̚͜͜͝ͅͅP̸̧̧̨͉̯͔̘͇̟̲̲͎̰̫͔̥̠̟͇̣͉̫̜͎̯͓̳̯̳̯̪͙̽͜M̸̛̹̃̒͑̑͗̾̒̋͂̃̍̃̒͗͑́͒̉̏̒͝", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                                        if (result == JOptionPane.YES_OPTION) {

                                            jpanel.removeAll();
                                            TrojanPlace.jframe.revalidate();
                                            getSize(line, row, trojanNumber);
                                            jpanel.repaint();
                                            TrojanPlace.editscreenSize();

                                            TrojanPlace.totalTime.setText("Time:000");
                                            time.stopTimer();
                                        }
                                        else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
                                            System.exit(0);
                                        }

                                    } else if (gameNumber[i][j] == 1) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(one));
                                    } else if (gameNumber[i][j] == 2) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(two));
                                    } else if (gameNumber[i][j] == 3) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(three));
                                    } else if (gameNumber[i][j] == 4) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(four));
                                    } else if (gameNumber[i][j] == 5) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(five));
                                    } else if (gameNumber[i][j] == 6) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(six));
                                    } else if (gameNumber[i][j] == 7) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(seven));
                                    } else if (gameNumber[i][j] == 8) {
                                        arrayLabel[i][j].setIcon(new ImageIcon(eight));
                                    } else {
                                        arrayLabel[i][j].setIcon(new ImageIcon(empty));

                                    }

                                }
                                jpanel.revalidate();
                                jpanel.repaint();
                            }
                        }
                        isgameOver();
                    }

                    private void onMouseClickedflag(MouseEvent e) {
                        for (int i = 0; i < line; i++) {
                            for (int j = 0; j < row; j++) {
                                if (e.getSource() == arrayLabel[i][j]) {
                                    if (openSquare[i][j] == false) {
                                        if (isFlag[i][j] == true) {
                                            arrayLabel[i][j].setIcon(null);
                                            flagNumber++;
                                            arrayLabel[i][j].setIcon(new ImageIcon(Box));
                                            isFlag[i][j] = false;
                                            TrojanPlace.remain.setText("Flag: " + flagNumber);
                                        } else if (flagNumber != 0) {
                                            arrayLabel[i][j].setIcon(null);
                                            flagNumber--;
                                            arrayLabel[i][j].setIcon(new ImageIcon(flag));
                                            isFlag[i][j] = true;
                                            TrojanPlace.remain.setText("Flag:" + flagNumber);
                                        }
                                        System.out.println(flagNumber);
                                    }
                                }
                            }
                        }
                        isgameOver();
                    }

                });
            }
        }

    }



    public void openSpace(int i, int j) {

        if (i >= 0 && j >= 0 && i < line && j < row && gameNumber[i][j] == 0 && gameNumber[i][j] != 100 && isFlag[i][j] == false) {
            gameNumber[i][j] = 100;
            arrayLabel[i][j].setIcon(null);
            arrayLabel[i][j].setIcon(new ImageIcon(empty));

            openSquare[i][j] = true;

            openSpace(i - 1, j); //left
            openSpace(i + 1, j); //right
            openSpace(i, j + 1); //up
            openSpace(i, j - 1); //down
            openSpace(i - 1, j + 1); //up-left
            openSpace(i + 1, j + 1); //up-right
            openSpace(i - 1, j - 1); //down-left
            openSpace(i + 1, j - 1); //down-right

        } else if (i >= 0 && j >= 0 && i < line && j < row && gameNumber[i][j] < 9 && gameNumber[i][j] > 0 && isFlag[i][j] == false) {

            arrayLabel[i][j].setIcon(null);

            openSquare[i][j] = true;

            if (gameNumber[i][j] == 1) {
                arrayLabel[i][j].setIcon(new ImageIcon(one));
            } else if (gameNumber[i][j] == 2) {
                arrayLabel[i][j].setIcon(new ImageIcon(two));
            } else if (gameNumber[i][j] == 3) {
                arrayLabel[i][j].setIcon(new ImageIcon(three));
            } else if (gameNumber[i][j] == 4) {
                arrayLabel[i][j].setIcon(new ImageIcon(four));
            } else if (gameNumber[i][j] == 5) {
                arrayLabel[i][j].setIcon(new ImageIcon(five));
            } else if (gameNumber[i][j] == 6) {
                arrayLabel[i][j].setIcon(new ImageIcon(six));
            } else if (gameNumber[i][j] == 7) {
                arrayLabel[i][j].setIcon(new ImageIcon(seven));
            } else {
                arrayLabel[i][j].setIcon(new ImageIcon(eight));
            }

        }

    }

    public void isgameOver() {
        int closeSquare = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                if (openSquare[i][j] == false) {
                    closeSquare++;


                }

            }
        }
        if (trojanNumber == closeSquare) {
            int result = JOptionPane.showConfirmDialog(jpanel, "Congratulations, you saved the whole system. Would you like to play again ?", " TEDU FIREWALL ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                jpanel.removeAll();
                TrojanPlace.jframe.revalidate();
                getSize(line, row, trojanNumber);
                jpanel.repaint();
                TrojanPlace.editscreenSize();
                TrojanPlace.totalTime.setText("Time:000");
                time.stopTimer();
            }
            else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        }

    }

    public void check() {
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.revalidate();
        jframe.repaint();
        jpanel.setLayout(null);
        setSize();
        place();
        TrojanPlace.jframe.add(jpanel, BorderLayout.SOUTH);


    }
}

