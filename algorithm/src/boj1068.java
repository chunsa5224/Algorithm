

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1068 {
	static int [] tree;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new int [n];
		String s []= br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			tree[i] = Integer.parseInt(s[i]);
		}
		int cnt=0;
		int r = Integer.parseInt(br.readLine());
		if(tree[r]!=-1){
			truncate(r);
			for(int i=0; i<n;i++) {
				int temp=0;
				if(tree[i]<-1) continue;
				for(int j=0; j<n;j++) {
					if(tree[j]==i) {
						break;
					}else {
						temp++;
					}
				}
				if(temp==n) cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	static void truncate(int a) {
		for(int i=0; i<n; i++) {
			if(i==a) {
				tree[a]=-2; 
			}
			if(tree[i]==a) {
				tree[i]=-2;
				truncate(i);
			}
		}
	}
	

}
