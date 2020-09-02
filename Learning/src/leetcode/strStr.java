package leetcode;

public class strStr {

  public static int strStr(String haystack, String needle) {

    if(needle.isEmpty())return 0;
    int needleLen = needle.length();
    int hayStackLen = haystack.length();
    int index =0;
    int starIndex = 0;
    for(int i=0;i<hayStackLen;i++)
    {
      if(index< needleLen && haystack.charAt(i) == needle.charAt(index))
      {
        if(starIndex>i)
          starIndex =i;
        index++;
      }else if(index<needleLen )
      {
        index =0;
        i =starIndex;
      }

      if(index==needleLen)
      {
        return i-index+1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    strStr("mississippi","issip");
  }

}
