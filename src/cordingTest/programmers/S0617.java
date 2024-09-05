package cordingTest.programmers;


import java.util.ArrayList;
import java.util.List;

public class S0617 {
    public static int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] result = new int[3];

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (s1[i % s1.length] == answers[i]) {
                result[0]++;
            }
            if (s2[i % s2.length] == answers[i]) {
                result[1]++;
            }
            if (s3[i % s3.length] == answers[i]) {
                result[2]++;
            }
        }

        int max = 0;

        for (int i = 0; i < result.length; i++) {
            if (max == result[i]) {
                answer.add(i+1);
            }else if (max < result[i]) {
                max = result[i];
                answer.clear();
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}));
        System.out.println(solution(new int[] {1, 3, 2, 4, 2}));
    }
}
