import java.util.Scanner;
import java.text.DecimalFormat;

public class Challenge {
    Scanner scan = new Scanner(System.in);
    DecimalFormat df_tenths = new DecimalFormat("#.#");
    private double distance = 0;

    public Challenge() {

    }

    public String grapple() {

            int x = (int) (Math.random() * 4 + 1);
            int y = (int) (Math.random() * 4 + 1);

            distance = Double.parseDouble(df_tenths.format(Math.sqrt((x * x) + (y * y))));
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
