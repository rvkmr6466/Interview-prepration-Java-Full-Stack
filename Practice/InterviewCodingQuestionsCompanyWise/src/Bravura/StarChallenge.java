package Bravura;

public class StarChallenge {
    public static String StringChallenge(String str) {
        // code goes here
        double rating;

        // Validate input
        try {
            rating = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return "Invalid input"; // Handle invalid input
        }

        int fullStars = (int) Math.floor(rating);
        double remaining = rating - fullStars;
        int halfStars = 0;

        if (remaining >= 0.25 && remaining < 0.75) {
            halfStars = 1;
        } else if (remaining >= 0.75) {
            fullStars++;
        }

        // Corrected variable name
        int emptyStars = 5 - fullStars - halfStars;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < fullStars; i++) {
            result.append("full ");
        }

        for (int i = 0; i < halfStars; i++) {
            result.append("half ");
        }

        for (int i = 0; i < emptyStars; i++) {
            result.append("empty ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String testInput = "0.5"; // Change this value to test different inputs
        System.out.print(StringChallenge(testInput));
    }
}
