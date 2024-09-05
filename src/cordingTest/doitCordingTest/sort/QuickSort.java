package cordingTest.doitCordingTest.sort;

import java.util.*;

/**
 * @see <a href="https://st-lab.tistory.com/250">퀵 소트 설명</a>
 */

public class QuickSort {
    public static void main(String[] args) {
        // 1 20 20 29 30 40 50 70 86
//        int[] a = new int[] {1,50,20,30,86,29,40,70,20};
//        int[] a = new int[] {1,5,2,10,-9,7,5};
        int[] a = new int[] {1,4,2,5,3};
        int n = a.length;
//        System.out.println(pivotSelection(a));
        sort(a, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }

    static void sort(int[] a, int start, int end) {
        // start가 end보다 크면 부분 배열의 크기가 1이므로 정렬하지 않는다.
        if (start >= end) {
            return;
        }

        int part = mid_partition(a, start, end);
        // 왼쪽 영역
        if (start < part - 1) {
            sort(a, start, part - 1);
        }
        // 오른쪽 영역
        if (end > part) {
            sort(a, part, end);
//            sort(a, part + 1, end); // 우측 피봇일 경우 end값이므로 start값에 + 1이 필요하다.
        }
    }

    /**
     * 피봇이 중간 값일 때
     */
    static int mid_partition(int a[], int start, int end){
        // pivot 값 정하기.
        int m = (start + end)/2;
        int pivot = a[m]; // 해당 파티션의 중간에 있는 값

        // end가 start보다 클 때만 반복함.
        while (start <= end) {
            // 해당 pivot값보다 크면 start 포인터를 오른쪽으로 움직여준다.
            while (a[start] < pivot) {
                start++;
            }

            // pivot보다 작으면 end 포인터를 왼쪽으로 움직여준다.
            while (a[end] > pivot) {
                end--;
            }

            // 교횐될 두 요소를 찾았다면 swap 진행한다.
            if (start<=end) {
                swap(a, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    /**
     * 피봇이 가장 우측일 때
     */
    static int right_partition(int a[], int start, int end){
        // pivot 값 정하기.
        // 해당 범위의 가장 오른쪽으로 설정
        int pivot = a[end];
        int pivot_index = end;

        // end가 start보다 클 때만 반복함.
        while (start < end) {
            // 해당 pivot값보다 크면 start 포인터를 오른쪽으로 움직여준다.

            // TODO 왜 뒤에 조건을 붙여줘야될까?
            while (a[start] < pivot && start < end) {
                start++;
            }

            // pivot보다 작으면 end 포인터를 왼쪽으로 움직여준다.
            while (a[end] >= pivot && start < end) {
                end--;
            }

            // 찾은 값들을 swap 해준다.
            // 이렇게되면 왼쪽에는 pivot보다 작은 값, 오른쪽에는 pivot보다 큰 값이 있게 된다.
            swap(a, start ,end);
        }

        // pivot 자리를 지정해준다.
        // end 값과 피봇 값을 swap
        // end값은 피봇의 오른쪽에 있어야하므로 해당 값과 swap 해주는 것이다.
        swap(a, pivot_index, end);

        return end;
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 중간 값 구하기 알고리즘
     */
    static int pivotSelection(int[] a) {
        // 이 아이디어는, 최대힙, 최소힙이 필요하다.

        // 최대 값이 root
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 최소 값이 root
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 항상 최대힙과 최소힙에 들어있는 크기를 맞추기 위해 같지 않는 경우는 최대힙이 항상 크므로 최소힙에 값을 넣어준다..?
        // => 최대힙, 최소힙, 최대힙 번갈아가면서 넣어주므로 같지 않을 경우는 최소힙에 넣을 차례인 것
        // 같을 경우는 최대힙에 값을 넣을 차례이다.

        // 최대힙 peek() < 최소힙의 peek()가 성립해야한다. !!!!

        // 최소힙의 peek()보다 최대힙의 peek()가 클 경우 swap해준다.

        // 짝수인 경우 최소힙, 홀수인 경우 최대힙에다 넣어준다.

        // TODO 최소힙과 최대힙이 뜻하는게 무엇인지 정확하게 알아야한다.
        for (int i=0; i<a.length; i++) {
            if (i%2==0) {
                maxHeap.add(a[i]);
            } else {
                minHeap.add(a[i]);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int swap_min = minHeap.poll();
                    int swap_max = maxHeap.poll();
                    maxHeap.add(swap_min);
                    minHeap.add(swap_max);
                }
            }

            System.out.println("maxHeap: "+ maxHeap.peek());
        }

        return maxHeap.poll();
    }
}
