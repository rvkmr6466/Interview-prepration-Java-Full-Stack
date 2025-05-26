package augury;

public class FindMaxWaterContained {
    public static void main(String[] args) {
        System.out.println("naiveApproach:: "+naiveApproach(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println("naiveApproach:: "+naiveApproach(new int[]{2, 1, 8, 6, 4, 6, 5, 5})); // 25
        System.out.println("naiveApproach:: "+naiveApproach(new int[]{1, 5, 4, 3})); // 6

        System.out.println("optimizeApproach:: "+optimizeApproach(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println("optimizeApproach:: "+optimizeApproach(new int[]{2, 1, 8, 6, 4, 6, 5, 5})); // 25
        System.out.println("optimizeApproach:: "+optimizeApproach(new int[]{1, 5, 4, 3})); // 6
    }

    public static int naiveApproach(int[] height) {
        int area=0;
        int n = height.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n; j++) {
                int tempArea = Math.min(height[i], height[j])*(j-i);
                area = Math.max(tempArea, area);
            }
        }

        return area;
    }

    public static int optimizeApproach(int[] height) {
        int area=0;
        int left=0, right=height.length-1;
        while(left < right){ // 0 < 8
            int tempArea = 0;
            int len = Math.min(height[left], height[right]);
            tempArea = len*(right-left);
            area = Math.max(tempArea, area);

            /*
            The `if-else` part in the code is used to decide which pointer (`left` or `right`) to move towards the center.

            Here's a simple explanation:
            1. Compare heights: Compare the heights of the two lines at the current `left` and `right` positions.
            2. Move the shorter line: Move the pointer of the shorter line towards the center.

            Why move the shorter line?
            * If you move the taller line, the area of the rectangle will not increase, because the height of the
              rectangle is determined by the shorter line.
            * By moving the shorter line, you might find a taller line that can increase the area of the rectangle.

            Code explanation
            * `if (height[left] < height[right])`: If the left line is shorter, move the `left` pointer to the right (`left++`).
            * `else`: If the right line is shorter (or equal), move the `right` pointer to the left (`right--`).

            By moving the shorter line, you're effectively trying to find a taller line that can increase the area of the rectangle.
            */
            if(height[left]<height[right]) //
                left++;
            else
                right--;
        }
        return area;
    }
}
