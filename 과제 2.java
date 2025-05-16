import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] count = new int[8001];  // -4000 ~ 4000 사용하기 위해 0 ~ 8000 사용

        int sum = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
            count[numbers[i] + 4000]++;
        }

        Arrays.sort(numbers);

        // 평균 계산 및 반올림
        int avg = (int) Math.round((double) sum / n);
        if (avg == -0) avg = 0;

        // 중앙값
        int median = numbers[n / 2];

        // 최빈값
        int maxCount = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                freqList.add(i - 4000);
            }
        }

        Collections.sort(freqList);

        int mode;
        if (freqList.size() > 1) {
            mode = freqList.get(1);
        } else {
            mode = freqList.get(0);
        }

        // 범위
        int range = numbers[n - 1] - numbers[0];

        // 출력
        System.out.println(avg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);

        sc.close();
    }
}
