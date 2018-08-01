import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpielerprofilLayout extends JPanel implements ActionListener {
	
	static final long serialVersionUID = 1;

    private JLabel [] spielername = new JLabel [11];
    private JLabel [] spiele = new JLabel [11];
    private JLabel [] gSpiele = new JLabel [11];
    private JLabel [] vSpiele = new JLabel [11];
    private JButton adden = new JButton("Add");
    private JButton removen = new JButton("Delete");
    public int counter = 1;
    public static Spielerprofil [] profile = new Spielerprofil[10];
    public static JFrame hauptframe = new JFrame ("Players");

    public SpielerprofilLayout() {
        
    	spielername [0] = new JLabel ("Name");
        spiele [0] = new JLabel ("Played Games");
        gSpiele [0] = new JLabel ("Won");
        vSpiele [0] = new JLabel ("Lost");
    	
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
			 String eingabe = JOptionPane.showInputDialog("new player", "insert name");
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
					 JOptionPane.showMessageDialog(null, "maximum ammount of players reached, delete one", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
				}
		      }
		 	}
		 
		 if(e.getSource()==removen) {
			 counter--;
			 try {
			 int eingabe = Integer.parseInt(JOptionPane.showInputDialog("delete player", "insert number"));
			 if (eingabe < 1|| eingabe > 9) {
				 JOptionPane.showMessageDialog(null, "Please insert a number between 1-10!", "Error", JOptionPane.INFORMATION_MESSAGE);
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
				 ImageIcon icon = new ImageIcon("../Programmieren-2-Vier-Gewinnt/src/Bilder/facepalm.jpg"); 
				 JOptionPane.showMessageDialog(null, "Please insert a number!", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
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
