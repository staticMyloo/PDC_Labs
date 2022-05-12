package Task06_1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleGUI extends JPanel
{
    
    private JButton button;
    private JTextField jfield;
    private BGPanel bgpanel;
    private JComboBox fontSizeBox;
    private JComboBox fontTextBox;
    
    public SimpleGUI()
    {
        super(new BorderLayout());
        button = new JButton("Update");
        jfield = new JTextField("Type here...");
        jfield.setSize(200, 70);
        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        bottomPanel.setSize(WIDTH, 600);
        bottomPanel.add(button);
        bottomPanel.add(jfield);
        bgpanel = new BGPanel();
        super.add(bottomPanel, BorderLayout.SOUTH);
        super.add(bgpanel, BorderLayout.CENTER);
        
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        fontSizeBox = new JComboBox();
        for(int i = 10; i <= 30; i++)
        {
            fontSizeBox.addItem(i);
        }
        
        JLabel fontPanel = new JLabel();
        fontPanel.setText("Font Size: ");
        topPanel.add(fontPanel);
        topPanel.add(fontSizeBox);
        
        JLabel fontStylePanel = new JLabel();
        fontStylePanel.setText("Font :");
        topPanel.add(fontStylePanel);
        String fonts[] = {"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"};
        fontTextBox = new JComboBox(fonts);
        topPanel.add(fontTextBox);
        
        super.add(topPanel, BorderLayout.NORTH);
        
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String input = jfield.getText();
                bgpanel.setString(input);
                repaint();
            }
        });
        
        jfield.addMouseListener(new MouseAdapter()
        {
           @Override
           public void mouseClicked(MouseEvent e)
           {
               jfield.setText("");
               repaint();
           }
            
        });
        
        fontTextBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String s = (String) fontTextBox.getSelectedItem();
                int i = (int) fontSizeBox.getSelectedItem();
                Font newFont = new Font(s, Font.PLAIN, i);
                bgpanel.setFont(newFont);
                repaint();
            }
        });
       
        fontSizeBox.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String s = (String) fontTextBox.getSelectedItem();
                int i = (int) fontSizeBox.getSelectedItem();
                Font newFont = new Font(s, Font.PLAIN, i);
                bgpanel.setFont(newFont);
                repaint();
            }
        });
        
    }

   
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleGUI());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
        
    }

   

    
}
