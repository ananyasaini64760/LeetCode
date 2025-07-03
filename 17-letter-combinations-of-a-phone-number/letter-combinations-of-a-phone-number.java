class Solution {

    public List<String> letterCombinations(String digits){
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        else{
            return helper(digits);
        }
    }

    public List<String> helper(String digits) {
        if(digits.length() == 0){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> newList = new ArrayList<>();
        char firstDigit = digits.charAt(0); // eg. 2
        int index = firstDigit - '0';
        String s = key[index];  // eg. abc
         
        for(int i = 0; i < s.length(); i++){
            List<String> oldList = helper(digits.substring(1));
            for(int j = 0; j < oldList.size(); j++){
                newList.add(s.charAt(i) + oldList.get(j));
            }
        }
        return newList;
    }
}