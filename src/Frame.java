import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame{
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;
    private JPanel calculator;
    private JFrame frame;
    private Linker linker;

    public Frame(Linker linker) {
        this.linker = linker;
        frame = new JFrame();
        frame.setContentPane(calculator);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension location = Toolkit.getDefaultToolkit().getScreenSize();
        int x = location.width/2 - frame.getWidth()/2;
        int y = location.height/2 - frame.getHeight()/2;
        frame.setLocation(x,y);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append(textField1.getText() + ":" + linker.doLink(textField1.getText()) + "\n");
                textField1.setText("");
            }
        });

        frame.setVisible(true);
    }
}
