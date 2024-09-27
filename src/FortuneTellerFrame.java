import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl, titlePnl, displayPnl, controlPnl;
    JButton getFortuneBtn, quitBtn;
    JLabel titleLbl;
    ImageIcon icon;
    JTextArea fortuneTA;
    JScrollPane scroller;
    Random gen = new Random();
    int lastFortune = -1;

    ArrayList<String> fortunes = new ArrayList<>();

    public FortuneTellerFrame(){
        setTitle("Fortune Teller");
        setSize(600,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fortunes.add("Get Bent");
        fortunes.add("Good things are to follow");
        fortunes.add("Check under your bed tonight");
        fortunes.add("\\Ü/");
        fortunes.add("Follow your dreams");
        fortunes.add("They don't like it when you take up their space");
        fortunes.add("dir src/sarcasm");
        fortunes.add("Goblins don't always hide under bridges");
        fortunes.add("Invest in magic 8 balls");
        fortunes.add("Good food awaits you");
        fortunes.add("Bad rolls beseech you");
        fortunes.add("You will bump into someone around a corner today");
        fortunes.add("Don't drop the soap");
        fortunes.add("Your spouse is going to leave you");
        fortunes.add("Where there's a will...");
        fortunes.add("You should trust the wierd gay vampire man. He is very charismatic");
        fortunes.add("\"Doing drugs is bad\" -Rocky");
        fortunes.add("You will search for your wife's killer for a year");

        //Assemble the GUI here
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();

        setVisible(true);
    }

    private void createTitlePanel(){
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 36));
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

    private void createDisplayPanel(){
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(10,45);
        fortuneTA.setEditable(false);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    private void createControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));

        getFortuneBtn = new JButton("Get me Fortune!");
        getFortuneBtn.setFont(new Font("monospaced", Font.PLAIN, 20));
        getFortuneBtn.addActionListener((ActionEvent ae) ->
        {
            int nextFortune = gen.nextInt(17);
            while(lastFortune == nextFortune){
                nextFortune = gen.nextInt(17);
            }
            lastFortune = nextFortune;
            fortuneTA.append(fortunes.get(nextFortune) + "\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("monospaced", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(getFortuneBtn);
        controlPnl.add(quitBtn);

        mainPnl.add(controlPnl, BorderLayout.SOUTH);
    }
}
