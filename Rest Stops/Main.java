import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("reststops.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int rF = Integer.parseInt(st.nextToken());
        int rB = Integer.parseInt(st.nextToken());
        PriorityQueue<stop> stops = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stops.add(new stop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int pos = 0;
        long ans = 0;
        while (!stops.isEmpty())
        {
            stop s = stops.poll();
            if (pos < s.x)
            {
                ans += (long) (s.x - pos) *(rF-rB)*s.c;
                pos = s.x;
            }
        }
        pw.println(ans);
        pw.close();
    }
    static class stop implements Comparable<stop> {
        int x;
        int c;
        stop(int x, int c)
        {
            this.x = x;
            this.c = c;
        }
        @Override
        public int compareTo(stop o) {
            return o.c-this.c;
        }
    }
}