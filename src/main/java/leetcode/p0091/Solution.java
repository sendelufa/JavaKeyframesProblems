package leetcode.p0091;

class Solution {
    public int numDecodings(String s) {
        var n = s.length();
        var ar = new int[n+1];
        ar[n] = 1;
        ar[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) != '0')
                ar[i] += ar[i + 1];
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))
                ar[i] += ar[i + 2];
        }
        return ar[0];
    }
}