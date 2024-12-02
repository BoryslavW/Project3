import java.util.Scanner;

public class Challenge {
    public Challenge() {}

        Scanner scan = new Scanner(System.in);

        private double distance = 0;

        public String grapple() {

            int x = (int) (Math.random() * 4 + 1);
            int y = (int) (Math.random() * 4 + 1);

            distance = (Math.sqrt((x * x) + (y * y))) ;
            // find way to shorten this so only tenths place appears


            return "calculate the hypotenuse of a right triangle with legs " + x + " and " + y + " (to the tenths place)";
        }

        public boolean check() {
            double ans = scan.nextDouble();

            double realANS = distance;

            if (realANS == ans) {
                return true;
            }
            else {
                return false;
            }
        }
















}
