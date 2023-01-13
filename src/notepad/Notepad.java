
package notepad;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Notepad  extends JFrame implements ActionListener{
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu  view = new JMenu("View");
    JMenu  help = new JMenu("Help");
    
        JMenu SaveAsMenu = new JMenu("Save as");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem newWindowItem = new JMenuItem("New Window");
        JMenuItem pagesetupItem = new JMenuItem("Page Setup");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        
         JMenuItem undoItem = new JMenuItem("Undo");
         JMenuItem cutItem = new JMenuItem("Cut");
         JMenuItem coopyItem = new JMenuItem("Copy");
         JMenuItem pasteItem = new JMenuItem("Paste");
         JMenuItem DeleteItem = new JMenuItem("Delete");
         JMenuItem selectItem = new JMenuItem("Select All");
         JMenuItem timedateItem = new JMenuItem("datetime");
         JMenuItem AboutItem = new JMenuItem("About");
         JTextArea textArea = new JTextArea();
    
    Notepad(){
        setTitle("Notepad Application");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(2);
        ImageIcon icon = new ImageIcon(getClass().getResource("spiral-notepad-emoji.png"));
        setIconImage(icon.getImage());
       setJMenuBar(menubar);
        
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(help);
        
        file.add(newItem);
        file.add(newWindowItem);
        file.add(pagesetupItem);
        file.add(printItem);
        file.add(openItem);
        file.add(saveItem);
        file.add(SaveAsMenu);
        file.add(exitItem);
       edit.add(undoItem);
        edit.add(cutItem);
        edit.add(coopyItem);
       edit.add(pasteItem);
       edit.add(DeleteItem);
        edit.add(selectItem);
        edit.add(timedateItem);
        help.add(AboutItem);
        JScrollPane scrollpane = new JScrollPane(textArea);
        add(scrollpane);
        
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        printItem.addActionListener(this);
        exitItem.addActionListener(this);
        undoItem.addActionListener(this);
        cutItem.addActionListener(this);
        coopyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        selectItem.addActionListener(this);
        DeleteItem.addActionListener(this);
        AboutItem.addActionListener(this);
        
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        printItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        coopyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
        selectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        DeleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equalsIgnoreCase("New")){
           textArea.setText(null);
       }else if(e.getActionCommand().equalsIgnoreCase("Open")){
         
           JFileChooser filechooser = new JFileChooser();
           FileNameExtensionFilter textfilter = new      FileNameExtensionFilter("only text file(.txt)","txt");
           filechooser.setAcceptAllFileFilterUsed(false);
           filechooser.addChoosableFileFilter(textfilter);
           
           int action = filechooser.showOpenDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION){
               return;
           }else{
                 try{
               BufferedReader reader = new BufferedReader(new FileReader(filechooser.getSelectedFile()));
               textArea.read(reader,null);
               }catch(IOException ex){
                   ex.printStackTrace();
               }
            }
       }
       else if(e.getActionCommand().equalsIgnoreCase("Save")){
           
           JFileChooser filechooser = new JFileChooser();
           FileNameExtensionFilter textfilter = new      FileNameExtensionFilter("only text file(.txt)","txt");
           filechooser.setAcceptAllFileFilterUsed(false);
           filechooser.addChoosableFileFilter(textfilter);
           
           int action = filechooser.showSaveDialog(null);
           if(action!=JFileChooser.APPROVE_OPTION){
               return;
           }
           else{
               String fileName = filechooser.getSelectedFile().getAbsolutePath().toString();
               if(!fileName.contains(".txt"))
                   fileName = fileName + ".txt";
               try{
               BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
               textArea.write(writer);
               }catch(IOException ex){
                   ex.printStackTrace();
               }
           }
       }else if(e.getActionCommand().equalsIgnoreCase("Print")){
          
           try {
               textArea.print();
           } catch (PrinterException ex) {
               Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else if(e.getActionCommand().equalsIgnoreCase("Exit")){
           System.exit(0);
           
       }else if(e.getActionCommand().equalsIgnoreCase("Cut")){
           textArea.cut();
           
       }else if(e.getActionCommand().equalsIgnoreCase("Copy")){
           textArea.copy();
       }
       else if(e.getActionCommand().equalsIgnoreCase("Paste")){
           textArea.paste();
       }else if(e.getActionCommand().equalsIgnoreCase("Select All")){
           textArea.selectAll();
       }else if(e.getActionCommand().equalsIgnoreCase("About")){
           new About().setVisible(true);
       }
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       new Notepad().setVisible(true);
    }
}
