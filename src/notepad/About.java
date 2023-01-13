
package notepad;
import java.awt.Font;
import javax.swing.*;
public class About extends JFrame {
    About(){
        setBounds(100,100,500,400);
        setTitle("About Notepad application ");
        setDefaultCloseOperation(2);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("spiral-notepad-emoji.png"));
        setIconImage(icon.getImage());
        
        setLayout(null);
        
        JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("spiral-notepad-emoji.png")));
        iconLabel.setBounds(100,50,80,80);
        add(iconLabel);
        
        JLabel textLabel = new JLabel("<html>this is about Notepad.<p>This notepad is designed by Aayaan Gautam.</p></p>This application is made under Java JDK19 version</p></html>");
        textLabel.setBounds(100,50,350,300);
        textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        add(textLabel);
    }   
    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
