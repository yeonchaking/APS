import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        int[] v = new int[s.length() + 1];
        int[] cnt = new int[s.length() + 1];
        HashMap<Integer, Integer> minidx = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int n = 0;
            if (s.charAt(i) == 'S') n = 2;
            if (s.charAt(i) == 'K') n = -1;
            v[i + 1] = v[i] + n;
            cnt[i + 1] = cnt[i] + (n == 0 ? 0 : 1);
        }

        int ans = -1;

//        System.out.println(Arrays.toString(v));
//        System.out.println(Arrays.toString(cnt));
        for (int i = 0; i < s.length() + 1; i++) {
            if (!minidx.containsKey(v[i])) {
                minidx.put(v[i], i);
            } else {
                int midx = minidx.get(v[i]);
                if (cnt[midx] == cnt[i]) continue;
                ans = Math.max(ans, i - midx);
            }
//            System.out.println(i);
//            System.out.println(minidx);
        }

        System.out.println(ans);
        scanner.close();
    }
}