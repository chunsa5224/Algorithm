package codingTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SCPC_diet {
	static int Answer;

	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int A [][] = new int [N][2];
			int B [][] = new int [N][2];
			for(int j=0; j<N; j++) {
				A[j][1] = sc.nextInt();
			}
			for(int j=0; j<N; j++) {
				B[j][1] = sc.nextInt();
			}
			Arrays.sort(A, Comparator.comparingInt(o1 -> o1[1]));
			Arrays.sort(B, Comparator.comparingInt(o1 -> o1[1]));
			for(int i=0; i<N; i++) {
				
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
