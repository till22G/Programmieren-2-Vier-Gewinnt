package speichern_laden;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import interfaces.ILaden;
import main.Spielerprofil;

public class Laden implements ILaden {
	
	//load profiles and return ArrayList
	public static ArrayList<Spielerprofil> LoadProfiles() {
		
		//initialize ArrayList with Spielerprofil
		ArrayList<Spielerprofil> List;
		
		
		try {
			//new ObjectInputStream in to get the saved ArrayList
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("../Programmieren-2-Vier-Gewinnt/src/Spielerprofile/Spielerprofile.txt"));
		
			//get ArrayList from saved data
			List = (ArrayList<Spielerprofil>) in.readObject();
		
			//return List
			return List;
		}
		
		catch(IOException IOe) {
			IOe.printStackTrace();
			System.out.println("Es gab leider eine IO Exception");
			return List = null;
		}
		catch(ClassNotFoundException CNFe) {
			CNFe.printStackTrace();
			System.out.println("Es gab leider eine ClassNotFoundException");
			return List = null;
		}	
		
	}

}
