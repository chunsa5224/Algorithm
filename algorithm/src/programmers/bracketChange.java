package programmers;

public class bracketChange {

	public static void main(String[] args) {
		System.out.println("answer : "+ solution("()))((()"));
	}
	public static String  solution(String p) {
		String answer ="";
		answer = change(p);
		
		return answer;
	}
	
	public static String change(String w) {
		if(w.equals("")) return "";
		if(check(w)) return w;
		
		String result ="";
		String [] arr = w.split("");
		int i =0;
		String u="";
		String v="";
		int open =0;
		int close=0;
		
		for(i=0; i<arr.length;i++) {
			if(arr[i].equals("(")) {
				open ++;
				u+=arr[i];
			}else {
				close++;
				u+=arr[i];
			}
			if(open==close) break;
		}
		for(i=i+1; i<arr.length; i++) {
			v += arr[i];
		}
		System.out.println("u : "+u);
		System.out.println("v : "+ v);
		// 올바른 괄호 체크 
		if(check(u)) {
			result += u;
			result += change(v);
		}else {
			result += "(";
			result +=change(v);
			result+=")";
			u=u.substring(1,u.length()-1);
			System.out.println("substring u : " + u);
			for(int c=0; c<u.length(); c++) {
				if(u.charAt(c)=='(') result+=")";
				else result+="(";
			}
//			result+=u;
		}
		System.out.println(result);
		return result;
	}
	static boolean check(String w) {
		int open =0;
		int close=0;
		boolean check=true;
		for(int i=0; i<w.length(); i++) {
			if(open<close) check=false;
			if(w.charAt(i)=='(') open++;
			else close++;
		}
		return check;
	}

}
