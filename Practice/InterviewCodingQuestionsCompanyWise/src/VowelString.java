import java.util.Arrays;

public class VowelString {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        String vowels = "aeiou";
        int n = words.length;
        int[] prefix = new int[n];

        // Preprocess words to build prefix sum array
        for (int i = 0; i < n; i++) {
            char startChar = words[i].charAt(0);
            char endChar = words[i].charAt(words[i].length() - 1);
            int valid = (vowels.indexOf(startChar) != -1 && vowels.indexOf(endChar) != -1) ? 1 : 0;
            prefix[i] = valid + (i > 0 ? prefix[i - 1] : 0);
        }

        System.out.println(Arrays.toString(prefix));

        int q = queries.length;
        int[] output = new int[q];

        // Process each query using prefix sums in O(1)
        for (int j = 0; j < q; j++) {
            int start = queries[j][0];
            int end = queries[j][1];

            if (start == 0) {
                output[j] = prefix[end];
            } else {
                output[j] = prefix[end] - prefix[start - 1];
            }
        }
        return output;
    }

    // Example usage
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1,1}};
        int[] counts = vowelStrings(words, queries);
//        for (int count : counts) {
            System.out.println(Arrays.toString(counts));
//        }
    }
}
