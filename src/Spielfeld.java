import java.awt.*;
import javax.swing.*;

public class Spielfeld extends JPanel{  //Standard Panel

static final long serialVersionUID = 1; //Version Nummer

	private JMenuBar dieBar;			//obere Leiste 
	private JTextField Spieler1;		//Textfelder fuer die Namen der Spieler
	private JTextField Spieler2;
	private JLabel Text1;				//Texte vor den Textfeldern
	private JLabel Text2;
	
	public static JButton [][] feld = new JButton [6][7];	//Array fuer die Spielfelder vom Typ JButton
	public static JMenuItem [] menufeld = new JMenuItem[5]; //Array fuer die MenueItems
			
    public Spielfeld() {
    	
    	for (int i=0;i<6;i++) {						//erstellen der buttons
    		for(int j=0;j<7;j++) {
    			feld[i][j]=new JButton("");
    		}
    	}
  
        //erstellen der Menueleistenobjekte und Spielernamenfelder
        JMenu gameMenu = new JMenu ("Game");
        menufeld[0]=new JMenuItem("New");
        gameMenu.add (menufeld[0]);
        menufeld[1] = new JMenuItem ("Exit");
        gameMenu.add (menufeld[1]);
        menufeld[4] = new JMenuItem ("Scoreboard");
        gameMenu.add (menufeld[4]);
        JMenu optionMenu = new JMenu ("Options");
        menufeld[2] = new JMenuItem ("Singleplayer");
        optionMenu.add (menufeld[2]);
        menufeld[3] = new JMenuItem ("Multiplayer");
        optionMenu.add (menufeld[3]);
        Spieler1 = new JTextField (10);
        Spieler2 = new JTextField (10);
        Text1 = new JLabel ("Player1:");
        Text2 = new JLabel ("Player2:");	

        //konstruieren der Menueleiste
        dieBar = new JMenuBar();
        dieBar.add (gameMenu);
        dieBar.add (optionMenu);


        //Groesse des Layouts und setzen
        setPreferredSize (new Dimension (608, 484));
        setLayout (null);

        //Spielfeldfelder einfuegen
    	for (int i=0;i<6;i++) {
    		for(int j=0;j<7;j++) {
    			add(feld[i][j]);
    		}
    	} 
    	
    	//Menuefelder einfuegen
    	gameMenu.add(menufeld[0]);
    	gameMenu.add(menufeld[1]);
    	gameMenu.add(menufeld[4]);
    	optionMenu.add(menufeld[2]);
    	optionMenu.add(menufeld[3]);
    	
    	add (dieBar);			//den Rest einfuegen
    	add (Spieler1);
    	add (Spieler2);
    	add (Text1);
    	add (Text2);
    	
    	//Hintergrundbild fuer die JButtons
    	for (int i=0;i<6;i++) {
    		for(int j=0;j<7;j++) {
    			
    			feld[i][j].setIcon(new ImageIcon("../Programmieren-2-Vier-Gewinnt/src/Bilder/LeeresFeld.png"));
    		}
    	}

        //Groesse und Position der JButtons setzen
    	for (int i=0, l=100;i<6;i++,l=l+64) {
    		for(int j=0, k=80;j<7;j++,k=k+64) {
    			
    			feld[i][j].setBounds (k, l, 64, 64);
    		}
    	}
    	
    	dieBar.setBounds (0, 0, 608, 25);			//Groesse und Position der uebrigen Objekte
    	Spieler1.setBounds(60, 50, 100, 25);
    	Spieler2.setBounds(508, 50, 100, 25);
    	Text1.setBounds(0, 50, 100, 25);
    	Text2.setBounds(448, 50, 100, 25);
    }

}
