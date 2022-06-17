package OnBoard;

public class OnBoardweekTwo {

    private static double findMedian(int [] nums1, int[] nums2) {

       // int[] nums1 = {1,2};
        //int[] nums2 = {3,4};
       // int start = 0;
       // int end = m;
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        // if (nums1.length > nums2.length){
       //      return findMedian(nums2, nums1);
       //  }
        while (start <= end){
            // divide both array
            int medianNums1 = (start + end)/2 ;
            int medianNums2 = (m + n + 1) /2 - medianNums1;
           // check left elements

            int leftNums1 = medianNums1 ==0 ? Integer.MIN_VALUE :nums1[medianNums1- 1];
            int  minleftNums1 = medianNums1 == m ? Integer.MAX_VALUE:nums1[medianNums1];

            //Do the same for
            int leftNums2 = medianNums2 ==0 ? Integer.MIN_VALUE :nums2[medianNums2- 1];
            int  minleftNums2 = medianNums2 == n ? Integer.MAX_VALUE:nums2[medianNums2];


            // check the match
            if (leftNums1 <=minleftNums2 && leftNums2 <=minleftNums1  ) {
                // check of the combined is even/odd length

            if ((m + n) % 2 ==0 ) {
                return (Math.max(leftNums1, leftNums2) + Math.min(minleftNums1, minleftNums2)) / 2.0;
            } else {
                return Math.max(leftNums1, leftNums2);
            }
            }
            // If we are too far on the right, we need to go to left side
            else if (leftNums1 > minleftNums2) {
                end = medianNums1 - 1;
            }
            // If we are too far on the left, we need to go to right side
            else {
                start = medianNums2 + 1;
            }
        }
        // If we reach here, it means the arrays are not sorted
        throw new IllegalArgumentException();
    }

            public static void main(String[] args){
                int[] nums1 = new int[]{1, 3};
                int[] nums2 = new int[]{2};
                System.out.println(findMedian(nums1, nums2));
            }
        }