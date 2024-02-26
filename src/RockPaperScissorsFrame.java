import javax.swing.*;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

//
public class RockPaperScissorsFrame extends JFrame
{
    // instance variables
    JPanel mainPnl;

    JPanel decidePnl;
    JPanel statsPnl;
    JPanel winnerPnl;


    // buttons
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;
    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorsImg;

    // labels
    JLabel playerWinsL;
    JLabel computerWinsL;
    JLabel tiesLabel;
    JTextField statsTF;
    // counters
    int playerWins;
    int computerWins;
    int ties;

    // text area
    JTextArea displayTA;
    JScrollPane scroller;

    Random rnd = new Random();

    public RockPaperScissorsFrame() {
        // set the layout
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4, 1));


        // create the title panel
        createDecidePnl();
        mainPnl.add(decidePnl);

        // create the stats panel
        StatsPnl();
        mainPnl.add(statsPnl);

        WinnerPnl();
        mainPnl.add(winnerPnl);

        // add the main panel to the frame
        add(mainPnl);
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    private void createDecidePnl() {
        // create to decide panel
        decidePnl = new JPanel();
        decidePnl.setLayout(new GridLayout(1, 4));
        decidePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pick"));

        rockImg = new ImageIcon("src/rock.jpg");
        paperImg = new ImageIcon("src/paper.jpg");
        scissorsImg = new ImageIcon("src/scissors.jpg");

        rockBtn = new JButton(rockImg);
        paperBtn = new JButton(paperImg);
        scissorsBtn = new JButton(scissorsImg);
        quitBtn = new JButton("Quit");

        decidePnl.add(rockBtn);
        decidePnl.add(paperBtn);
        decidePnl.add(scissorsBtn);
        decidePnl.add(quitBtn);

        rockBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Rock\n");
            play(0);
        });

        paperBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Paper\n");
            play(1);
        });

        scissorsBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Scissors\n");
            play(2);
        });

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }


    private void StatsPnl() {
        // create the stats panel
        statsPnl = new JPanel();

        playerWinsL = new JLabel("Players Wins: 0");
        computerWinsL = new JLabel("Computers Wins: 0");
        tiesLabel = new JLabel("Ties: 0");

        statsPnl.add(playerWinsL);
        statsPnl.add(computerWinsL);
        statsPnl.add(tiesLabel);

        statsTF = new JTextField(15);
    }




    private void WinnerPnl() {
        // create the winner panel
        winnerPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        winnerPnl.add(scroller);
    }


    private void play(int playerMove) {
        // computer move
        int computerMove = rnd.nextInt(3);

        // 0 = rock, 1 = paper, 2 = scissors
        if (playerMove == computerMove) {
            if (playerMove == 0) {
                displayTA.append("Computer plays: Rock\n It's a tie!\n");
            }
            else if (playerMove ==1) {
                displayTA.append("Computer plays: Paper\n It's a tie!\n");
            }
            else {
                displayTA.append("Computer plays: Scissors\n It's a tie!\n");
            }
            ties++;
            tiesLabel.setText("Ties: " + ties);
        }
        else if (playerMove == 1 && computerMove == 0) {
            displayTA.append("Computer plays: Rock\n Paper covers Rock (Player Wins)\n");
            playerWins++;
        }
        else if (playerMove == 0 && computerMove == 1) {
            displayTA.append("Computer plays: Paper\n Paper covers Rocker (Computer Wins)\n");
            computerWins++;
        }
        else if (playerMove == 2 && computerMove == 0) {
            displayTA.append("Computer plays: Rock\n Rock breaks Scissors (Computer Wins)\n");
            computerWins++;
        }
        else if (playerMove == 0 && computerMove == 2) {
            displayTA.append("Computer plays: Scissors\n Rock breaks Scissors (Player Wins)\n");
            playerWins++;
        }
        else if (playerMove == 2 & computerMove == 1) {
            displayTA.append("Computer plays: Paper\n Scissors cuts Paper (Player Wins)\n");
            playerWins++;
        }
        else if (playerMove == 1 && computerMove == 2) {
            displayTA.append("Computer plays: Scissors\n Scissors cuts Paper (Computer Wins)\n");
            computerWins++;
        }
        // update the stats
        playerWinsL.setText("Player Wins: " + playerWins);
        computerWinsL.setText("Computer Wins: " + computerWins);
    }
}




