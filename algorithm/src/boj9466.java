

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9466 {
	static int count;
	static boolean visit[];
	static int student [];
	static boolean finish[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int ans [] = new int [T];
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			student  = new int [S+1];
			visit = new boolean[S+1];
			finish = new boolean [S+1];
			count=0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=S; i++) {
				student[i]=(Integer.parseInt(st.nextToken()));
			}
			for(int i=1; i<=S; i++) {
				dfs(i);
			}
			ans[t]=S-count;
			if(S-count<0) ans[t]=0;
			
			
		}
 		for(int t:ans) {
 			System.out.println(t);
 		}
	}
	static void dfs(int i) {
		if(visit[i]) return;
		visit[i]=true;
		int next= student[i];
		if(!visit[next]) dfs(next);
		else {
			if(!finish[next]) {
				System.out.println(next);
				count++;
				for(int j=next; j!=i; j=student[j]) {
					System.out.println("I have team : "+j);
					count++;
				}
			}
		}
		finish[i]=true;
			
	}

}
