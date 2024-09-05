package cordingTest.programmers;

import java.util.Arrays;

public class S0507 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            answer[i] = (long)x*(i+1);
        }
        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(solution(2, 5).toString());
//        System.out.println(solution(4, 3));
//        System.out.println(solution(-4, 2));
        int[] arr = {5, 9, 7, 9};
        int[] result = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sorted().toArray();
        System.out.println(result.toString());
        int[] arr2 = {};
        result = result.length != 0 ? result : new int[] {-1};
        System.out.println("e");
    }

}
