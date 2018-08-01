package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class SpeichernLaden extends JPanel implements ActionListener {
	
	static final long serialVersionUID = 1;
	
    private JButton speichern;
    private JButton laden;
    private JTextField eingabe;
    private JLabel eingegebenes;
    private String gespeicherterText;
    private String spielstand;

    public SpeichernLaden() {
        //construct components
        speichern = new JButton ("Speichern");
        laden = new JButton ("Laden");
        eingabe = new JTextField (5);
        eingegebenes = new JLabel (".");

        //adjust size and set layout
        setPreferredSize (new Dimension (300, 200));
        setLayout (null);

        //add components
        add (speichern);
        add (laden);
        add (eingabe);
        add (eingegebenes);
        
        speichern.addActionListener(this);
        laden.addActionListener(this);

        //set component bounds (only needed by Absolute Positioning)
        speichern.setBounds (25, 150, 100, 25);
        laden.setBounds (175, 150, 100, 25);
        eingabe.setBounds (25, 25, 250, 25);
        eingegebenes.setBounds (25, 100, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Speichern/Laden");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new SpeichernLaden());
        frame.pack();
        frame.setVisible (true);
    }
    
    public void actionPerformed (ActionEvent e){
    	if(e.getSource() == speichern) {
    		OutputStream out = null;
    		try {
    		gespeicherterText = eingabe.getText();
    		System.out.println(gespeicherterText);
    		eingegebenes.setText(gespeicherterText);
    		out = new FileOutputStream("C:\\Users\\User\\Desktop\\test123");
    		ObjectOutputStream o = new ObjectOutputStream(out);
    		o.writeObject(spielstand);
    		o.close();
    		}
    		catch (IOException a) {
    			  a.printStackTrace();
    			}
    	}
    	if(e.getSource() == laden) {
    		System.out.print("2");
    		InputStream in = null; 
    		try {
    		in = new FileInputStream("C:\\Users\\User\\Desktop\\test123");
    		ObjectInputStream o = new ObjectInputStream(in);
    		spielstand = (String)o.readObject();
    		System.out.print(spielstand);
    		eingegebenes.setText(spielstand);
    		in.close();
    		}
    		catch (IOException a) {
    			  a.printStackTrace();
    			}
    		catch (ClassNotFoundException a) {
    			  a.printStackTrace();
    			}
    	}
    }
}
