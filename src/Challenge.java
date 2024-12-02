import java.util.Scanner;

public class Challenge {
    public Challenge() {}

        Scanner scan = new Scanner(System.in);

        private int distance = 0;

        public String grapple() {

            int x = (int) (Math.random() * 4 + 1);
            int y = (int) (Math.random() * 4 + 1);

            distance = (int) (Math.sqrt((x * x) + (y * y)));

            return "calculate the hypotenuse of a right triangle with legs " + x + " and " + y;
        }

        public boolean check() {
            int ans = scan.nextInt();

            int realANS = distance;

            if (realANS == ans) {
                return true;
            }
            else {
                return false;
            }
        }
















}
