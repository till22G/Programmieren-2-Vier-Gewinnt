package speichern_laden;

import java.util.ArrayList;


import main.Spielerprofil;

public class SpeichernTest {
	
	public static void main(String[] args) {
		  
		ArrayList<Spielerprofil> L = new ArrayList<>();
		
		Spielerprofil s1 = new Spielerprofil("Spast");
		Spielerprofil s2 = new Spielerprofil("Hurensohn");
		Spielerprofil s3 = new Spielerprofil("Missgeburt");
		Spielerprofil s4 = new Spielerprofil("Reagenzglaskind");
		
		L.add(s1);
		L.add(s2);
		L.add(s3);
		L.add(s4);
		
		Speichern.save(L);
		
		ArrayList<Spielerprofil> Listööö = Laden.LoadProfiles();
		
		for(int i = 0; i < Listööö.size(); i++) {
			System.out.println(Listööö.get(i).getName());
		}
		
	}

}
	