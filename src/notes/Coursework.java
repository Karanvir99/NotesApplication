/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Coursework extends JFrame implements ActionListener, KeyListener {   
   
    JPanel pnl = new JPanel(new BorderLayout());
    
    JTextArea txtNewNote = new JTextArea();
    JTextArea txtDisplayNotes = new JTextArea();
    JTextField search = new JTextField();
    ArrayList<String> course = new ArrayList<>();
    ArrayList<String> note = new ArrayList<>();
    JComboBox courseList = new JComboBox();
   
    String crse = "";
    AllNotes allNotes = new AllNotes();
    
    JTextField txt = new JTextField();
    JButton btnNew = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete"); 
    
    public static void main(String[] args) {
        
    // Required for Coursework  
    JOptionPane.showMessageDialog(null, "Karanvir Choda - 000981054");
    Coursework prg = new Coursework();     
    }
    
    public String DropDown(String s) 
    {
    s=courseList.getSelectedItem().toString();
    return DropDown(s);
    }
    
    // using MVC
    public Coursework() {
        model();
        view();
        controller();      
    }
    
    private void model() {
     course.add("Object Oriented Programming");
     course.add("Computer Systems Architectures");
     course.add("System Development");
     course.add("Analytical Methods for Computing");
  
    /*
        // Take these out AFTER you have created the file.        
        Note nt = new Note();        
        nt.setNoteID(1);         
        nt.setDayte(getDateAndTime());         
        nt.setCourse( course.get(0));         
        nt.setNote("The course code for this module is COMP1752");         
        allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote()); 
 
        // Take these out AFTER you have created the file.        
        nt = new Note();        
        nt.setNoteID(2);         
        nt.setDayte(getDateAndTime());         
        nt.setCourse( course.get(1));         
        nt.setNote("The course code for this module is COMP1588");         
        allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote());
        
        nt = new Note();        
        nt.setNoteID(3);         
        nt.setDayte(getDateAndTime());         
        nt.setCourse( course.get(2));         
        nt.setNote("The course code for this module is COMP1713");         
        allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote());
        
        nt = new Note();        
        nt.setNoteID(4);         
        nt.setDayte(getDateAndTime());         
        nt.setCourse( course.get(3));         
        nt.setNote("The course code for this module is MATH1111");         
        allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote());
    */   
    }
    
    private void view() {
        Font fnt = new Font("Georgia", Font.PLAIN, 24) ;
        
        //JPanel pnlTop = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        JMenu note = new JMenu();  
        
        note = new JMenu("Note");  
        note.setToolTipText("Note tasks");
        note.setFont(fnt);
       
        note.add(makeMenuItem("New", "NewNote", "Create a new note.", fnt));
        note.addSeparator();         
        note.add(makeMenuItem("Close", "close", "Clear the current note.", fnt));
       
        menuBar.add(note);         
        menuBar.add(makeMenuItem("Exit", "Exit", "Close this program", fnt));

        courseList.setFont(fnt);
        courseList.setMaximumSize(courseList.getPreferredSize());
        courseList.addActionListener(this);
        courseList.setActionCommand("Course");
        menuBar.add(courseList);
        
        menuBar.add(txt);
        
        btnNew.addActionListener(this);
        btnNew.setActionCommand("Add");
        menuBar.add(btnNew);
         
        btnUpdate.addActionListener(this);
        btnUpdate.setActionCommand("Update");
        menuBar.add(btnUpdate);
             
        btnDelete.addActionListener(this);
        btnDelete.setActionCommand("Delete");
        menuBar.add(btnDelete);
         
        this.setJMenuBar(menuBar);
        
        JToolBar toolBar = new JToolBar();
        // Setting up the ButtonBar
        JButton button = null;
        button = makeButton("Document", "Coursework",
                "Open the requirements window.",
                "Coursework");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("create", "NewNote",
                "Open note area.",
                "New");
        toolBar.add(button);
        button = makeButton("closed door", "close",
                "Close note area.",
                "Close");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("exit", "Exit",
                "Exit from this program.",
                "Exit");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("List",
                "CourseList",
                "CourseList",
                "CourseList");
        toolBar.add(button);
        
        toolBar.addSeparator();
        //This forces anything after it to the right.
        toolBar.add(Box.createHorizontalGlue());
        
        search.setMaximumSize(new Dimension(6900, 30));
        search.setFont(fnt);
        toolBar.add(search);
        toolBar.addSeparator();
        button = makeButton("search", "SearchKeyword",
                "Search for this text.",
                "Search");
        toolBar.add(button);
        
        add(toolBar, BorderLayout.NORTH);
        
        JPanel pnlWest = new JPanel();
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        pnlWest.setBorder(BorderFactory.createLineBorder(Color.black));
        
        txtNewNote.setFont(fnt);
        pnlWest.add(txtNewNote);
        JPanel lft  = new JPanel();
        
        txtNewNote.setPreferredSize(new Dimension(300, 60));

        JButton btnAddNote = new JButton("Add note");
        btnAddNote.setActionCommand("CopyNote");
        btnAddNote.addActionListener(this);
        pnlWest.add(btnAddNote);
        
        add(pnlWest, BorderLayout.WEST);

        JPanel cen = new JPanel();
        cen.setLayout(new BoxLayout(cen, BoxLayout.Y_AXIS));
        cen.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDisplayNotes.setFont(fnt);
        cen.add(txtDisplayNotes);
        
        add(cen, BorderLayout.CENTER);
          
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Notes Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);  // Needed to ensure that the items can be seen.
    }
    
    private void controller() {
        addAllNotes();
    }
    
    protected JMenuItem makeMenuItem(
            String txt,
            String actionCommand,
            String toolTipText,
            Font fnt) {

        JMenuItem mnuItem = new JMenuItem();
        mnuItem.setText(txt);
        mnuItem.setActionCommand(actionCommand);
        mnuItem.setToolTipText(toolTipText);
        mnuItem.setFont(fnt);
        mnuItem.addActionListener(this);

        return mnuItem;
    }
    
    protected JButton makeButton(
            String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {
        
        //Create and initalise the button.
        JButton button = new JButton();
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        
        //Look for the image.
        String imgLocation = System.getProperty("user.dir")
                + "\\icons\\"
                + imageName
                + ".png";

        File fyle = new File(imgLocation);
        if (fyle.exists() && !fyle.isDirectory()) {
            // image found
            Icon img;
            img = new ImageIcon(imgLocation);
            button.setIcon(img);
        } else {
            // image NOT found
            button.setText(altText);
            System.err.println("Resource not found: " + imgLocation);
        }

        return button;
    }
    
    private void addNote(String text) {
        //allNotes.addNote(allNotes.getMaxID(), crse, text);
        addAllNotes();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if ("Course".equals(e.getActionCommand())) {
            crse = courseList.getSelectedItem().toString();
            txt.setText(crse);
            
            String lyst = allNotes.searchDropDownNotes("", 0, courseList.getSelectedItem().toString());
            txtDisplayNotes.setText(lyst);
         }
            
           if ("Coursework".equals(e.getActionCommand())) {
            CWDetails cw = new CWDetails();
           }
           
           if ("Add".equals(e.getActionCommand())) {
            courseList.addItem(txt.getText());
         
                              
            Note nt = new Note();
            nt.setCourse(txt.getText());
            nt.setNote("Course ");
            allNotes.addNote(allNotes.getMaxID(), nt.getCourse(), nt.getNote());      
        }
 
        if ("Delete".equals(e.getActionCommand())) {
            courseList.removeItemAt(courseList.getSelectedIndex());
            txt.setText("");
        }

        if ("Update".equals(e.getActionCommand())) {
            courseList.addItem(txt.getText());
            courseList.removeItemAt(courseList.getSelectedIndex());
            txt.setText("");
        }
        
        if ("CopyNote".equals(e.getActionCommand())) { 
            txtDisplayNotes.setText(txtNewNote.getText());
            
            int IID = allNotes.searchDropDownID(0, 0, courseList.getSelectedItem().toString());   
            allNotes.EditNote(IID,courseList.getSelectedItem().toString(), txtNewNote.getText()); 
        }
        
        if ("NewNote".equals(e.getActionCommand())) {
            txtNewNote.setVisible(true);
            txtNewNote.setText("");
        }
        
        if ("close".equals(e.getActionCommand())) {
            txtNewNote.setVisible(false);
            txtNewNote.setText("");
        }
  
        if ("CourseList".equals(e.getActionCommand())) {
            note.clear();
            note.add("Object Oriented Programming");
            note.add("Computer Systems Architectures");
            note.add("System Development");
            note.add("Analytical Methods for Computing");
            addAllNotes1();
        }
         
        if ("SearchKeyword".equals(e.getActionCommand())) {
            String lyst = allNotes.searchAllNotesByKeyword("", 0, search.getText());
            txtDisplayNotes.setText(lyst);
        }

        if ("Exit".equals(e.getActionCommand())) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   private void addAllNotes1() {
        String allNotes = "";

        for (String n : note) {
            allNotes += n + "\n";
        }   
        txtDisplayNotes.setText(allNotes);
    }

    private void addAllNotes() {
        String txtNotes = "";

        for (Note n : allNotes.getAllNotes()) {
            txtNotes += n.getNote() + "\n";
            courseList.addItem(n.getCourse());
        } 
        txtDisplayNotes.setText(txtNotes);
    }
    
    private String getDateAndTime() {
        String UK_DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
        String ukDateAndTime;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat uksdf = new SimpleDateFormat(UK_DATE_FORMAT_NOW);
        ukDateAndTime = uksdf.format(cal.getTime());

        return ukDateAndTime;
    }    
}
