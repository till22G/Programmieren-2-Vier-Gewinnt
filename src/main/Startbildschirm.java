package main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

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

	        //hinzufuegen der Buttons
	        add (multiplayer);
	        add (singleplayer);

	        //Groesse und Position der >Buttons
	        multiplayer.setBounds (150, 0, 150, 200);
	        singleplayer.setBounds (0, 0, 150, 200);
	        
	        multiplayer.addActionListener(this);
	    	singleplayer.addActionListener(this);
	    }


	    public static void main (String[] args)throws Exception {
	        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add (new Startbildschirm());
	        frame.pack();
	        frame.setResizable(false);
	        frame.setVisible (true);

		    // open the sound file as a Java input stream
		    String gongFile = "../Programmieren-2-Vier-Gewinnt/src/Bilder/NyanCat.wav"; 
		    InputStream in = new FileInputStream(gongFile);

		    // create an audiostream from the inputstream
		    AudioStream audioStream = new AudioStream(in);

		    // play the audio clip with the audioplayer class
		    AudioPlayer.player.start(audioStream);
	  			  
	  	
	    }
	
	    
	    public void actionPerformed (ActionEvent e){
	    	if(e.getSource()==multiplayer) {
	    		frame.dispose();
	    		Multiplayer.main(null);
	    	}
	    	if(e.getSource()==singleplayer) {
	    		frame.dispose();
	    		Singleplayer.main(null);
	    	}
	    }
	
}
