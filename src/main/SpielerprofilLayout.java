package main;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpielerprofilLayout extends JPanel implements ActionListener {
	
	static final long serialVersionUID = 1;

    private JLabel [] spielername = new JLabel [11];
    private JLabel [] spiele = new JLabel [11];
    private JLabel [] gSpiele = new JLabel [11];
    private JLabel [] vSpiele = new JLabel [11];
    private JButton adden = new JButton("Hinzufügen");
    private JButton removen = new JButton("Entfernen");
    public int counter = 1;
    
    // ArrayList anstatt profile
    public static ArrayList<Spielerprofil> Spielerliste = new ArrayList<>();
    
    public static Spielerprofil [] profile = new Spielerprofil[10];
    
    
    public static JFrame hauptframe = new JFrame ("Spielerprofile");

    public SpielerprofilLayout() {
        
    	spielername [0] = new JLabel ("Name");
        spiele [0] = new JLabel ("Anzahl Spiele");
        gSpiele [0] = new JLabel ("Gewonnene Spiele");
        vSpiele [0] = new JLabel ("Verlorene Spiele");
    	
    	for(int i=1;i<11;i++) {
        spielername [i] = new JLabel ("0");
        spiele [i] = new JLabel ("0");
        gSpiele [i] = new JLabel ("0");
        vSpiele [i] = new JLabel ("0");
    	}

        setPreferredSize (new Dimension (600, 310));
        setLayout (null);

        add (spielername[0]);
        add (spiele[0]);
        add (gSpiele[0]);
        add (vSpiele[0]);
        add (adden);
        add (removen);
        
        for(int i=0, j=0;i<11;i++, j=j+25) {
        	spielername[i].setBounds (0, j, 150, 25);
        	spiele[i].setBounds (150, j, 150, 25);
       		gSpiele[i].setBounds (300, j, 150, 25);
       		vSpiele[i].setBounds (450, j, 150, 25);
        }
        
        adden.setBounds (125, 280, 150, 25);
    	removen.setBounds (325, 280, 150, 25);
    	
    	adden.addActionListener(this);
    	removen.addActionListener(this);
        
        for(int i=0;i<11;i++) {
        spielername[i].setBorder(new LineBorder(Color.BLACK, 1));
        spiele[i].setBorder(new LineBorder(Color.BLACK, 1));
        gSpiele[i].setBorder(new LineBorder(Color.BLACK, 1));
        vSpiele[i].setBorder(new LineBorder(Color.BLACK, 1));
        }
    }

    public void actionPerformed (ActionEvent e){	
		 if(e.getSource()==adden) {
			 String eingabe = JOptionPane.showInputDialog("Neuer Spieler", "Namen eingeben");		 
			 for(counter=1;counter<10;counter++) {
				if(profile[counter] == null) {
					 profile[counter] = new Spielerprofil(eingabe,0,0,0);
					 spielername[counter].setText(eingabe);
					 add (spielername[counter]);
					 add (spiele[counter]);
					 add (gSpiele[counter]);
					 add (vSpiele[counter]);
					 hauptframe.revalidate();
					 hauptframe.repaint();
					 hauptframe.pack();
		             break;
				}
				else if (counter==9) {
					 JOptionPane.showMessageDialog(null, "Spielerprofile sind voll! Bitte zuerst ein Spielerprofil löschen", "Achtung", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
				}
		      }
		 	}
		 
		 if(e.getSource()==removen) {
			 counter--;
			 try {
			 int eingabe = Integer.parseInt(JOptionPane.showInputDialog("Spieler löschen", "Nummer eingeben"));
			 if (eingabe < 1|| eingabe > 9) {
				 JOptionPane.showMessageDialog(null, "Bitte eine Nummer von 1-10 eingeben!", "Fehler", JOptionPane.INFORMATION_MESSAGE);
			 }
			 else {
				 profile[eingabe] = null;
				 remove (spielername[eingabe]);
				 remove (spiele[eingabe]);
				 remove (gSpiele[eingabe]);
				 remove (vSpiele[eingabe]);
				 hauptframe.revalidate();
				 hauptframe.repaint();
				 hauptframe.pack();
			 	}
			 }
			 catch (NumberFormatException a) {
				 ImageIcon icon = new ImageIcon("C:\\Users\\User\\Desktop\\facepalm.jpg"); 
				 JOptionPane.showMessageDialog(null, "Bitte eine Nummer eingeben!", "Fehler", JOptionPane.INFORMATION_MESSAGE, icon);
             }
		 	}
		 }
    
    public static void main (String[] args) {
        hauptframe.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        hauptframe.getContentPane().add (new SpielerprofilLayout());
        hauptframe.pack();
        hauptframe.setVisible (true);
        hauptframe.setResizable(false);
    }
	
}
