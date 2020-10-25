import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int [] apli = new int [n+1];
			int answer =1;
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				apli[a]=b;
			}
			int min = apli[1];
			for(int i=1; i<=n; i++) {
				if(apli[i]<min) {
					min = apli[i];
					answer++;
				}
			}
			System.out.println(answer);
			
			
		}
	}

}
