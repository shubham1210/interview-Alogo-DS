package leetcode;

/**
 * Created by shubhamsharma on 2020-06-01.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int alen = nums1.length;
        int blen =nums2.length;

        int i=0; int j=0; int k=0;
        int []merged = new int[alen+blen];
        while(i< alen && j< blen)
        {
            if(nums1[i]<nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }

        while(i< alen){
            merged[k++] = nums1[i++];
        }

        while(j< blen){
            merged[k++] = nums2[j++];
        }
        double ans =0;
        int count = merged.length;
        int countdiv = count/2;
        if(count%2==0)
        {
            ans = (merged[countdiv]+merged[countdiv-1])/2;
        }else{

            ans = merged[countdiv];
        }

        return ans;
    }

    public double findMedianSortedArraysFast(int[] nums1, int[] nums2) {
        int alen = nums1.length;
        int blen =nums2.length;
        int i=0; int j=0;
        int mergedlen = alen+blen;
        int outerCounter = 0;
        int m1 =-1; int m2=-1;// it can be initialize with any number;
        if(mergedlen%2==1){ // we need to check over length if odd them mid element else mid + mid-1
            while(outerCounter <=mergedlen/2) // we need to go till mid of the array
            {
                if(i!=alen && j!=blen)
                {
                    m1 = nums1[i]<nums2[j] ? nums1[i++] :  nums2[j++]; // we dont need to keep the whole array as we only concerned about the 2 elements
                }
                else if(i<alen) {
                    m1 = nums1[i++] ;

                } else if(j<blen){
                    m1 = nums2[j++] ;
                }
                outerCounter++;
            }

            return m1;
        }else{
            while(outerCounter <=mergedlen/2)
            {
                m2=m1;// we dont need to keep the whole array as we only concerned about the 2 elements and we are replacing it everytime when we cover one loop or that means we found small element now look for bigger than that
                if(i!=alen && j!=blen)
                {
                    m1 = nums1[i]<nums2[j] ? nums1[i++] :  nums2[j++];
                }
                else if(i<alen) {
                    m1 = nums1[i++] ;

                } else if(j<blen){
                    m1 = nums2[j++] ;
                }
                outerCounter++;
            }

            return (double)(m1+m2)/2;
        }

    }

    public static void main(String[] args) {
        int arr [] = {1,2};
        int arr2[] = {3,4};

        MedianTwoSortedArray array = new MedianTwoSortedArray();
        System.out.println(array.findMedianSortedArrays(arr,arr2));

    }
}
