import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{


    JPanel controlPnl;
    JPanel DisplayPnl;
    JPanel main;






    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    JButton spaceBtn;
    JButton spaceBtn2;

    int computerWins;
    int playerWins;
    int ties;


    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorIcon;



    String playerWinsString;
    String computerWinsString;
    String tiesString;

    Random rnd = new Random();

    public RockPaperScissorsFrame()
    {
        setTitle("Rock, Paper, Scissors");
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        setSize(600, 500);

        createDisplayPnl();
        main.add(DisplayPnl, BorderLayout.CENTER);


        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);



    }

    private void createDisplayPnl()
    {
        DisplayPnl = new JPanel();
        DisplayPnl.setLayout(new GridLayout(3, 1));
        Border etched = new TitledBorder(new EtchedBorder(), "Score");
        DisplayPnl.setBorder(etched);
        DisplayPnl.setBackground(Color.LIGHT_GRAY);
        DisplayPnl.setVisible(true);

        playerWinsString = String.valueOf(playerWins);



    }

    private void ControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(2, 3));
        controlPnl.setBackground(Color.LIGHT_GRAY);
        controlPnl.setVisible(true);

        rockIcon = new ImageIcon("src/Rock.jpg");
        paperIcon = new ImageIcon("src/Paper.jpg");
        scissorIcon = new ImageIcon("src/Scissors.jpg");

        Image rockImage = rockIcon.getImage();
        Image rockNewIMG = rockImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon((rockNewIMG));

        Image paperImage = paperIcon.getImage();
        Image paperNewIMG = paperImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon((paperNewIMG));

        Image scissorImage = scissorIcon.getImage();
        Image scissorNewIMG = scissorImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        scissorIcon = new ImageIcon((scissorNewIMG));



        rockBtn = new JButton("Rock", rockIcon);
        rockBtn.addActionListener(e -> rock());
        rockBtn.setFont(new Font("Dialog", Font.BOLD, 14));

        paperBtn = new JButton("Paper", paperIcon);
        paperBtn.addActionListener(e -> paper());
        paperBtn.setFont(new Font("Dialog", Font.BOLD, 14));

        scissorsBtn = new JButton("Scissors", scissorIcon);
        scissorsBtn.addActionListener(e -> scissors());
        scissorsBtn.setFont(new Font("Dialog", Font.BOLD, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> quit());

        spaceBtn = new JButton("");
        spaceBtn.setBackground(Color.LIGHT_GRAY);
        spaceBtn.setEnabled(false);

        spaceBtn2 = new JButton("");
        spaceBtn2.setBackground(Color.LIGHT_GRAY);
        spaceBtn2.setEnabled(false);


        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);

        controlPnl.add(spaceBtn);
        controlPnl.add(quitBtn);
        controlPnl.add(spaceBtn2);



    }

    private void rock()
    {
        int computerChoice = rnd.nextInt(3);
        if(computerChoice == 0)
        {
            ties++;
            tiesString = String.valueOf(ties);
            JOptionPane.showMessageDialog(null, "Computer chose Rock. It's a tie!");

        }
        else if(computerChoice == 1)
        {
            computerWins++;
            computerWinsString = String.valueOf(computerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Paper. You lose!");
        }
        else
        {
            playerWins++;
            playerWinsString = String.valueOf(playerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Scissors. You win!");
        }
        updateDisplay();
    }

    private void paper()
    {
        int computerChoice = rnd.nextInt(3);
        if(computerChoice == 0)
        {
            playerWins++;
            playerWinsString = String.valueOf(playerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Rock. You win!");
        }
        else if(computerChoice == 1)
        {
            ties++;
            tiesString = String.valueOf(ties);
            JOptionPane.showMessageDialog(null, "Computer chose Paper. It's a tie!");

        }
        else
        {
            computerWins++;
            computerWinsString = String.valueOf(computerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Scissors. You lose!");

        }

        updateDisplay();
    }

    private void scissors()
    {
        int computerChoice = rnd.nextInt(3);
        if(computerChoice == 0)
        {
            computerWins++;
            computerWinsString = String.valueOf(computerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Rock. You lose!");
        }
        else if(computerChoice == 1)
        {
            playerWins++;
            playerWinsString = String.valueOf(playerWins);
            JOptionPane.showMessageDialog(null, "Computer chose Paper. You win!");

        }
        else
        {
            ties++;
            tiesString = String.valueOf(ties);
            JOptionPane.showMessageDialog(null, "Computer chose Scissors. It's a tie!");
        }

        updateDisplay();
    }

    private void updateDisplay()
    {
        DisplayPnl.removeAll();
        JLabel playerWinsLbl = new JLabel("Player Wins: " + playerWinsString);
        playerWinsLbl.setFont(new Font("Dialog", Font.BOLD, 14));
        JLabel computerWinsLbl = new JLabel("Computer Wins: " + computerWinsString);
        computerWinsLbl.setFont(new Font("Dialog", Font.BOLD, 14));
        JLabel tiesLbl = new JLabel("Ties: " + tiesString);
        tiesLbl.setFont(new Font("Dialog", Font.BOLD, 14));

        DisplayPnl.add(playerWinsLbl);
        DisplayPnl.add(computerWinsLbl);
        DisplayPnl.add(tiesLbl);
        DisplayPnl.revalidate();
        DisplayPnl.repaint();
    }


    private void quit()
    {
        System.exit(0);
    }
}


