package ki;

public class RandomKi {
	
	//test array => later Spielfeld
	//private static int[][] field = new int[6][7];


	public static int[][] random (int[][] field) {
		
		//boolean: true if a token(2) was set, false if not
		boolean varSet = false;
		
		//counter to go up the pile of tokens
		int counter = 0;
		
		//try as long as no value is set
		while(varSet == false) {
			
			//random value between 0 and 6
			//if no token got set in this column try a different random number
			int var = (int) (Math.random()*6);
	
			//if lowest field is already occupied try the one above
			while(counter < field[0].length) {
				//if field is not occupied set value
				if(field[counter][var] == 0) {
					field[counter][var] = 2;
					//if field was set varSet == true
					return field;
				}
			//increment counter if field could not be set to try the one above
			else counter ++;
			}
		}
		return field;
	}
	
	
	
	
	//print array (its upside down) for testing
	public static void print(int[][] field) {
		
		for(int i = 0; i < 6 ; i++) {
			System.out.println();
			for(int j = 0; j < 7; j++) {
				System.out.print(field[i][j]+" ");
			}
		}
	}
	
	
	//Test if random works
	/*public static void main(String[] args) {
		
		print(field);
		random(field);
		System.out.println();
		System.out.println("-------------");
		print(field);
		random(field);
		System.out.println();
		System.out.println("-------------");
		print(field);
		random(field);
		System.out.println();
		System.out.println("-------------");
		print(field);
		random(field);
		System.out.println();
		System.out.println("-------------");
		
	}*/

}
