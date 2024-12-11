// learned decimal format from: https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/


import java.util.Scanner;
import java.text.DecimalFormat;

public class Challenge {
    Scanner scan = new Scanner(System.in);
    DecimalFormat df_tenths = new DecimalFormat("#.#");
    private double distance = 0;
    private int timer = 0;
    private String finaleCLue = "";
    private String bombCode = "";

    public Challenge() {

    }

    public String grapple() {
        int x = (int) (Math.random() * 4 + 1);
        int y = (int) (Math.random() * 4 + 1);
        double sqred = Math.sqrt((x * x) + (y * y));

        if (sqred == (int) sqred) {
            return "Calculate the hypotenuse of a right triangle with leg lengths of " + x + " and " + y;
        } else {
            distance = Double.parseDouble(df_tenths.format(sqred));
            return "Calculate the hypotenuse of a right triangle with leg lengths of " + x + " and " + y + " (to the tenths place)";
        }
    }

    public boolean check() {
        double ans = scan.nextDouble();
        double realANS = distance;

        return realANS == ans;
    }

    public void clue(int success) {
        timer = 15 * success;

        if (success == 2) {
            finaleCLue = "Your so close to victory yet so far? You know all too well you cant save this corrupt system";
        }
        else if (success == 1) {
            finaleCLue = "I can be written, I can be spoken, I can be exposed, I can be broken...    what am I?";
        }
        else {
            finaleCLue = "Im really sick of this whole ordeal with the so called 'words greatest detective', just think corruption or whatever";
        }

        System.out.println();
        System.out.println(finaleCLue);
        System.out.println("You only get " + timer + " seconds to defuse the bomb if you find it");
        System.out.println();
    }

    public void mad(int success) throws InterruptedException {
        System.out.println("WOW, the great BAT-man, you only solved " + success + " riddles? " +
                "\n DO YOU HAVE ANY IDEA HOW MUCH EFFORT I PUT INTO THESE RIDDLES!? LUGGING BOMBS AROUND GOTHAM!?");
        Thread.sleep(5000);
    }

    public String defusal() {

        int rand = (int) (Math.random() * 3) + 1;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = rand; i < rand + 3; i++) {
            if (i % 2 == 0) {

                for (int j = 0; j < 3; j++) {
                    bombCode += "" + ((int) (Math.random() * 9) + 1);
                }

            }
            else {
                for (int j = 0; j < 3; j++) {
                    int r = (int) (Math.random() * 27);
                    bombCode += alphabet.charAt(r);
                }
            }
        }
        return bombCode;
    }


    public boolean check(String code) {
        return (code.equals(bombCode));
    }

}
