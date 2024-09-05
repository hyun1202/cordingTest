package cordingTest.programmers;


public class S0614 {
    public static String solution(int a, int b) {
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] start = {31,29,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for (int i=0; i<a-1; i++) {
            sum += start[i];
        }
        return week[(sum + b - 1) % 7];
    }


    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }
}
