package recursion;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int idx = search(arr, 0, arr.length - 1, 7);
        System.out.println(idx);

        idx = search(arr, 0, arr.length - 1, 11);
        System.out.println(idx);
    }

    public static int search(int[] arr, int lt, int rt, int val) {

        if (lt > rt) {
            return -1;
        }

        int mid = lt + (rt - lt) / 2;

        if (arr[mid] > val) {
            return search(arr, lt, mid - 1, val);
        } else if (arr[mid] < val) {
            return search(arr, mid + 1, rt, val);
        } else {
            return mid;
        }

    }

}
