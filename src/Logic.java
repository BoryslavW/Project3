public class Logic {
    public Logic() {}

    public void start() {

        int success = 0;
        int fails = 0;

        Challenge challenge = new Challenge();
        Riddles riddle = new Riddles();
        TextArt art = new TextArt();

        art.batman();
        riddle.riddles();

        while (success < 0 && fails < 0) {
            //give the riddler image we want

            System.out.println(riddle.riddles());
            boolean check = riddle.checkANS();
            if (check) {
                success++;
            } else {
                fails++;
            }
        }

        if (fails == 3) {
            //put grapple image here
            System.out.println(challenge.grapple());
            boolean checkChallenge = challenge.check();

            if (checkChallenge) {
                riddle.riddles();
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
