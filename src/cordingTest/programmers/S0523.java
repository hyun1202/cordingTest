package cordingTest.programmers;

public class S0523 {
    public static int solution(int left, int right) {
        int result = 0;
        for (int n=left; n<=right; n++) {
            int count = 0;
            for (int i=1; i*i <= n; i++) {
                if (i*i==n){
                    count++;
                }else if (n%i==0){
                    count+=2;
                }
            }
            result += (count & 1) == 0 ? n : n * -1;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }
}
