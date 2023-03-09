package lesson4;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        String[] s1 = new String[5];
        s1[0] = "a";

        String[] s2 = new String[]{"a", "b", "c"};
        String[] s3 = {"a", "b", "c"};

//        sort();
//        passByReference();
//        passByValue();
        dim2();
    }

    private static void sort() {
        int[] arr = {9, 5, 2, 7};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        System.out.println(Arrays.binarySearch(arr, 5));
        System.out.println(Arrays.binarySearch(arr, 45)); // 找不到回傳陣列長度加 1 * -1
    }

    private static void passByReference() {
        int[] arr = {9, 5, 2, 7};
        int[] arr2 = arr;
        arr[0] = 999;
        System.out.println(arr2[0]);
    }

    private static void passByValue() {
        int[] arr = {9, 5, 2, 7};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        arr[0] = 999;
        System.out.println(arr2[0]);
    }

    private static void dim2() {
//        int[][] arr = new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        int[][] arr2 = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        System.out.println(arr2.length);
        System.out.println(arr2[0].length);
        System.out.println(arr2[1].length);
        System.out.println(arr2[2].length);
        System.out.println();

        // 方法一
        for (var i = 0; i < arr2.length; i++) {
            for (var j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 方法二
        for (var i : arr2) {
            for (var j : i) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 方法三
        Arrays.stream(arr2).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
