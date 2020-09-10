package programmers;


public class compressString {

	public static void main(String[] args) {
		String s="abcabcabcabcdededededede";
		System.out.println(solution(s));
	}
	public static int solution(String s){
		int answer = s.length();
		int len = s.length();
		String [] arr = s.split("");
		
		for(int i=1; i<=len ; i++) {
			answer = Math.min(compress(arr,i), answer);
		}
		return answer;
	}
	private static int compress(String[] arr, int cnt) {
		String prev="";
		String now ="";
		String result="";
		String add ="";
		int temp=0;
		int same=1;
		if(cnt>arr.length/2) {
			return arr.length;
		}
		for(int i=0; i<cnt; i++) {
			prev += arr[i];
		}
		add=prev;
		for(int i=cnt; i<arr.length;i++) {
			while(temp!=cnt) {
				if(i==arr.length) {
					result += (add + now);
					return result.length();
				}
				now += arr[i];
				i++;
				temp++;
			}
			i--;
			if(prev.equals(now)){
				same++;
				add = same+prev;
			}else {
				result += add;
				prev=now;
				add=prev;
				same=1;
			}
			if(i==arr.length-1) {
				result+=add;
			}
			temp=0;
			now="";
		}
		
		
		
		return result.length();
	}

}
