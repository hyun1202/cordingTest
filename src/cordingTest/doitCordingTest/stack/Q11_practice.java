package cordingTest.doitCordingTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택으로 오름차순 수열 만들기 <br>
 * 백준 - 1874 <br><br>
 *
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. <br>
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라. <br>
 *
 * 입력 <br>
 * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.<br>
 * 출력 <br>
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다. <br><br>
 *
 * 예제 입력<br>
 * <pre>
 * 8
 * 4
 * 3
 * 6
 * 8
 * 7
 * 5
 * 2
 * 1
 * 예제 출력<br>
 * +
 * +
 * +
 * +
 * -
 * -
 * +
 * +
 * -
 * +
 * +
 * -
 * -
 * -
 * -
 * -
 *
 * 예제 입력2
 * 5
 * 1
 * 2
 * 5
 * 3
 * 4
 *
 * 예제 출력2
 * NO
 * </pre>
 */
public class Q11_practice {
    // 문제가 애매 하지만 "1부터 N까지 오름차순으로 스택에 push를 진행하면서 필요할 때마다 pop을 하여 주어진 임의의 수열을 출력할 수 있는지에 대한 문제" 이다.
    public static void main(String[] args) {

        // 입 출력 및 변수 선언
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] A = new int[n];

        Stack<Integer> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();

        for (int i=0; i<n; i++) {
            A[i] = s.nextInt();
        }

        int num = 1;
        for (int i=0; i<n; i++) {
            int now = A[i];

            if (num <= now) {
                while (num <= now) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int top = stack.pop();

                if (top > now) {
                    System.out.println("NO");
                    System.exit(0);
                    break;
                }

                sb.append("-\n");
            }
        }
        System.out.println(sb.toString());
    }
}
