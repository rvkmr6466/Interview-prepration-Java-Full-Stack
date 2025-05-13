import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
        Print numbers from 1 to N using a while loop
        prime1ToN(n);
        */

        /*
        Print even numbers from 1 to N
        evenNumber(n);
         */

        /*
        Print the sum of numbers from 1 to N
        sumOfNumber(n);
         */

        /*
        Print the digits of a number in reverse order
        digitInReverseOrder(n);
         */

        /*
        Count the number of digits in an integer
        countOfNoOfInteger(n);
         */

        /*
        Check if a number is a palindrome
        checkPalindromeNumber(n);

        Check if a string is a palindrome
        checkPalindromeString
         */

        /*
        Find the factorial of a number using while loop
        System.out.println(factorial(int n));
         */

        /*
        Check if a number is prime
        isPrime(n);
         */

        /*
        Print the Fibonacci series up to N terms
        fibonacci(n);
         */

        /*
        Sum of digits of a number
        sumOfDigits(n);
         */

        /*
        Check if a number is an Armstrong number
        isNumberArmstrong(n);
         */

        /*
        Find the Greatest Common Divisor (GCD) of two numbers
        checkGCD(n);
         */

//        checkGCD(); TODO: complete it

        /*
        Print a multiplication table for a number
        tableOfANumber(n);
         */

        /*
        Count the number of vowels in a string
        checkNoOfVowels("alphabetiu");
         */

        /*
        Convert a binary number to decimal
        binaryToDecimal(n);
         */

        /*
        Convert a decimal number to binary
        decimalToBinary(n);
         */

        /*
        Iterate hashmap with different approach
        iterateHashMap();
         */
    }

    public static void prime1ToN(int n) {
        int i = 0;
        while(i<n) {
            System.out.println(i);
            i++;
        }
    }

    public static void evenNumber(int n) {
        int i = 0;
        while(i<n) {
            if (i%2==0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void sumOfNumber(int n) {
        int sum = 0, i = 0;
        while (i<=n) {
            sum+=i;
            i++;
        }
        System.out.println(sum);
    }

    public static void digitInReverseOrder(int n) {
        int reverse = 0;
        while (n>0) { // 122 -> 221
            reverse = reverse * 10 + n%10;
            n/=10;
        }
        System.out.println(reverse);
    }

    public static void countOfNoOfInteger(int n) {
        int count = 0;
        while (n>0) {
            count += n%10;
            n/=10;
        }
        System.out.println(count);
    } // TODO: check once

    public static void checkPalindromeNumber(int n) {
        int reverse = 0;
        while (n>0) {
            reverse = reverse*10+n%10;
            n/=10;
        }
        System.out.println(n==reverse);
    }

    public static void checkPalindromeString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // abcba -> 10
        char[] c = str.toCharArray(); //[a,b,c,b,a]
        int len = c.length; // -> 5
        int i = 0;
        boolean isPalindrome = false;

        while (i < len/2) { // 5/2=2
            if (c[i] == c[len-i-1]) { // c[0]==c[4]
                isPalindrome = true;
            } else {
                isPalindrome = false;
            }
            i++;
        }
        System.out.println(isPalindrome);
    }

    public static int factorial(int n) {
        if (n==0 || n==1) {
            return 1;
        }
        while(n>=0) {
            return n*factorial(n-1);
        }
        return 1;
    }

    public static void isPrime(int n) {
        int i = 1, count=0;

        while (i<=n) {
            if (n%i==0) {
                count++;
            }
            i++;
        }
        if(count > 3) System.out.println("Not A Prime Number");
        else System.out.println("Prime Number");
    }

    public static void fibonacci(int n) { // 5
        int a=0;
        int b=1;
        int c = 0, i = 2;
        // 0 1 1 2 3 5 8 ....
        System.out.print(a + " ");
        System.out.print(b + " ");
        while (i < n) {
            c=a+b;
            System.out.print(c + " ");
            a=b;
            b=c;
            i++;
        }
    }

    public static void sumOfDigits(int n) {
        int count = 0;
        while (n>0) {
            count += n%10;
            n/=10;
        }
        System.out.println(count);
    }

    public static void isNumberArmstrong(int n) {
         int num = 0;
         int n1 = n;

        //   e.g.= 1^3 + 5^3 + 3^3 = 153.

         while (n>0) {
             int temp= n%10;
             num+= temp*temp*temp;
             n/=10;
         }

         if(n1==num) System.out.println("Number is Armstrong!");
         else System.out.println("Number is not a Armstrong!");
    }

    public static void checkGCD() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

    }

    public static void tableOfANumber(int n) {
        int i = 1;
        while (i<=10) {
            System.out.println(n + " * " + i + " = " + n*i);
            i++;
        }
    }

    public static void checkNoOfVowels(String str) {
        String vowels = "aeiouAEIOU";
        int i = 0, count = 0;

        while(i < str.length()){
            if (vowels.indexOf(str.charAt(i))!= -1) {
                count++;
            }
            i++;
        }
        System.out.println(count);
    }

    public static void binaryToDecimal(int n) {
        int num = 0, i = 0;
        while(n>0){
            num+=Math.pow(2, i)*(n%10);
            n/=10;
            i++;
        }
        System.out.println(num);
    }

    public static void decimalToBinary(int n){
        // 11-> 1011 -> 11/2->1 => 5/2->1 => 2/2->0
        int binary = 0, place = 1;
        while(n>0) {
            int rem=n%2;
            binary+=rem*place;
            place*=10;
            n/=2;
        }
        System.out.println(binary);
    }

    public static void iterateHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println("Iterate Hashmap using forEach");
        map.forEach((key, value)-> {
            System.out.println(key + " " + value);
        });

        System.out.println("Iterate Hashmap using for loop");
        for(Integer n: map.keySet()) {
            System.out.println(n + " " + map.get(n));
        }

        System.out.println("Iterate Hashmap using for loop with entry set");
        for (Map.Entry<Integer, String> m: map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        String n = map.getOrDefault(1, String.valueOf(0));
        System.out.println(n);
    }
}