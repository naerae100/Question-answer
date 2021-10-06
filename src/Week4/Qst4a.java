package Week4;

import java.util.Arrays;

public class Qst4a {
    public Qst4a() {
    }

    public static void main(String[] args) {
        int[][] cordinates = new int[][]{{2, 3}, {5, 8}, {3, 4}, {5, 7}, {3, 4}};
        int[] target = new int[]{3, 4};
        closestThreeCordinates(cordinates, target);
    }

    public static void closestThreeCordinates(int[][] arr, int[] target) {
        Double[] res = new Double[arr.length];
        int greatest = 0;

        int first;
        for(first = 0; first < arr.length; ++first) {
            Double rawDistance = Math.pow((double)(arr[first][0] - target[0]), 2.0D) + Math.pow((double)(arr[first][1] - target[1]), 2.0D);
            Double distance = Math.sqrt(rawDistance);
            res[first] = distance;
            if (res[greatest] < res[first]) {
                greatest = first;
            }
        }

        first = greatest;
        int second = greatest;
        int third = greatest;

        for(int i = 0; i < res.length; ++i) {
            if (res[i] <= res[first]) {
                third = second;
                second = first;
                first = i;
            } else if (res[i] <= res[second]) {
                third = second;
                second = i;
            } else if (res[i] <= res[third]) {
                third = i;
            }
        }

        System.out.println("First = " + Arrays.toString(arr[first]));
        System.out.println("Second = " + Arrays.toString(arr[second]));
        System.out.println("third = " + Arrays.toString(arr[third]));
    }
}
