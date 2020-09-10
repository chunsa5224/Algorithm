import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj5052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			String [] num = new String[n];
			for(int i=0; i<n; i++) {
				num[i] = br.readLine();
			}
			Arrays.sort(num, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
			int i=1;
			for(; i<n; i++) {
				if(num[i].startsWith(num[i-1])) {
					System.out.println("NO");
					break;
				}
			}
			if(i==n) System.out.println("YES");
			
		}
	}

}
