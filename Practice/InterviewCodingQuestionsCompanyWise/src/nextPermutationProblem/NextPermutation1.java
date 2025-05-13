package nextPermutationProblem;

public class NextPermutation1 {

    private static final String ChallengeToken = "ovmhks10";

    // Function to find the next permutation of the digits of the number
    public static int findNextPermutation(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        // Step 1: Find the longest non-increasing suffix
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such index exists, the number is the highest permutation
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the rightmost successor to the pivot
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the pivot with the successor
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the suffix
        int start = i + 1, end = digits.length - 1;
        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }

        return Integer.parseInt(new String(digits));
    }

    // Function to generate the final output string as described
    public static String finalOutput(int num) {
        int nextNum = findNextPermutation(num);
        if (nextNum == -1) {
            return "-1:" + new StringBuilder(ChallengeToken).reverse().toString();
        } else {
            String nextNumStr = String.valueOf(nextNum);
            String reversedNum = new StringBuilder(nextNumStr).reverse().toString();
            String reversedToken = new StringBuilder(ChallengeToken).reverse().toString();
            return reversedNum + ":" + reversedToken;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] testInputs = {11121, 41352, 123, 12453, 999};
        for (int input : testInputs) {
            System.out.println("Input: " + input + " Output: " + findNextPermutation(input));
            System.out.println("Final Output: " + finalOutput(input));
            System.out.println();
        }
    }
}