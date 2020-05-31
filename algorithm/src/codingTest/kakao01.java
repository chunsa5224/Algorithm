package codingTest;

public class kakao01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; 
		String hand ="left";
		String answer = "";
		int left=10;
		int right=12;
		
		for(int num : numbers) {
			if(num==0) {
				num =11;
			}
			if(num==1 || num == 4|| num ==7) {
				left = num;
				answer+="L";
			}else if(num==3 || num == 6|| num ==9) {
				right = num;
				answer+="R";
			}else{
				int rm = Math.abs(num+1-right)/3+1; 
				int lm = Math.abs(num-1-left)/3+1;
				
				if(left==2|| left ==5|| left ==8 || left==11){
					lm = Math.abs(num-left)/3;
				}
				if(right ==2 || right ==5 || right ==8 || right ==11) {
					rm = Math.abs(num-right)/3;
				}
				if(rm==lm) {
					if(hand.equals("right")) {
						right=num;
						answer+="R";
					}else {
						left = num;
						answer+="L";
					}
				}else if(lm<rm) {
					left = num;
					answer+="L";
				}else {
					right=num;
					answer+="R";
				}
			}
		}
		System.out.println(answer);

	}

}
