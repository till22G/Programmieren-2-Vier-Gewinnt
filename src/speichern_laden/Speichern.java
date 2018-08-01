package speichern_laden;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import interfaces.ISpeichern;
import main.Spielerprofil;;

public class Speichern implements ISpeichern {
		
			
	//Spielerprofil  wir methode übergeben damit um dann im Spielerprofil file abgelegt zu werden
	public static boolean save(ArrayList<Spielerprofil> List) {
		
		// initialize outputstream out
		ObjectOutputStream out = null;
		
		//try catch to catch different exceptions
		try {
			//new stream in .txt data
			out = new ObjectOutputStream(new FileOutputStream("../Programmieren-2-Vier-Gewinnt/src/Spielerprofile/Spielerprofile.txt"));
			//write Spielerprofil to Spielerprofile.txt
			out.writeObject(List);
			//close out
			out.close();
			//if write back worked  return true
			return true;
		} 
		
		catch (IOException e) {
			//exception message if IOException occurs
			System.out.println("writing back List failed");
			e.printStackTrace();
			//if exception is thrown return false
			return false;
			
		}
	}
}
