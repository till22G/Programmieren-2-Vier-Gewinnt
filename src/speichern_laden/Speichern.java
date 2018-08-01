package speichern_laden;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import main.Spielerprofil;;

public class Speichern {
		
			
	//Spielerprofil  wir methode übergeben damit um dann im Spielerprofil file abgelegt zu werden
	public static boolean save(Spielerprofil Spieler) {
		
		// initialize outputstream out
		ObjectOutputStream out;
		
		//try catch to catch different exceptions
		try {
			//new stream in .txt data
			out = new ObjectOutputStream(new FileOutputStream("../Programmieren-2-Vier-Gewinnt/src/Spielerprofile/Spielerprofile.txt"));
			//write Spielerprofil to Spielerprofile.txt
			out.writeObject(Spieler);
			//close out
			out.close();
			//if write back worked  return true
			return true;
		} 
		catch (IOException e) {
			//exception message if IOException occurs
			System.out.println("writing back Spielerprofiel failed");
			e.printStackTrace();
			//if exception is thrown return false
			return false;
			
		}
	}
}
