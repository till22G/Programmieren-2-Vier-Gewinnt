package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Singleplayer implements ActionListener {		//implementieren, um Aktionen per Mausklick festzulegen
	
	public static int [] counter = {5,5,5,5,5,5,5};		//Z�hler f�r jede Spalte
	public int changer =1;								//flag f�r Spielerwechsel
	public int vorbei = 0;								//flag f�r Spielende nur f�r KI, damit kein Stein mehr erstellt wird bei Neustart
	public int [][] counterfeld = new int [6][7];		//Z�hler der Spielsteine 1 f�r rot, 2 f�r gelb
	public int gewinncounter = 0;						//Z�hler f�r Steine in Reihe
	private static JFrame frame2 = new JFrame ("4 Gewinnt");		//erstellen des Windows K�stchen
	
	//Strings f�r Bilder
	String URLLeeresFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/LeeresFeld.png";
	String URLGelbesFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/GelbesFeld.png";
	String URLRotesFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/RotesFeld.png";
	
	
	
	public Singleplayer (){									
		for (int i=0;i<6;i++) {
    		for(int j=0;j<7;j++) {
    			Spielfeld.feld[i][j].addActionListener(this);	//hinzuf�gen der JButtons zu ActionListener, um diese ansprechen zu k�nnen
    		}
    	}
		
		for(int s=0;s<5;s++) {									
			Spielfeld.menufeld[s].addActionListener(this);		//hinzuf�gen der JMenuItems zu ActionListener, um diese ansprechen zu k�nnen
		}
	}
	
	public static void main (String[] args) {
        frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);		//wenn x gedr�ckt Spiel beenden
        frame2.getContentPane().add (new Spielfeld());				//erstellen des Spielfeldes
        frame2.pack();
        frame2.setVisible (true);									//anzeigen
        frame2.setResizable(false);
        Singleplayer vierGewinnt = new Singleplayer();
        
	}
	
	 public void actionPerformed (ActionEvent e){	
		 if(e.getSource()==Spielfeld.menufeld[0]) {			//f�r JMenuItem "Neu"
			 gewinncounter=0;
			 changer=1;
			 for (int x=0;x<6;x++) {
		    		for(int y=0;y<7;y++) {
		    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
		    			counterfeld[x][y]=0;
		    		}
		    	}
			 for(int m=0;m<7;m++) {
				 counter[m]=5;
			 }
		 }
		 
		 if(e.getSource()==Spielfeld.menufeld[1]) {			//f�r JMenuItem "Exit"
			 System.exit(0);
		 }
		 
		 if(e.getSource()==Spielfeld.menufeld[2]) {			//f�r JMenuItem "Singleplayer"
			 frame2.dispose();
			 Singleplayer.main(null);
		 }
		 
		 if(e.getSource()==Spielfeld.menufeld[3]) {			//f�r JMenuItem "Multiplayer"
			 frame2.dispose();
			 Multiplayer.main(null);
		 }
		 if(e.getSource()==Spielfeld.menufeld[4]) {			//f�r JMenuItem "Spielerprofile"
			 SpielerprofilLayout.main(null);
		 }
		 
		 for(int i=0;i<7;i++) {										//wenn JButton gedr�ckt, �ndere counter
			 for(int j=0;j<6;j++) {									//wenn JButton gedr�ckt, �ndere Image
				 if(e.getSource() == Spielfeld.feld[j][i]){			//wenn JButton gedr�ckt, �ndere changer
					 if (counter[i]>-1) {
						 
							 Spielfeld.feld[counter[i]][i].setIcon(new ImageIcon(URLRotesFeld));
							 changer = 2;
							 counterfeld[counter[i]][i] = 1;		//wird zum �berpr�fen gesetzt
							 counter[i]--;
							 
							 for(int a=0;a<6;a++) {								//horizontal
								 gewinncounter=0;
								 for(int b=0;b<7;b++) {
									 if(counterfeld[a][b] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[a][b] == 2 || counterfeld[a][b] == 0) {
										 gewinncounter=0;
									 }
								 }
							 }
							 
							 for(int a=0;a<7;a++) {								//vertikal
								 gewinncounter=0;
								 for(int b=0;b<6;b++) {
									 if(counterfeld[b][a] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[b][a] == 2 || counterfeld[b][a] == 0) {
										 gewinncounter=0;
									 }
								 }
							 }

							for(int a=2, b=0;a>-1;a--) {						//diagonal links nach rechts
								gewinncounter=0;
								for(int c=a, d=b;c<6;c++,d++) {
									if(counterfeld[c][d] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
										 gewinncounter=0;
									 }
								}
							}
							
							for(int a=0, b=1;b<4;b++) {							//diagonal links nach rechts
								gewinncounter=0;
								for(int c=a, d=b;d<7;c++, d++ ) {
									if(counterfeld[c][d] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
										 gewinncounter=0;
									 }
								}
							}
							
							for(int a=2, b=6;a>-1;a--) {						//diagonal rechts nach links
								gewinncounter=0;
								for(int c=a, d=b;c<6;c++,d--) {
									if(counterfeld[c][d] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
										 gewinncounter=0;
									 }
								}
							}
							
							for(int a=0, b=3;b<6;b++) {							//diagonal rechts nach links
								gewinncounter=0;
								for(int c=a, d=b;d>-1;c++, d--) {
									if(counterfeld[c][d] == 1) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 vorbei = 1;
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
										 gewinncounter=0;
									 }
								}
							}
							
							for(int v =0, t=0;v<7;v++) {				//unentschieden??
								if (counter[v]==-1) {
									t++;
									if(t==7) {
										
										System.out.println("vorbei");
										 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Unentschieden", JOptionPane.YES_NO_OPTION);
										 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
											 System.exit(0);
										 }
										 else if (result==JOptionPane.YES_OPTION) {
											 gewinncounter=0;
											 changer=1;
											 for (int x=0;x<6;x++) {
										    		for(int y=0;y<7;y++) {
										    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
										    			counterfeld[x][y]=0;
										    		}
										    	}
											 for(int m=0;m<7;m++) {
												 counter[m]=5;
											 }
										 }
									}
								}
								
								else {
									t=0;
								}
							}
							
							if(vorbei == 0) {
							
							int p = (int)(Math.random()*7);
							
							while(counter[p]==-1) {
								p = (int)(Math.random()*7);
							}
							
							 Spielfeld.feld[counter[p]][p].setIcon(new ImageIcon(URLGelbesFeld));;
							 changer = 1;
							 counterfeld[counter[p]][p] = 2;	 
							 counter[p]--;
							 
							 for(int a=0;a<6;a++) {								//horizontal
								 gewinncounter=0;
								 for(int b=0;b<7;b++) {
									 if(counterfeld[a][b] == 2) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[a][b] == 1 || counterfeld[a][b] == 0) {
										 gewinncounter=0;
									 }
								 }
							 }
							 
							 for(int a=0;a<7;a++) {								//vertikal
								 gewinncounter=0;
								 for(int b=0;b<6;b++) {
									 if(counterfeld[b][a] == 2) {
										 gewinncounter++;
										 if(gewinncounter==4) {
											 System.out.println("vorbei");
											 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
											 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
												 System.exit(0);
											 }
											 else if (result==JOptionPane.YES_OPTION) {
												 gewinncounter=0;
												 changer=1;
												 for (int x=0;x<6;x++) {
											    		for(int y=0;y<7;y++) {
											    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
											    			counterfeld[x][y]=0;
											    		}
											    	}
												 for(int m=0;m<7;m++) {
													 counter[m]=5;
												 }
											 }
										 }
									 }
									 else if(counterfeld[b][a] == 1 || counterfeld[b][a] == 0) {
										 gewinncounter=0;
									 }
								 }
							 }
							 
							 for(int a=2, b=0;a>-1;a--) {						//diagonal links nach rechts
									gewinncounter=0;
									for(int c=a, d=b;c<6;c++,d++) {
										if(counterfeld[c][d] == 2) {
											 gewinncounter++;
											 if(gewinncounter==4) {
												 System.out.println("vorbei");
												 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
												 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
													 System.exit(0);
												 }
												 else if (result==JOptionPane.YES_OPTION) {
													 gewinncounter=0;
													 changer=1;
													 for (int x=0;x<6;x++) {
												    		for(int y=0;y<7;y++) {
												    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
												    			counterfeld[x][y]=0;
												    		}
												    	}
													 for(int m=0;m<7;m++) {
														 counter[m]=5;
													 }
												 }
											 }
										 }
										 else if(counterfeld[c][d] == 1 || counterfeld[c][d] == 0) {
											 gewinncounter=0;
										 }
									}
								}
								
								for(int a=0, b=1;b<4;b++) {						//diagonal links nach rechts
									gewinncounter=0;
									for(int c=a, d=b;d<7;c++, d++ ) {
										if(counterfeld[c][d] == 2) {
											 gewinncounter++;
											 if(gewinncounter==4) {
												 System.out.println("vorbei");
												 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
												 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
													 System.exit(0);
												 }
												 else if (result==JOptionPane.YES_OPTION) {
													 gewinncounter=0;
													 changer=1;
													 for (int x=0;x<6;x++) {
												    		for(int y=0;y<7;y++) {
												    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
												    			counterfeld[x][y]=0;
												    		}
												    	}
													 for(int m=0;m<7;m++) {
														 counter[m]=5;
													 }
												 }
											 }
										 }
										 else if(counterfeld[c][d] == 1 || counterfeld[c][d] == 0) {
											 gewinncounter=0;
										 }
									}
								}
							 
								for(int a=2, b=6;a>-1;a--) {						//diagonal rechts nach links
									gewinncounter=0;
									for(int c=a, d=b;c<6;c++,d--) {
										if(counterfeld[c][d] == 2) {
											 gewinncounter++;
											 if(gewinncounter==4) {
												 System.out.println("vorbei");
												 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
												 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
													 System.exit(0);
												 }
												 else if (result==JOptionPane.YES_OPTION) {
													 gewinncounter=0;
													 changer=1;
													 for (int x=0;x<6;x++) {
												    		for(int y=0;y<7;y++) {
												    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
												    			counterfeld[x][y]=0;
												    		}
												    	}
													 for(int m=0;m<7;m++) {
														 counter[m]=5;
													 }
												 }
											 }
										 }
										 else if(counterfeld[c][d] == 1 || counterfeld[c][d] == 0) {
											 gewinncounter=0;
										 }
									}
								}
								
								for(int a=0, b=3;b<6;b++) {							//diagonal rechts nach links
									gewinncounter=0;
									for(int c=a, d=b;d>-1;c++, d--) {
										if(counterfeld[c][d] == 2) {
											 gewinncounter++;
											 if(gewinncounter==4) {
												 System.out.println("vorbei");
												 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Spiel vorbei", JOptionPane.YES_NO_OPTION);
												 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
													 System.exit(0);
												 }
												 else if (result==JOptionPane.YES_OPTION) {
													 gewinncounter=0;
													 changer=1;
													 for (int x=0;x<6;x++) {
												    		for(int y=0;y<7;y++) {
												    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
												    			counterfeld[x][y]=0;
												    		}
												    	}
													 for(int m=0;m<7;m++) {
														 counter[m]=5;
													 }
												 }
											 }
										 }
										 else if(counterfeld[c][d] == 1 || counterfeld[c][d] == 0) {
											 gewinncounter=0;
										 }
									}
								}
							}
							else {
								vorbei = 0;
							}
						 
					 }
					 else {																	//wenn counter <0, gib aus "nicht m�glich"
					 System.out.println("Nicht m�glich");
					 JOptionPane.showMessageDialog(null, "Dieser Zug ist nicht m�glich");
					 }
		 
				 }
			 }
		 }
		 
		 for(int v =0, t=0;v<7;v++) {				//unentschieden??
				if (counter[v]==-1) {
					t++;
					if(t==7) {
						
						System.out.println("vorbei");
						 int result = JOptionPane.showConfirmDialog(null, "Nochmal?", "Unentschieden", JOptionPane.YES_NO_OPTION);
						 if(result==JOptionPane.NO_OPTION || result==JOptionPane.CLOSED_OPTION) {
							 System.exit(0);
						 }
						 else if (result==JOptionPane.YES_OPTION) {
							 gewinncounter=0;
							 changer=1;
							 for (int x=0;x<6;x++) {
						    		for(int y=0;y<7;y++) {
						    			Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
						    			counterfeld[x][y]=0;
						    		}
						    	}
							 for(int m=0;m<7;m++) {
								 counter[m]=5;
							 }
						 }
					}
				}
				
				else {
					t=0;
				}
			}
		 
	 }
	 
	 
}