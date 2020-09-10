import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1701 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n=s.length();
		int max=0;
		for(int i=0; i<n; i++) {
			max= Math.max(max, getMax(s.substring(i, n)));
		}
		System.out.println(max);
	}
	static int getMax(String s) {
		int n=s.length();
		int max=0;
		int j=0; 
		int [] fail = new int [n];
		for(int i=1; i<n; i++) {
			if(s.charAt(i)==s.charAt(j)) {
				max = Math.max(max, fail[i] = ++j);
			}else if(j>0 && s.charAt(i)!=s.charAt(j)){
				j=fail[j-1];
				i--;
			}
		}
		return max;
	}

}
