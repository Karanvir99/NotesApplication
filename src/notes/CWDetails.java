/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class CWDetails extends JFrame implements ActionListener, KeyListener {
    
    CommonCode cc = new CommonCode();
    JPanel pnl = new JPanel(new BorderLayout());
    JTextArea txtNewNote2 = new JTextArea();
    JTextArea txtDisplayNotes2 = new JTextArea();
    
    JButton btnOOP = new JButton("Object Oriented Programming");
    JButton btnCSA = new JButton("Computer Systems Architectures");
    JButton btnSystemDevelopment = new JButton("System Development");
    JButton btnAnalyticalMethods = new JButton("Analytical Methods for Computing"); 

    // Place the global data structures here, e.g. :-
    //ArrayList<String> tmp = new ArrayList<>();
    //ArrayList<className> cls = new ArrayList<>();

    public CWDetails() {
        model();
        view();
        controller();
    }

    private void model() {
        // This is the logic of the program.     
    }

    private void view() {
        JMenuBar menuBar;
        JMenu fyle;

        JToolBar toolBar = new JToolBar();
        Font fnt = new Font("Georgia", Font.PLAIN, 24);

        // Setting up the MenuBar
        menuBar = new JMenuBar();
        fyle = new JMenu("Note");
        fyle.setToolTipText("Note tasks");
        fyle.setFont(fnt);

        JMenuItem mnuItem = null;
        mnuItem = makeMenuItem("Open", "OpenNote", "Open note area", fnt);
        fyle.add(mnuItem);
        fyle.addSeparator();
        mnuItem = makeMenuItem("Close", "Close", "Close note area", fnt);
        fyle.add(mnuItem);
        menuBar.add(fyle);
        mnuItem = makeMenuItem("Exit", "Exit", "Close this program", fnt);
        menuBar.add(mnuItem);

        setJMenuBar(menuBar);

        setLayout(new BorderLayout());

        JPanel cen = new JPanel();
        cen.setLayout(new BoxLayout(cen, BoxLayout.Y_AXIS));
        cen.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDisplayNotes2.setFont(fnt);
        cen.add(txtDisplayNotes2);  
        add(cen, BorderLayout.CENTER);

        // Use setSize and setLocationRelative for a specific 
        // size of window or setExtendedState to fill the screen.
        //
        //setSize(500, 500);
        //setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Notes Program - Requirements");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnOOP.addActionListener(this);
        menuBar.add(btnOOP);
         
        btnCSA.addActionListener(this);
        menuBar.add(btnCSA);
             
        btnSystemDevelopment.addActionListener(this);
        menuBar.add(btnSystemDevelopment);
        
        btnAnalyticalMethods.addActionListener(this);
        menuBar.add(btnAnalyticalMethods);
         
        this.setJMenuBar(menuBar);

        setVisible(true);

        // Setting up the ButtonBar
        JButton button = null;
        button = makeButton("left", "Return2Notes",
                "Return to the Notes window",
                "Notes");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("create", "OpenNote",
                "Open note area.",
                "New");
        toolBar.add(button);
        button = makeButton("closed door", "Close",
                "Close note area",
                "Close");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("exit", "Exit",
                "Exit from this program",
                "Exit");
        toolBar.add(button);

        add(toolBar, BorderLayout.NORTH);
        
        JPanel pnlWest = new JPanel();
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        pnlWest.setBorder(BorderFactory.createLineBorder(Color.black));
        
        txtNewNote2.setFont(fnt);
        pnlWest.add(txtNewNote2);
        JPanel lft  = new JPanel();
        
        txtNewNote2.setPreferredSize(new Dimension(300, 60));
        
        JButton btnAddNote = new JButton("Add note");
        btnAddNote.setActionCommand("CopyNote");
        btnAddNote.addActionListener(this);
        pnlWest.add(btnAddNote);
        
        add(pnlWest, BorderLayout.WEST);
    }

    private void controller() {       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Return2Notes".equals(ae.getActionCommand())) {
            Coursework cw = new Coursework();
        }
        if ("OpenNote".equals(ae.getActionCommand())) {
            txtNewNote2.setVisible(true);
            txtNewNote2.setText("");
        }
        if ("Close".equals(ae.getActionCommand())) {
            txtNewNote2.setVisible(false);
            txtNewNote2.setText("");
        }
        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);    
        }     
        if ("CopyNote".equals(ae.getActionCommand())) {
            txtDisplayNotes2.append(System.getProperty("line.separator"));
            txtDisplayNotes2.append(txtNewNote2.getText());
        }
        
        txtDisplayNotes2.setFont(new Font("Dialog", Font.PLAIN, 20));
        
        Object source = ae.getSource();
        if (source == btnOOP)
        {
        txtDisplayNotes2.setText("Requirements for COMP1752.\n"
                + "- Add a course to the list of courses and creating a file for it\n" +
                  "- Add a list of requirements for a specific coursework\n" +
                  "- Add notes to each requirement\n" +
                  "- Output those notes as a text file so that it can be imported into a word-processed document");
        }
        
        if (source == btnCSA)
        {
        txtDisplayNotes2.setText("Requirements for COMP1588.\n"
                + "- There are 2 group laboratories, Electrical Principles and Digital logic, both worth 15% each\n" +
                  "- There is a 30% test to prepare for, which will be held on 27/03/2018\n" +
                  "- The individual piece of coursework is worth 40%, this will be demonstrated on 03/03/2018\n" +
                  "- Ensure that the code is correctly done");
        }
        
        if (source == btnSystemDevelopment)
        {
        txtDisplayNotes2.setText("Requirements for COMP1713.\n"
                + "- This year you are required to complete 4 knowledge checks based on the class room activities and lecture materials\n" +
                  "- Each quiz will need to be completed before the published deadlines\n" +
                  "- Each knowledge check must take 50 minutes or less to complete");
        }
        
        if (source == btnAnalyticalMethods)
        {
        txtDisplayNotes2.setText("Requirements for MATH1111.\n"
                + "- Use A4 lined paper\n" +
                  "- There is an assignment and an exam, both worth 50% each\n" +
                  "- Use black or blue pen for writing, not a red pen. Use pencil only for diagrams in the assignment\n" +
                  "- Submit the assignment at the Faculty reception");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("keyTyped has not been coded yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("keyPressed has not been coded yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("keyReleased has not been coded yet.");
    }

    protected JMenuItem makeMenuItem(String txt,
            String actionCommand,
            String toolTipText,
            Font fnt) {

        JMenuItem mnuItem = new JMenuItem();
        mnuItem.setFont(fnt);
        mnuItem.setText(txt);
        mnuItem.setToolTipText(toolTipText);
        mnuItem.setActionCommand(actionCommand);
        mnuItem.addActionListener(this);
        
        return mnuItem;
    }

    protected JButton makeButton(String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {

        //Look for the image.
        String imgLocation = cc.appDir + "\\icons\\"
                + imageName
                + ".png";

        //Create and initialize the button.
        JButton button = new JButton();
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);

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
}