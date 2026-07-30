package com.vaibhav.array;

public class SubArrays {

    public static void subArray(int arr[]) {

        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                int sumOfSubArray = 0;

                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sumOfSubArray += arr[k];
                }

                System.out.println("=> Sum = " + sumOfSubArray);

                // track maximum subarray sum
                if (sumOfSubArray > maximumSum) {
                    maximumSum = sumOfSubArray;
                }
            }
            System.out.println();
        }

        System.out.println("Maximum sum among all subarrays: " + maximumSum);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        subArray(arr);
    }
}
