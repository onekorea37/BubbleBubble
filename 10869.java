import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
				
			Scanner sc = new Scanner(System.in);

			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(A+B);
			System.out.println(A-B);
			System.out.println(A*B);
			System.out.println(A/B);
			System.out.println(A%B);

	}

}


// Another way

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / B);
        System.out.println(A % B);
	}
}




[Source]
https://www.acmicpc.net/problem/10869
https://st-lab.tistory.com/41
