import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Startbildschirm extends JPanel implements ActionListener {	//Standard Panel

	static final long serialVersionUID = 1; //Version Nummer
	
	    public JButton multiplayer;
	    public JButton singleplayer;
	    private static JFrame frame = new JFrame ("Startbildschirm");

	    public Startbildschirm() {
	    	
	        //Buttons erstellen
	        multiplayer = new JButton ("Multiplayer");
	        singleplayer = new JButton ("Singleplayer");

	        //adjust size and set layout
	        setPreferredSize (new Dimension (300, 200));
	        setLayout (null);

	        //hinzufügen der Buttons
	        add (multiplayer);
	        add (singleplayer);

	        //Größe und Position der >Buttons
	        multiplayer.setBounds (150, 0, 150, 200);
	        singleplayer.setBounds (0, 0, 150, 200);
	        
	        multiplayer.addActionListener(this);
	    	singleplayer.addActionListener(this);
	    }


	    public static void main (String[] args) {
	        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add (new Startbildschirm());
	        frame.pack();
	        frame.setResizable(false);
	        frame.setVisible (true);
	    }
	
	    
	    public void actionPerformed (ActionEvent e){
	    	if(e.getSource()==multiplayer) {
	    		frame.dispose();
	    		Multiplayer.main(null);
	    	}
	    	if(e.getSource()==singleplayer) {
	    		frame.dispose();
	    		Multiplayer.main(null);
	    	}
	    }
	
}
