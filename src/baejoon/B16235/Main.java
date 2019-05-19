package baejoon.B16235;

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int 양분[][], 여름추가양분[][], 추가양분[][], trees[][][], extrees[][][];
    static int dy[] = {1, 1, 1, 0, 0, -1, -1, -1};
    static int dx[] = {1, 0, -1, 1, -1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        양분 = new int[N][N];
        여름추가양분 = new int[N][N];
        추가양분 = new int[N][N];
        trees = new int[N][N][101];
        extrees = new int[N][N][101];
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                양분[y][x] = 5;
                추가양분[y][x] = sc.nextInt();
            }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int old = sc.nextInt();
            trees[y - 1][x - 1][old]++;
        }
        for (int i = 0; i < K; i++) {
            봄();
            여름();
            가을();
            겨울();
        }
        int res = 0;
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++)
                for (int old = 1; old <= 100; old++)
                    res += trees[y][x][old];
        System.out.println(res);

    }

    static void 봄() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                for (int old = 1; old <= 100; old++) {
                    if (trees[y][x][old] == 0) continue;
                    int std = trees[y][x][old];
                    for (int hm = 0; hm < std; hm++) {
                        if (old <= 양분[y][x]) {
                            양분[y][x] -= old;
                            extrees[y][x][old]--;
                            extrees[y][x][old + 1]++;
                        } else {
                            extrees[y][x][old]--;
                            여름추가양분[y][x] += old / 2;
                        }
                    }
                }
            }
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                for (int old = 1; old <= 100; old++) {
                    trees[y][x][old] += extrees[y][x][old];
                    extrees[y][x][old] = 0;
                }
            }
    }

    static void 여름() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                양분[y][x] += 여름추가양분[y][x];
                여름추가양분[y][x] = 0;
            }
    }

    static void 가을() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                for (int old = 5; old <= 100; old += 5) {
                    if (trees[y][x][old] > 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];
                            if (0 > ny || ny >= N || 0 > nx || nx >= N) continue;
                            trees[y][x][1] += trees[y][x][old];
                        }
                    }
                }
            }
    }

    static void 겨울() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++)
                양분[y][x] += 추가양분[y][x];
    }
}
