public class Logic {
    private int success = 0;
    private int fails = 0;

    public Logic() {

    }

    public void start() {
        Challenge challenge = new Challenge();
        Riddles riddle = new Riddles();
        TextArt art = new TextArt();

        System.out.println(art.batman());
    //    System.out.println(riddle.giveRiddle());

        while (success < 3 || fails < 3) {
            //give the riddler image we want

            System.out.println(riddle.giveRiddle());
            boolean check = riddle.checkANS();
            if (check) {
                success++;
            } else {
                fails++;
            }
            System.out.println(success);
            System.out.println(fails);
            if (success == 3 || fails == 3) {
                break;
            }
        }

        if (success == 3) {
            //show game win image
            System.out.println("You won, Gotham lives to see another night");
            System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help");
        }

        if (fails == 3) {
            //put grapple image here
            System.out.println(challenge.grapple());
            //boolean checkChallenge = challenge.check();

            if (challenge.check()) {
                System.out.println(riddle.giveRiddle());
                if (riddle.checkANS()) {
                    //show game win image
                    System.out.println("You won, Gotham lives to see another night");
                    System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help");
                } else {
                    // show the game over lose image
                    System.out.println("You lost, Gotham has been blown to smithereens");
                    System.out.println(":(");
                }
            }
            else {
                // show the game over lose image
                System.out.println("You lost, Gotham has been blown to smithereens");
                System.out.println(":(");
            }
        }
        else {
            //show game win image
            System.out.println("You won, Gotham lives to see another night");
            System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help");
        }


    }
}
