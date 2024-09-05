package cordingTest.doitCordingTest.slidingWindow;

public class SlidingWindowEx {
    /** [1, 3, 2, 6, -1, 4, 1, 8, 2] 에서
     * <b>연속적인 5개의 숫자의 합의 최대값</b>을 구하여라
     *
     */
    public static void main(String[] args) {
        int k = 5;
        int[] a = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int N = a.length;


        //// 초기화
        int sum = 0;
        int result = 0;

        // 처음에는 모든 수의 값을 구한다.
        for (int i=0; i<k; i++) {
            sum += a[i];
        }

        result = sum;

        // 슬라이딩 윈도우 알고리즘 시작
        // 앞에서 구한 것은 빼고, 뒤에 구한 것은 추가함
        // 알아야할 것!: 현재 윈도우 길이(5) 및 위치를 알아야한다.

        // for (int i=1; i<=N/L; i++) 이게 안되는 이유, 5번이 되어야하는데, N/L이면,, 9/5 인데 1가 되어버림.. 그러면 1번 밖에 안돈다는 말
        // 우리는 그것을 알고싶은게 아니잖아? 총 "슬라이딩 할 수 있는 횟수"를 구하기를 원하는데
        // 그럴 땐 최대 배열 크기 - 슬라이딩 크기를 하면 저 횟수가 구해짐
        // k = 5, N = 9잖아. 그러면 5,6,7,8,9,10,11 4번 돌고
        for (int i=k; i<N; i++) {
            // 이게 중요하다.
            // a[i] - a[i - k]..
            // i=k, 즉 5일 때, i=5 a[5] - a[0] =>   11 + 4 - 1 = 14   => 3 + 2 + 6 -1 + 4의 효과를 낸 것
            sum += a[i] - a[i - k];
            if (result < sum) {
                result = sum;
            }
        }

        System.out.println("result = " + result);
    }
}
