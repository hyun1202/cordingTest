package cordingTest.doitCordingTest.sort;

import java.io.*;

/**
 * 백준 10989
 * 1. 시간 초과 - Scanner, System.out -> BufferedReader 및 BufferedWriter로 수정
 * 2. 메모리 초과 - Queue -> 기본 배열로 수정 (합 배열 이용)
 * 3. 계수 정렬 이용
 */
public class Q22 {
    public static void main(String[] args) throws IOException {
        // 계수 정렬
        // 1. 데이터가 양수
        // 2. 데이터 크기가 매우 작아야한다. (데이터 하나의 값, 최대 갯수가 아니다.)

        // 계수정렬은 데이터가 들어오면 index로 본다.
        // 데이터를 입력받아 값에 해당하는 index값을 증가시켜준다.
        // 배열을 처음부터 끝까지 탐색하면서 값이 0이 아닐 경우 해당 값이 있는 index를 값만큼 반복하여 출력
        // ex) a[10] = {0,1,2,0,0,0,0,0,0,0} => 출력: 1 2 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int maxSize = 10001;

        int[] count = new int[maxSize];

        for (int i=0; i<n; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i=0; i<maxSize; i++) {
            if (count[i] != 0) {
                // index만큼 반복하여 출력해준다.
                for (int j=0; j<count[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
