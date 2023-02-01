import java.util.Arrays;

public class ChallengeRotateArray {
    public static void main(String[] args) {
        int[] arr = {17, 3, 5, 8, 12};
        int[] result = rotate(arr, 2);
        System.out.printf("%s -> %s", Arrays.toString(arr), Arrays.toString(result));
    }

    private static int[] rotate(int[] arr, int k) {
        k = k % arr.length;
        int[] result = new int[arr.length];
        for (int i = arr.length - k, j = 0; j < arr.length; j++, i++) {
            if (i >= arr.length) i = 0;
            result[j] = arr[i];
        }
        return result;
    }
}
