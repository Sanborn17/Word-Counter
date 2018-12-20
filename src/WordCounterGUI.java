import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class WordCounterGUI extends JPanel {
    private JTextArea input;
    private JButton count, clear;
    private JPanel buttonPanel;
    private JLabel label;
    private WordCounter wc = new WordCounter();

    private JScrollPane scroll;

    public WordCounterGUI() {
        setLayout(new BorderLayout());

        input = new JTextArea(18,64);
        input.setBorder(new TitledBorder(new EtchedBorder(), "Type here."));
        input.setLineWrap(true);
        input.setWrapStyleWord(true);

        scroll = new JScrollPane(input);

        count = new JButton("Count");
        clear = new JButton("Clear");
        label = new JLabel("");

        ButtonListener Listener = new ButtonListener();
        count.addActionListener(Listener);
        clear.addActionListener(Listener);

        buttonPanel = new JPanel();
        buttonPanel.add(count);
        buttonPanel.add(clear);

        add(scroll,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == count && !input.getText().equals("")) label.setText("This has " + wc.WordCount(input.getText()) + " words");
                else if(event.getSource() == count && input.getText().equals("")) label.setText("Type something in first you idiot.");
                else if(event.getSource() == clear) input.setText("");
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new WordCounterGUI());
        frame.setMinimumSize(new Dimension(480,405));
        frame.pack();
        frame.setVisible(true);
    }

}
