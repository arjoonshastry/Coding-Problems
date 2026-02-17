import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);

        int l = 1;
        int r = (map[N-1]-map[0])/2;
        while (l < r)
        {
            int mid = (l+r)/2;
            if (check(mid))
            {
                r = mid;
            }
            else
            {
                l = mid+1;
            }
        }
        pw.println(r);
        pw.close();
    }

    static boolean check(int r)
    {
        int shot = 0;
        int bale = 0;
        while (shot < K && bale < N-1)
        {
            int start = map[bale];
            while (map[bale] <= start+2*r)
            {
                if (bale >= N-1)
                {
                    return true;
                }
                bale++;
            }
            shot++;
            if (shot >= K)
            {
                return false;
            }
        }
        return true;
    }
}