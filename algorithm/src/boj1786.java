import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1786 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int cnt =0;
		int j=0;
		int [] fail = new int [P.length()];

		for(int i=1; i<P.length(); i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) {
				j=fail[j-1];
			}
			if(P.charAt(i)==P.charAt(j)) {
				fail[i]=++j;
			}
		}
		
		j=0;
		for(int i=0; i<T.length(); i++) {
			while(j>0 && T.charAt(i)!=P.charAt(j)) {
				j=fail[j-1];
			}
			if(T.charAt(i)==P.charAt(j)) {
				if(j==P.length()-1) {
					cnt++;
					sb.append(i-j+1 +"\n");
					j=fail[j];
				}else j++;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
		
		
	}

}
