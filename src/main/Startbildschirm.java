package main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import speichern_laden.Speichern;


public class Startbildschirm extends JPanel implements ActionListener {	//Standard Panel

	static final long serialVersionUID = 1; //Version Nummer
	
	    public JButton multiplayer;
	    public JButton singleplayer;
	    private static JFrame frame = new JFrame ("Startbildschirm");
	    public JButton start;
	    public static int a =0;
	    public static String txt1;
	    public static String txt2;

	    public Startbildschirm() {
	    	
	        //Buttons erstellen
	        multiplayer = new JButton ("Multiplayer");
	        singleplayer = new JButton ("Singleplayer");
	        start = new JButton ("<html>Spieler<br>erstellen</html>");

	        //adjust size and set layout
	        setPreferredSize (new Dimension (300, 260));
	        setLayout (null);

	        //hinzufuegen der Buttons
	        add (multiplayer);
	        add (singleplayer);
	        add(start);

	        //Groesse und Position der >Buttons
	        multiplayer.setBounds (150, 60, 150, 200);
	        singleplayer.setBounds (0, 60, 150, 200);
	        start.setBounds(100, 10, 100, 40);
	        
	        multiplayer.addActionListener(this);
	    	singleplayer.addActionListener(this);
	    	start.addActionListener(this);
	    }


	    public static void main (String[] args) {
	        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add (new Startbildschirm());
	        frame.pack();
	        frame.setResizable(false);
	        frame.setVisible (true);
	    }
	
	    
	    public void actionPerformed (ActionEvent e){
	    	if(e.getSource()==start) {					//2 Spieler erstellen für den Anfang
	    		if(a<2) {
	    			a++;
						 if(a==1) {
							String eingabe = JOptionPane.showInputDialog("Neuer Spieler", "Spieler1");
						 	txt1=eingabe;
						 	Speichern.saveProfile(new Spielerprofil(eingabe));
						 }
						 else {
							 String eingabe = JOptionPane.showInputDialog("Neuer Spieler", "Spieler2");
							 txt2=eingabe;
							 Speichern.saveProfile(new Spielerprofil(eingabe));
						 }
	    		}
	    		else {}
	    	}
	    	if(e.getSource()==multiplayer) {
	    		if(a==2) {							//erst ausführen, wenn 2 Spieler erstellt
	    		frame.dispose();
	    		Multiplayer.main(null);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Bitte 2 Spieler anlegen", "Achtung", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    	}
	    	if(e.getSource()==singleplayer) {
	    		if(a==2) {
	    		frame.dispose();
	    		Singleplayer.main(null);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Bitte 2 Spieler anlegen", "Achtung", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    	}
	    }
	
}
