class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int[] alphabetsPresent = new int[26];
        int uniqueChars = 0;
        for(char c: arr ){
            if(alphabetsPresent[c - 'a'] == 0){
                alphabetsPresent[c - 'a']++;
                uniqueChars++;
            }
        }

        int res = 0;
        int[] curCharCount = new int[26];
        for(int w = 1; w<= uniqueChars; w++){
            int i = 0;
            int uniqueCharInCurrentWindow = 0;
            for(int j = 0; j < arr.length; j++){
                char c = arr[j];
                if(curCharCount[c - 'a'] == 0){
                    uniqueCharInCurrentWindow++;
                }curCharCount[c - 'a']++;
                while(uniqueCharInCurrentWindow > w){
                    curCharCount[arr[i] - 'a']--;
                    if(curCharCount[arr[i] - 'a'] == 0)
                        uniqueCharInCurrentWindow--;
                    i++;
                }

                if((uniqueCharInCurrentWindow == w) && (j - i + 1 >= w * k)){
                    res = Math.max(res, j -i + 1);
                }
            }
        }return res;
    }
}