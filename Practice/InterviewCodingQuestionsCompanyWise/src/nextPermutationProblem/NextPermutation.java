package nextPermutationProblem;

public class NextPermutation {
    private static final String ChallengeToken = "ovmhks10";

    // Function to find the next permutation of the digits of the number
    public static int MathChallenge(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        // Find the longest non-increasing suffix
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        // If the digits are in descending order, no larger number is possible
        if (i < 0) {
            return -1;
        }

        // Find the rightmost successor to digits[i] in the suffix
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        // Swap the pivot with the successor
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Reverse the suffix
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
        int nextNum = MathChallenge(num);
        if (nextNum == -1) {
            // if no next permutation, just combine "-1" with the reversed token
            return "-1:" + new StringBuilder(ChallengeToken).reverse().toString();
        } else {
            String nextNumStr = String.valueOf(nextNum);
            String reversedNum = new StringBuilder(nextNumStr).reverse().toString();
            String reversedToken = new StringBuilder(ChallengeToken).reverse().toString();
            return reversedNum + ":" + reversedToken;
        }
    }

    // Main for quick testing
    public static void main(String[] args) {
        int[] testInputs = {11121, 41352, 123, 12453, 999};
        for (int input : testInputs) {
            int nextNum = MathChallenge(input);
            System.out.println("Input: " + input + " Output: " + nextNum);
            System.out.println("Final Output: " + finalOutput(input));
            System.out.println();
        }
    }
}
