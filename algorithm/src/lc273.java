

public class lc273 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer =isInterleave("abcd", "xyz","xabyczd");
		System.out.println(answer);
		
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    System.out.println("i : " + i + ", j : " +j + ", dp["+j+"] : " + dp[j]);
                    
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    System.out.println("i : " + i + ", j : " +j + ", dp["+j+"] : " + dp[j]);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    System.out.println("i : " + i + ", j : " +j + ", dp["+j+"] : " + dp[j]);
                    if(dp[j]==true) System.out.println(s3.charAt(i+j-1));
                }
            }
        }
        return dp[s2.length()];
    }

}
