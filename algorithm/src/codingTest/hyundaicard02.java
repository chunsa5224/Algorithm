package codingTest;

import java.util.Arrays;

public class hyundaicard02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ip_addrs= {"7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0"}; 
		String[] langs= {"C++", "Java", "C#", "C#", "C", "Python3"}; 
		int[] scores= {314, 225, 45, 0, 155, 400};
		int answer;
		int [] cheeter = new int [ip_addrs.length];
		for(int i=0; i<ip_addrs.length; i++) {
			String a = ip_addrs[i];
			for(int j=0; j<i; j++) {
				if(a.equals(ip_addrs[j])) {
					cheeter[j] =i;
					cheeter[i] =i;
				}
			}
		}
		
		for(int i=0; i<6;i++) {
			System.out.println(cheeter[i]);
		}
		
		
		
	}

}
