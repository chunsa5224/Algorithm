
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1003 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int input[] = new int [c];
		
		for(int i=0; i<c;i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<c;i++) {
			int j= input[i];
			fibo(j);
		}
		
	}
	static void fibo(int j) {
		int fibo [][] = new int [j+1][2];
		fibo[0][0]= 1;
		if(j!=0) {
			fibo[1][1] =1;
		}
		for(int k=2;k<j+1;k++) {
			fibo [k][0]= fibo[k-1][0]+fibo[k-2][0];
			fibo [k][1]= fibo[k-1][1]+fibo[k-2][1];
		}
		System.out.println(fibo[j][0] + " " + fibo[j][1]);
	}
	

}
	