package com.my.test;

/**
 * Created by Chengfei.Sun on 17/04/26.
 */
public class Sort {
    public static void bubbleSort(int[] arr) {
        int i, j, temp, len = arr.length;
        for (i = 0; i < len - 1; i++)
            for (j = 0; j < len - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void insertion_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] <= arr[j])
                    break;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void selection_sort(int[] arr) {
        int i, j, min, temp, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            min = i;//未排序序列中最小数据数组下标
            for (j = i + 1; j < len; j++) {//在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min]; //将最小元素放到已排序序列的末尾
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 9, 1, 4, 2};
        //冒泡排序
        //Sort.bubbleSort(array);

        //快速排序
        quick_sort quick_sort = new quick_sort();
        quick_sort.sort(array);

        //插入排序
        //Sort.insertion_sort(array);

        //选择排序
        //Sort.selection_sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

class quick_sort {
    int[] arr;

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(left, right);
        }
        if (arr[left] >= arr[end])
            swap(left, end);
        else
            left++;
        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }

    public void sort(int[] arrin) {
        arr = arrin;
        quick_sort_recursive(0, arr.length - 1);
    }
}
