package cordingTest.programmers;


public class S0611 {
    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< food.length; i++) {
            sb.append(Integer.toString(i).repeat(food[i] / 2));
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 4, 6}));
        System.out.println(solution(new int[] {1, 7, 1, 2}));
    }
}
