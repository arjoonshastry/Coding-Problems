/*
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] seen;
    static ArrayList<Integer>[] prefer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        prefer = new ArrayList[N + 1];
        int[][] cows = new int[N + 1][N + 1];
        seen = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            prefer[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean wanted = true;
            for (int j = 1; j <= N; j++) {
                cows[i][j] = Integer.parseInt(st.nextToken());
                if (cows[i][j] == i) {
                    wanted = false;
                }
                if (wanted) {
                    prefer[i].add(cows[i][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int ans = i;
            for (int j = 1; j <= N; j++) {
                if (cows[i][j] == i) {
                    break;
                }
                if (dfs(i, cows[i][j])) {
                    ans = cows[i][j];
                    break;
                }
            }
            System.out.println(ans);
        }
    }

    static boolean dfs(int i, int x) {
        if (x == i) {
            return true;
        }
        if (seen[x]) {
            return false;
        }
        seen[x] = true;
        for (int j : prefer[x]) {
            if (dfs(i, j)) {
                return true;
            }
        }
        return false;
    }
}
 */
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[][] prefers;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        int[][] prefList = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean wants = true;

            for (int j = 1; j <= N; j++) {
                int gift = Integer.parseInt(st.nextToken());
                prefList[i][j] = gift;

                if (wants) {
                    adj[i].add(gift);
                }
                if (gift == i) {
                    wants = false;
                }
            }
        }
        prefers = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dfs(i, i);
        }
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int gift = prefList[i][j];
                if (prefers[i][gift] && prefers[gift][i]) {
                    out.append(gift).append("\n");
                    break;
                }
            }
        }
        System.out.print(out);
    }

    static void dfs(int start, int cow) {
        prefers[start][cow] = true;
        for (int neighbor : adj[cow]) {
            if (!prefers[start][neighbor]) {
                dfs(start, neighbor);
            }
        }
    }
}