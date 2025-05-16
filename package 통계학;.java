package 통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] count = new int[8001];

        int sum = 0;
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            count[numbers[i] + 4000]++;
        }

        Arrays.sort(numbers);

        double avg = (double) sum / n;
        int roundedAvg = (int) Math.round(avg);
        if (roundedAvg == -0) roundedAvg = 0;

        int median = numbers[n / 2];

        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                freqList.add(i - 4000);
            }
        }

        int mode;
        if (freqList.size() > 1) {
            Collections.sort(freqList);
            mode = freqList.get(1);
        } else {
            mode = freqList.get(0);
        }

        int range = numbers[n - 1] - numbers[0];

        System.out.println(roundedAvg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
