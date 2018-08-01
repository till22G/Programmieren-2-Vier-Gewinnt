package speichern_laden;

import java.util.ArrayList;


import main.Spielerprofil;

public class SpeichernTest {
	
	public static void main(String[] args) {
		  
		ArrayList<Spielerprofil> L = new ArrayList<>();
		
		Spielerprofil s1 = new Spielerprofil("Horst");
		Spielerprofil s2 = new Spielerprofil("Peter");
		Spielerprofil s3 = new Spielerprofil("Miriam");
		Spielerprofil s4 = new Spielerprofil("Karl-Heinz");
		
		L.add(s1);
		L.add(s2);
		L.add(s3);
		L.add(s4);
		
		
		Speichern.saveProfile(s1);
		
		Speichern.save(L);
		
		ArrayList<Spielerprofil> List = Laden.LoadProfiles();
	
		
		for(int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i).getName());
		}
		
		
		
	}

}
	