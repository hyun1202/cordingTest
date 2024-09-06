package cordingTest.doitCordingTest.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[] {1,50,20,30,86,29,40,70,20};
//        int[] a = new int[] {1,5,2,10,-9,7,5};
//        int[] a = new int[] {1,4,2,5,3};

        int n = a.length;

        mergeSort(a, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }

    static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);

        merge(a, start, mid, end);
    }

    static void merge(int[] a, int start, int mid, int end) {
        // temp 배열, 합쳐진 배열의 크기와 같으므로 end-start+1이다.
        int[] temp = new int[end-start+1];
        int idx = 0;

        int left = start;
        int right = mid+1;

        // left나 right 중 어느 index라도 리스트의 모든 값을 꺼내게 되면 종료한다.
        while (left <= mid && right <= end) {
            if (a[left] < a[right]) {
                temp[idx++] = a[left++];
            } else {
                temp[idx++] = a[right++];
            }
        }

        // 남아 있는 데이터 정리
        while (left <= mid) {
            temp[idx++] = a[left++];
        }

        while (right <= end) {
            temp[idx++] = a[right++];
        }

        for (int i=start; i<=end; i++) {
            a[i] = temp[i-start];
        }
    }
}
