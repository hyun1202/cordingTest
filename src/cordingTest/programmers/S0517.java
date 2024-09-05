package cordingTest.programmers;

public class S0517 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for (int i=0; i<absolutes.length; i++) {
            if (signs[i] == false) {
                absolutes[i] *= -1;
            }
            result += absolutes[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int result = solution(new int[]{4, 7, 12}, new boolean[] {true, false, true});
        System.out.println(result);
    }
}
