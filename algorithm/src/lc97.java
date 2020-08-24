

public class lc97 {
	public static void main(String args []) {
    	String A = "axb";
    	String B = "xyz";
    	String C = "axyxzb";
    	
    	boolean answer = is_Interleave(A,0,B,0,"",C);
    	System.out.println(answer);
    }
	
	public static boolean is_Interleave(String A,int i,String B,int j,String res,String C)
    {
        if(res.equals(C) && i==A.length() && j==B.length()) {
        	return true;
        }
        boolean ans=false;
        
        if(i<A.length()) {
        	System.out.println("A : " +i + " res : " + res);
        	ans|=is_Interleave(A,i+1,B,j,res+A.charAt(i),C);
        }
        if(j<B.length()) {
        	System.out.println("B : " + j+ " res : " + res);
        	
        	ans|=is_Interleave(A,i,B,j+1,res+B.charAt(j),C);
        }
        return ans;

    }
}
