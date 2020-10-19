
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj3053 {
=======
public class ex3053 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		double uclid = i*i*Math.PI;
		double taxi = (i*2)*i;
		
		System.out.printf("%.6f\n",uclid);
		System.out.printf("%.6f",taxi);
	}

}
