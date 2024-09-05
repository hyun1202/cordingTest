package cordingTest.programmers;

public class S0520 {
    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length-1];
        int index = 0;
        int min = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        int tmp = 0;
        for (int i=0; i<arr.length; i++) {
            if (index == i) {
                tmp++;
                continue;
            }
            result[i-tmp] = arr[i];
        }
        return result.length > 0? result : new int[] {-1};
    }

    public static void main(String[] args) {
        int[] result = solution(new int[] {4,3,2,1});
        System.out.println(result);
    }
}
