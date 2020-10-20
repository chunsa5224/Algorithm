import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer =0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0 ; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(pq.size()!=1) {
			int p = pq.poll();
			int q = pq.poll();
			answer += p+q;
			pq.offer(p+q);
		}
		System.out.println(answer);
	}

}
