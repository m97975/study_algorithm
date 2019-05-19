package baejoon.B16236;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, map[][], max;
    static int dy[] = {-1, 0, 0, 1};
    static int dx[] = {0, -1, 1, 0};
    static int visited[][];
    static int distance;

    static class fish {
        int y, x, d;

        fish(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    static class shark {
        int y, x, size, eat_amount;

        shark(int y, int x, int s, int e) {
            this.size = s;
            this.y = y;
            this.x = x;
            this.eat_amount = e;
        }
        void check_s(){

        }

        void reposition(int y, int x) {
            this.y = y;
            this.x = x;
        }

        boolean eat(int eat_size) {
            if (size > eat_size)
                return true;
            return false;
        }
    }

    static shark baby;
    static Queue<fish> fishes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        distance = 0;
        fishes = new LinkedList<fish>();

        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                map[y][x] = sc.nextInt();
                if (map[y][x] == 9) {
                    baby = new shark(y, x, 2, 0);
                }
            }
        find(baby.y, baby.x);
        System.out.println(distance);
    }

    static void find(int y, int x) {
        int ry = 100, rx = 100, rd = 100;
        Queue<fish> q = new LinkedList<fish>();
        q.add(new fish(y, x, 0));
        visited = new int[N][N];
        visited[y][x] = 1;
        while (!q.isEmpty()) {
            fish tmp = q.remove();
            int tx = tmp.x, ty = tmp.y, td = tmp.d;
            for (int d = 0; d < 4; d++) {
                int ny = ty + dy[d];
                int nx = tx + dx[d];
                int nd = td + 1;
                if (0 > ny || 0 > nx || ny >= N || nx >= N) continue;
                if (map[ny][nx] > baby.size) continue;
                if (nd > rd) continue;
                if (visited[ny][nx] == 1) continue;
                if (map[ny][nx] != 0 && baby.eat(map[ny][nx])) {
                    visited[ny][nx] = 1;
                    if (ry < ny) continue;
                    if (rx < nx) continue;
                    ry = ny;
                    rx = nx;
                    rd = nd;
                } else {
                    ((LinkedList<fish>) q).add(new fish(ny, nx, nd));
                    visited[ny][nx] = 1;
                }
            }
        }
        if (rd == 100){ return;}
        else{ distance = distance+rd;
            map[ry][rx] = 0;
            baby.reposition(ry,rx);
            find(ry, rx);}
    }
}
