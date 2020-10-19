
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj1912 {
=======
public class ex1912 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		int [] sol = new int [n];
		String [] arr = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			num[i]=Integer.parseInt(arr[i]);
		}
		sol[0]=num[0];
		for(int i=1; i<n;i++) {
			if(sol[i-1]+num[i]>num[i]) {
				sol[i]=sol[i-1]+num[i];
			}else {
				sol[i]=num[i];
			}
		}
		int max=sol[0];
		for(int i=0; i<n; i++) {
			if(max<sol[i]) {
				max=sol[i];
			}
		}
		System.out.println(max);
	}

}
