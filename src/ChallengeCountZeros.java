import java.util.InputMismatchException;
import java.util.Scanner;

public class ChallengeCountZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer to convert to binary:");
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                String input = sc.next();
                System.out.printf("Could not parse \"%s\".\nPlease enter a number between %d and %d:\n",
                        input,
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE);
            }
        }
        String binary = Integer.toBinaryString(number);
        System.out.printf("%d in binary is:\n", number);
        System.out.println(binary);
        int maxCount = countWithForLoop(binary);
//        int maxCount = countWithIndexOf(binary);
        System.out.printf("Most continuous zeros between ones are: %d\n", maxCount);
    }

    private static int countWithIndexOf(String input) {
        int maxCount = 0;
        int lastIndex = input.indexOf('1');
        int index;
        while (true) {
            index = input.indexOf('1', lastIndex + 1);
            if (index < 0) break; // Stop if nothing is found
            int count = index - lastIndex - 1;
            if (count > maxCount) {
                maxCount = count;
            }
            lastIndex = index;
        }
        return maxCount;
    }

    private static int countWithForLoop(String input) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '0':
                    count++;
                    break;
                case '1':
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                    break;
            }
        }
        return maxCount;
    }
}