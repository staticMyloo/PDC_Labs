package Task09_2;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class SaveLog extends JFrame {

    public TextField text;
    public File file;
    public JButton button = new JButton("Save");

    public SaveLog() {
        text = new TextField();

        file = new File("log.txt");
    }

    public void writeToFile() throws IOException {
        String str = text.getText();
        Log log = Log.getSingletonInstance(str);

    }

    public static void main(String[] args) {
        final SaveLog savlog = new SaveLog();

        savlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        savlog.setSize(400, 150);
        savlog.setLocationRelativeTo(null);
        Panel p = new Panel();

        p.add(savlog.text);
        p.add(savlog.button);
        savlog.add(p);
        savlog.setVisible(true);
        savlog.text.setText("Write your log here...");

        savlog.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the button");

                try {
                    savlog.writeToFile();
                } catch (IOException ex) {
                    Logger.getLogger(SaveLog.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(Log.instanceNumber);
            }
        });

    }
}
