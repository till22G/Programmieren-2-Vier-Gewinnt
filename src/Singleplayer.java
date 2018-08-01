
// komp. V1

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Singleplayer implements ActionListener { // implementieren, um Aktionen per Mausklick festzulegen

	public static int[] counter = { 5, 5, 5, 5, 5, 5, 5 }; // Zaehler fuer jede Spalte
	public int changer = 1; // flag fuer Spielerwechsel
	public int vorbei = 0; // flag fuer Spielende nur fuer KI, damit kein Stein mehr erstellt wird bei
							// Neustart
	public int[][] counterfeld = new int[6][7]; // Zaehler der Spielsteine 1 fuer rot, 2 fuer gelb
	public int gewinncounter = 0; // Zaehler fuer Steine in Reihe
	private static JFrame frame2 = new JFrame("4 Gewinnt"); // erstellen des Windows Kaestchen

	// Strings fuer Bilder
	String URLLeeresFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/LeeresFeld.png";
	String URLGelbesFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/GelbesFeld.png";
	String URLRotesFeld = "../Programmieren-2-Vier-Gewinnt/src/Bilder/RotesFeld.png";

	public Singleplayer() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Spielfeld.feld[i][j].addActionListener(this); // hinzufuegen der JButtons zu ActionListener, um diese
																// ansprechen zu kuennen
			}
		}

		for (int s = 0; s < 5; s++) {
			Spielfeld.menufeld[s].addActionListener(this); // hinzufuegen der JMenuItems zu ActionListener, um diese
															// ansprechen zu koennen
		}
	}

	public static void main(String[] args) {
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wenn x gedrueckt Spiel beenden
		frame2.getContentPane().add(new Spielfeld()); // erstellen des Spielfeldes
		frame2.pack();
		frame2.setVisible(true); // anzeigen
		frame2.setResizable(false);
		Singleplayer vierGewinnt = new Singleplayer();
	}

	public void checkWinHV(int z) { // z zur unterscheidung vertikal hori diagonal
		// 1 für horizontal, 2 für vertikal
		int cnter1 = 0;
		int cnter2 = 0;
		int c;
		int helper = 0;

		if (z == 1) {
			cnter1 = 6;
			cnter2 = 7;
		} else if (z == 2) {
			cnter1 = 7;
			cnter2 = 6;
		}
		for (int a = 0; a < cnter1; a++) {
			gewinncounter = 0;
			for (int b = 0; b < cnter2; b++) {
				if (z == 2 && helper <= 0) {
					c = a;
					a = b;
					b = c;
					helper++;
				}

				if ((z == 1 && counterfeld[a][b] == 1) || (z == 2 && counterfeld[b][a] == 0)) {
					gewinncounter++;
					if (gewinncounter == 4) {
						vorbei = 1;
						System.out.println("Game Over");
						int result = JOptionPane.showConfirmDialog(null, "Play again?", "Game over",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						} else if (result == JOptionPane.YES_OPTION) {
							gewinncounter = 0;
							changer = 1;
							for (int x = 0; x < 6; x++) {
								for (int y = 0; y < 7; y++) {
									Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
									counterfeld[x][y] = 0;
								}
							}
							for (int m = 0; m < 7; m++) {
								counter[m] = 5;
							}
						}
					}
				} else if ((z==1 &&(counterfeld[a][b] == 2 || counterfeld[a][b] == 0)) || (z==2 && (counterfeld[b][a] == 2 || counterfeld[b][a] == 0))) {
					gewinncounter = 0;
				}
			}
		}
	}


	public void checkWinDLR1() { // diagnoal von links nach rechts 1
		for (int a = 2, b = 0; a > -1; a--) {
			gewinncounter = 0;
			for (int c = a, d = b; c < 6; c++, d++) {
				if (counterfeld[c][d] == 1) {
					gewinncounter++;
					if (gewinncounter == 4) {
						vorbei = 1;
						System.out.println("vorbei");
						int result = JOptionPane.showConfirmDialog(null, "Again?", "Game over",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						} else if (result == JOptionPane.YES_OPTION) {
							gewinncounter = 0;
							changer = 1;
							for (int x = 0; x < 6; x++) {
								for (int y = 0; y < 7; y++) {
									Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
									counterfeld[x][y] = 0;
								}
							}
							for (int m = 0; m < 7; m++) {
								counter[m] = 5;
							}
						}
					}
				} else if (counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
					gewinncounter = 0;
				}
			}
		}
	}

	public void checkWinDLR2() { // diagonal von links nach rechts 2
		for (int a = 0, b = 1; b < 4; b++) {
			gewinncounter = 0;
			for (int c = a, d = b; d < 7; c++, d++) {
				if (counterfeld[c][d] == 1) {
					gewinncounter++;
					if (gewinncounter == 4) {
						vorbei = 1;
						System.out.println("vorbei");
						int result = JOptionPane.showConfirmDialog(null, "Again?", "Game over",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						} else if (result == JOptionPane.YES_OPTION) {
							gewinncounter = 0;
							changer = 1;
							for (int x = 0; x < 6; x++) {
								for (int y = 0; y < 7; y++) {
									Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
									counterfeld[x][y] = 0;
								}
							}
							for (int m = 0; m < 7; m++) {
								counter[m] = 5;
							}
						}
					}
				} else if (counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
					gewinncounter = 0;
				}
			}
		}
	}

	public void checkWinDRL1() { // diagonal rechts nach links 1
		for (int a = 2, b = 6; a > -1; a--) {
			gewinncounter = 0;
			for (int c = a, d = b; c < 6; c++, d--) {
				if (counterfeld[c][d] == 1) {
					gewinncounter++;
					if (gewinncounter == 4) {
						vorbei = 1;
						System.out.println("vorbei");
						int result = JOptionPane.showConfirmDialog(null, "Again?", "Game over",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						} else if (result == JOptionPane.YES_OPTION) {
							gewinncounter = 0;
							changer = 1;
							for (int x = 0; x < 6; x++) {
								for (int y = 0; y < 7; y++) {
									Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
									counterfeld[x][y] = 0;
								}
							}
							for (int m = 0; m < 7; m++) {
								counter[m] = 5;
							}
						}
					}
				} else if (counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
					gewinncounter = 0;
				}
			}
		}
	}

	public void checkWinDRL2() { // diagonal rechts nach links 2
		for (int a = 0, b = 3; b < 6; b++) {
			gewinncounter = 0;
			for (int c = a, d = b; d > -1; c++, d--) {
				if (counterfeld[c][d] == 1) {
					gewinncounter++;
					if (gewinncounter == 4) {
						vorbei = 1;
						System.out.println("vorbei");
						int result = JOptionPane.showConfirmDialog(null, "Again?", "Game over",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						} else if (result == JOptionPane.YES_OPTION) {
							gewinncounter = 0;
							changer = 1;
							for (int x = 0; x < 6; x++) {
								for (int y = 0; y < 7; y++) {
									Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
									counterfeld[x][y] = 0;
								}
							}
							for (int m = 0; m < 7; m++) {
								counter[m] = 5;
							}
						}
					}
				} else if (counterfeld[c][d] == 2 || counterfeld[c][d] == 0) {
					gewinncounter = 0;
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Spielfeld.menufeld[0]) { // fuer JMenuItem "Neu"
			gewinncounter = 0;
			changer = 1;
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 7; y++) {
					Spielfeld.feld[x][y].setIcon(new ImageIcon(URLLeeresFeld));
					counterfeld[x][y] = 0;
				}
			}
			for (int m = 0; m < 7; m++) {
				counter[m] = 5;
			}
		}

		if (e.getSource() == Spielfeld.menufeld[1]) { // fuer JMenuItem "Exit"
			System.exit(0);
		}

		if (e.getSource() == Spielfeld.menufeld[2]) { // fuer JMenuItem "Singleplayer"
			frame2.dispose();
			Singleplayer.main(null);
		}

		if (e.getSource() == Spielfeld.menufeld[3]) { // fuer JMenuItem "Multiplayer"
			frame2.dispose();
			Multiplayer.main(null);
		}
		if (e.getSource() == Spielfeld.menufeld[4]) { // fuer JMenuItem "Spielerprofile"
			SpielerprofilLayout.main(null);
		}

		for (int i = 0; i < 7; i++) { // wenn JButton gedrueckt, aendere counter
			for (int j = 0; j < 6; j++) { // wenn JButton gedrueckt, aendere Image
				if (e.getSource() == Spielfeld.feld[j][i]) { // wenn JButton gedrueckt, aendere changer
					if (counter[i] > -1) {

						Spielfeld.feld[counter[i]][i].setIcon(new ImageIcon(URLRotesFeld));
						changer = 2;
						counterfeld[counter[i]][i] = 1; // wird zum ueberpruefen gesetzt
						counter[i]--;

						checkWinHV(1); // Horizontal
						checkWinHV(2); // vertikal

						checkWinDLR1();
						checkWinDLR2();

						checkWinDRL1();
						checkWinDLR2();

						if (vorbei == 0) {

							int p = (int) (Math.random() * 5);

							while (counter[p] == -1) {
								p = (int) (Math.random() * 5);
							}

							Spielfeld.feld[counter[p]][p].setIcon(new ImageIcon(URLGelbesFeld));
							;
							changer = 1;
							counterfeld[counter[p]][p] = 2;
							counter[p]--;

							checkWinHV(1); // horizontal Spieler 1
							checkWinHV(2); // vertikal Spieler 2

							checkWinDLR1();
							checkWinDLR2();

							checkWinDRL1();
							checkWinDRL2();

						} else {
							vorbei = 0;
						}

					} else { // wenn counter <0, gib aus "nicht moeglich"
						System.out.println("not possible");
						JOptionPane.showMessageDialog(null, "invalid move");
					}

				}
			}
		}
	}

}
