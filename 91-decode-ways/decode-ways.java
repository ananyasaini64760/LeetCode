class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return helper(s, 0, cache);
    }
    int helper(String s, int i, int[] cache){
        
        if(i == s.length()){
            return 1;
        }
        
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(cache[i] != -1){
            return cache[i];
        }
        int count = 0;
        count = count + helper(s, i+1, cache);

        if(i + 1 < s.length()){
            int twoDigit = Integer.parseInt(s.substring(i, i+2));
            if(twoDigit >= 10 && twoDigit <= 26){
                count = count + helper(s, i+2, cache);
            }
        }
        cache[i] = count;
        return count;
    }
}