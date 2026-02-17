import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int C;
    static int[] t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter out = new PrintWriter(new FileWriter("convention.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        t = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t);

        int l = 0;
        int r = t[N-1];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(l);
        out.println(l);
        out.close();
    }

    private static boolean check(int minWait) {
        int first = t[0];
        int bus = 1;
        int cows = 0;
        for (int i = 0; i < N; i++) {
            if (t[i] - t[0] > minWait || cows >= C) {
                bus++;
                cows = 0;
                first = t[i];
            }
            cows++;
        }
        return bus <= M;
    }
}