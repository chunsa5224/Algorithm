package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ex1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s [] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int idx [] = new int [100001];
		Arrays.fill(idx, 1000000);
		idx[n]=0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		int x = n;
		int time =0;
		while(!q.isEmpty()) {
			
			x = q.poll();
			if(x==k) break;
			time = idx[x];
			
			if(x<=50000) {
				int c = 2*x;
				if(idx[c]==1000000) {
					q.add(c);
					idx[c] = time+1;
				}
			}
			if(x>0) {
				int a = x-1;
				if(idx[a]==1000000) {
					q.add(a);
					idx[a] = time+1;
				}
			}
			if(x<100000) {
				int b = x+1;
				if(idx[b]==1000000) {
					q.add(b);
					idx[b] = time+1;
				}
			}
		}
		
		System.out.println(idx[k]);

	}

}
