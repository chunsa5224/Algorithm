
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj1110 {
=======
public class ex1110 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		int count =1;
		int old =i;
		int n = i%10*10+(i/10+i%10)%10;
		
		for(int j=0; i!=n; j++) {
			old = n;
			n=n%10*10+(n/10+n%10)%10;
			count ++;
		}
		System.out.println(count);
	}
}
