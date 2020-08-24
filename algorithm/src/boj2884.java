
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2884 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		
		int h = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		
		if(m<45) {
			if(h==0) {
				h=24;
			}
			h=h-1;
			m = m+15;
			System.out.println(h+" "+m);
		}else {
			m=m-45;
			System.out.println(h+" "+m);
		}
	}

}
