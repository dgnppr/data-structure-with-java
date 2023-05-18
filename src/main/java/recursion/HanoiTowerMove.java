package recursion;

public class HanoiTowerMove {

    static void move(int n, char from, char by, char to) {
        if (n == 1) {
            System.out.printf("원반 1을 %c에서 %c로 이동 \n", from, to);
        } else {
            move(n - 1, from, to, by);
            System.out.printf("원반 %d를 %c에서 %c로 이동 \n", n, from, to);
            move(n - 1, by, from, to);
        }
    }

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C'); // 원반 3개를 막대 B를 경유하여 막대 C로 옮기기
    }
}
