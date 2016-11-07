package LectureCode;


public class InterleavingString {
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        //Initialize the first row and first column
        for(int i = 1; i <= s1.length(); i++) {
            if(dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = true;
        }
        for(int i = 1; i <= s2.length(); i++) {
            if(dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = true;
        }
        
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                int pos = i + j - 1;
                if(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(pos))
                    dp[i][j] = true;
                else if(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(pos))
                    dp[i][j] = true;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
