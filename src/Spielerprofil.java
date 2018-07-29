
public class Spielerprofil {

	public String name;
	public int anzahlSpiele;
	public int gewonneneSpiele;
	public int verloreneSpiele;

	
	public Spielerprofil(String spielername, int anzSpiele, int gewSpiele, int verSpiele) {
		
		name = spielername;
		anzahlSpiele = anzSpiele;
		gewonneneSpiele = gewSpiele;
		verloreneSpiele = verSpiele;
	}
	
	public void print() {
		
		System.out.println("Spielername: " + name);
		System.out.println("Anzahl Spiele: " + anzahlSpiele);
		System.out.println("Gewonnene Spiele: " + gewonneneSpiele);
		System.out.println("Verlorene Spiele: " + verloreneSpiele);
	}
	
	public static void main (String[]args) {
		
	}
	
}
