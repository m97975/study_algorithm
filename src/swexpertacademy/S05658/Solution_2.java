package swexpertacademy.S05658;

import java.util.Scanner;

public class Solution_2 {

    static int N, map[][], blackhole[][], max, res, blackhole_chk[], s_x, s_y;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            blackhole = new int[5][4];
            blackhole_chk = new int[5];
            max = 0;
            res = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] = sc.nextInt();
                    if (map[y][x] >= 6) {
                        if (blackhole_chk[map[y][x] - 6] == 0) {
                            blackhole[map[y][x] - 6][0] = y;
                            blackhole[map[y][x] - 6][1] = x;
                            blackhole_chk[map[y][x] - 6] = 1;
                        } else {
                            blackhole[map[y][x] - 6][2] = y;
                            blackhole[map[y][x] - 6][3] = x;
                        }
                    }
                }
            }
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    s_x = x;
                    s_y = y;
                    if (map[y][x] != 0)
                        continue;
                    for (int d = 0; d < 4; d++) {
                        int ds = d;
                        max = 0;
                        boolean find = false;
                        int nx = x;
                        int ny = y;
                        max = 0;
                        int sum = 0;
                        while (find == false) {
                            nx += dx[ds];
                            ny += dy[ds];
                            if (0 > nx || 0 > ny || nx >= N || ny >= N || map[ny][nx] == 5) {
                                ds = chg_d(ds);
                                sum += 1;
                            } else if (nx == s_x && ny == s_y) {
                                max = sum;
                                find = true;
                            } else if (map[ny][nx] == -1) {
                                max = sum;
                                find = true;
                            } else if (map[ny][nx] == 0) {
                                continue;
                            } else if (map[ny][nx] == 1) {
                                if (ds == 1) {
                                    ds = 3;
                                    sum += 1;
                                } else if (ds == 2) {
                                    ds = 0;
                                    sum += 1;
                                } else {
                                    ds = chg_d(ds);
                                    sum += 1;
                                }
                            } else if (map[ny][nx] == 2) {
                                if (ds == 2) {
                                    ds = 1;
                                    sum += 1;
                                } else if (ds == 0) {
                                    ds = 3;
                                    sum += 1;
                                } else {
                                    ds = chg_d(ds);
                                    sum += 1;
                                }
                            } else if (map[ny][nx] == 3) {
                                if (ds == 0) {
                                    ds = 2;
                                    sum += 1;
                                } else if (ds == 3) {
                                    ds = 1;
                                    sum += 1;
                                } else {
                                    ds = chg_d(ds);
                                    sum += 1;
                                }
                            } else if (map[ny][nx] == 4) {
                                if (ds == 1) {
                                    ds = 2;
                                    sum += 1;
                                } else if (ds == 3) {
                                    ds = 0;
                                    sum += 1;
                                } else {
                                    ds = chg_d(ds);
                                    sum += 1;
                                }
                            } else if (map[ny][nx] >= 6) {
                                int i = map[ny][nx] - 6;
                                if (ny == blackhole[i][0] && nx == blackhole[i][1]) {
                                    ny = blackhole[i][2];
                                    nx = blackhole[i][3];
                                } else if (ny == blackhole[i][2] && nx == blackhole[i][3]) {
                                    ny = blackhole[i][0];
                                    nx = blackhole[i][1];
                                }
                            }
                        }
                        if (max > res) {
                            res = max;
                            System.out.println(s_y + " " + s_x + " " + d);
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + res);
        }
    }

    static int chg_d(int d) {
        int f = -1;
        if (d == 0)
            f = 1;
        if (d == 1)
            f = 0;
        if (d == 2)
            f = 3;
        if (d == 3)
            f = 2;
        return f;
    }
}

