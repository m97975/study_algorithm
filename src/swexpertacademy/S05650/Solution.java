package swexpertacademy.S05650;

import java.util.Scanner;

public class Solution {
    static int map[][];
    static int warmhole[][][];
    static int max;
    static int start_x, start_y;
    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            warmhole = new int[11][2][2];
            for (int n1 =6;n1<11;n1++){
                for (int n2 =0;n2<2;n2++){
                    for (int n3 =0;n3<2;n3++){
                        warmhole[n1][n2][n3] = -1;
                    }
                }
            }
            max = 0;
            for (int n = 0; n < N; n++)
                for (int m = 0; m < N; m++) {
                    map[n][m] = sc.nextInt();
                    if (map[n][m] >= 6) {
                        if (warmhole[map[n][m]][0][0] == -1) {
                            warmhole[map[n][m]][0][0] = n;
                            warmhole[map[n][m]][0][1] = m;
                        } else {
                            warmhole[map[n][m]][1][0] = n;
                            warmhole[map[n][m]][1][1] = m;
                        }
                    }
                }
            for (int n = 0; n < N; n++)
                for (int m = 0; m < N; m++) {
                    start_y = n;
                    start_x = m;
                    if (map[n][m] == 0) {
                        for (int d = 0; d < 4; d++)
                            max = Math.max(max, go(n, m, d));
                    }
                }
            System.out.println("#" + test_case + " " + max);
        }
    }

    static int go(int y, int x, int dir) {
        int score = 0;
        while (true) {
            if (0 <= x && x < N && 0 <= y && y < N) {
                if (map[y][x] == -1) {
                    break;
                } else if (map[y][x] == 0) {
                } else if (map[y][x] == 1) {
                    score++;
                    if (dir == 0) dir = 2;
                    else if (dir == 1) dir = 0;
                    else if (dir == 2) dir = 3;
                    else if (dir == 3) dir = 1;
                } else if (map[y][x] == 2) {
                    score++;
                    if (dir == 0) dir = 3;
                    else if (dir == 1) dir = 2;
                    else if (dir == 2) dir = 0;
                    else if (dir == 3) dir = 1;
                } else if (map[y][x] == 3) {
                    score++;
                    if (dir == 0) dir = 1;
                    else if (dir == 1) dir = 3;
                    else if (dir == 2) dir = 0;
                    else if (dir == 3) dir = 2;
                } else if (map[y][x] == 4) {
                    score++;
                    if (dir == 0) dir = 2;
                    else if (dir == 1) dir = 3;
                    else if (dir == 2) dir = 1;
                    else if (dir == 3) dir = 0;
                } else if (map[y][x] == 5) {
                    score++;
                    if (dir == 0) dir = 2;
                    else if (dir == 1) dir = 3;
                    else if (dir == 2) dir = 0;
                    else if (dir == 3) dir = 1;
                } else if (map[y][x] >= 6) {
                    if (warmhole[map[y][x]][0][0] == y && warmhole[map[y][x]][0][1] == x) {
                        int ty = warmhole[map[y][x]][1][0];
                        int tx = warmhole[map[y][x]][1][1];
                        y = ty;
                        x = tx;
                    } else if (warmhole[map[y][x]][1][0] == y && warmhole[map[y][x]][1][1] == x) {
                        int ty = warmhole[map[y][x]][0][0];
                        int tx = warmhole[map[y][x]][0][1];
                        y = ty;
                        x = tx;
                    }
                }
            }
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                score++;
                if (dir == 0) dir = 2;
                else if (dir == 2) dir = 0;
                else if (dir == 1) dir = 3;
                else if (dir == 3) dir = 1;
            }
            y = ny;
            x = nx;
            if (y == start_y && x == start_x) {
                break;
            }
        }
        return score;
    }
}
