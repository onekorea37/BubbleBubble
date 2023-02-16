
/*
* Q. Thailand, a Buddhist country, uses the Buddhist prayer of immortality, 
* or Buddha, which counts the year based on the year when Sakyamuni was nirvana. 
* On the other hand, Korea uses the year of the year of the new year. 
* Write a program that converts a blowing year to a standing year when given a blowing year.
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18108 {
	public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int y = Integer.parseInt(br.readLine());
			System.out.println(y - 543); // 543 is the year Buddha died in B.C.
	}
}

// What I learned today .. think simply
