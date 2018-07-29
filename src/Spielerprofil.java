
public class Spielerprofil {

	public String name;
	public int anzahlSpiele;
	public int gewonneneSpiele;
	public int verloreneSpiele;
	public int durchschnittlicheZüge;
	
	public Spielerprofil(String spielername, int anzSpiele, int gewSpiele, int verSpiele) {
		
		name = spielername;
		anzahlSpiele = anzSpiele;
		gewonneneSpiele = gewSpiele;
		verloreneSpiele = verSpiele;
	}
	
	
	//Konstruktor initialisiert Spieler mit gegebenem namen und noch keinen Spielen
	public Spielerprofil(String spielername) {
		this.name = spielername;
		this.anzahlSpiele = 0;
		this.gewonneneSpiele = 0;
		this.verloreneSpiele = 0;
		this.durchschnittlicheZüge = 0;
		
	}
	
	//print Methode gibt Informationen zum Spielerprofil auf der Konsole aus
	public void print() {
		System.out.println("Spielername: " + name);
		System.out.println("Anzahl Spiele: " + anzahlSpiele);
		System.out.println("Gewonnene Spiele: " + gewonneneSpiele);
		System.out.println("Verlorene Spiele: " + verloreneSpiele);
		System.out.println("Die durchschnittliche Anzahl an Zügen ist:" + durchschnittlicheZüge);
	}
	
	
	
	//Getter und Setter für Spielerprofil

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnzahlSpiele() {
		return anzahlSpiele;
	}

	public void setAnzahlSpiele(int anzahlSpiele) {
		this.anzahlSpiele = anzahlSpiele;
	}

	public int getGewonneneSpiele() {
		return gewonneneSpiele;
	}

	public void setGewonneneSpiele(int gewonneneSpiele) {
		this.gewonneneSpiele = gewonneneSpiele;
	}

	public int getVerloreneSpiele() {
		return verloreneSpiele;
	}

	public void setVerloreneSpiele(int verloreneSpiele) {
		this.verloreneSpiele = verloreneSpiele;
	}

	public int getDurchschnittlicheZüge() {
		return durchschnittlicheZüge;
	}

	public void setDurchschnittlicheZüge(int durchschnittlicheZüge) {
		this.durchschnittlicheZüge = durchschnittlicheZüge;
	}
	
	
	
}
