package speichern_laden;

import main.Spielerprofil;

public class SpeichernTest {
	
	public static void main(String[] args) {
		
		
		Spielerprofil s = new Spielerprofil("Hans");
		Spielerprofil s1 = new Spielerprofil("Horst");
		Speichern.save(s1);
		Speichern.save(s);
		
	}

}
	