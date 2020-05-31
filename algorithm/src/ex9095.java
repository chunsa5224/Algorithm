import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex9095 {
	static int [] result = new int [10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int [] num =new int [t];
		
		for(int i= 0; i<t; i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0; i<t;i++) {
			System.out.println(cal(num[i]));
		}
	}
	
	static int cal(int r) {
		
		result[0]=1;
		result[1]=2;
		result[2]=4;
		
		if(r==1) {
			return 1;
		}else if(r==2) {
			return 2;
		}else if(r==3) {
			return 4;
		}else {
			result[r-1]=cal(r-1)+cal(r-2)+cal(r-3);
		}
		return result[r-1];
	}

}
