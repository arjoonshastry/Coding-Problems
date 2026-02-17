import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int T;
    static int[] d;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowdance.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        int low = 0;
        int high = N - 1;
        high++;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (dance(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        pw.println(low);
        br.close();
        pw.close();
    }

    static boolean dance(int K) {
        if (K == 0)
        {
            return false;
        }
        PriorityQueue<Integer> stage = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            stage.add(d[i]);
        }
        for (int i = K; i < N; i++) {
            stage.add(stage.remove() + d[i]);
        }
        for (int i = 0; i < K - 1; i++) {
            stage.remove();
        }
        return T >= stage.remove();
    }
}