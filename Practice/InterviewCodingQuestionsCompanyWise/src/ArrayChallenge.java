public class ArrayChallenge {

    // Function to determine if any two numbers can be multiplied to exceed double the sum of the array
    public static String ArrayChallenge(int[] arr) {
        // Calculate the sum of the array
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Calculate double the sum
        int doubleSum = 2 * sum;

        // Check for any two numbers whose product is greater than double the sum
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] > doubleSum) {
                    return "true";
                }
            }
        }

        return "false";
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] testInputs = {
                {2, 2, 2, 2, 4, 1},
                {1, 1, 2, 10, 3, 1, 12},
                {2, 5, 6, -6, 16, 2, 3, 6, 5, 3},
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0}
        };

        for (int[] input : testInputs) {
            System.out.println("Input: " + java.util.Arrays.toString(input) + " Output: " + ArrayChallenge(input));
        }
    }
}
