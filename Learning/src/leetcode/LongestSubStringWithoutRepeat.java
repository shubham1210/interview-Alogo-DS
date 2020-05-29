package leetcode;

import java.util.HashSet;

public class LongestSubStringWithoutRepeat {

        //slow O(n2)
        public int lengthOfLongestSubstringSlow(String s) {
            int longestLength = 0;

            HashSet<Character> set =  new HashSet<Character>();
            char[] arr = s.toCharArray();

            for(int i=0;i< arr.length;i++){
                for(int j=i;j< arr.length;j++){
                    if(set.contains(arr[j])){
                        int size = set.size();
                        if(longestLength<set.size())
                            longestLength = size;

                        set.clear();
                        break;

                    }else{
                        set.add(arr[j]);
                    }
                }
            }
            longestLength =  longestLength<set.size()?set.size():longestLength;
            return longestLength;
        }

        //fast  O(n)
        public int lengthOfLongestSubstring(String s) {

            int n = s.length();
            int i=0,j=0;
            HashSet<Character> set =  new HashSet<Character>();
            int longestLength =0;
            while(i<n && j< n)
            {
                if(set.contains(s.charAt(j)))
                {
                    set.remove(s.charAt(i));// we need to remove the first char and move to next element.
                    i++; // just moving to next element from the staring.

                }else{
                    set.add(s.charAt(j));
                    j++;
                    longestLength = Math.max(longestLength, j-i); // as j and i are moving and i is pointing to the the first char from where char are not repeating
                }
            }
            return longestLength;
        }


    public static void main(String[] args) {
        LongestSubStringWithoutRepeat withoutRepeat = new LongestSubStringWithoutRepeat();
        System.out.println(withoutRepeat.lengthOfLongestSubstring("pwwkew")); ;
    }

}
