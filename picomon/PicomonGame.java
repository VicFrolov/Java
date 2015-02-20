public class PicomonGame {

    public enum Player {
        GYM_LEADER("Gym leader"), TRAINER("Trainer");

        private String representation;
        private Player(String representation) {
            this.representation = representation;
        }

        @Override
        public String toString() {
            return representation;
        }
    }

    public class Round {
        public Player winner; // null if tied.
        public PicomonCard gymLeaderCard;
        public PicomonCard trainerCard;

        public Round(PicomonCard gymLeaderCard, PicomonCard trainerCard) {
            this.gymLeaderCard = gymLeaderCard;
            this.trainerCard = trainerCard;
        }

        @Override
        public String toString() {
            if (winner == null) {
                return "It's a tie between " + Player.GYM_LEADER + "'s " + gymLeaderCard + " and " +
                        Player.TRAINER + "'s " + trainerCard + "!";
            } else {
                Player loser = winner == Player.GYM_LEADER ? Player.TRAINER : Player.GYM_LEADER;
                PicomonCard winningCard = winner == Player.GYM_LEADER ? gymLeaderCard : trainerCard;
                PicomonCard losingCard = winner == Player.GYM_LEADER ? trainerCard : gymLeaderCard;
                return winner + "'s " + winningCard + " beats " + loser + "'s " + losingCard + "!";
            }
        }
    }

    private PicomonDeck gymLeaderDeck;
    private PicomonDeck trainerDeck;
    private int gymLeaderPosition;
    private int trainerPosition;

    public PicomonGame() {
        this(new PicomonDeck(), new PicomonDeck());
    }

    public PicomonGame(PicomonDeck gymLeaderDeck, PicomonDeck trainerDeck) {
        if (gymLeaderDeck.getSize() != trainerDeck.getSize()) {
            throw new IllegalArgumentException();
        }

        gymLeaderPosition = 0;
        trainerPosition = 0;
        this.gymLeaderDeck = gymLeaderDeck;
        this.trainerDeck = trainerDeck;
    }

    public PicomonDeck getGymLeaderDeck() {
        return gymLeaderDeck;
    }

    public PicomonDeck getTrainerDeck() {
        return trainerDeck;
    }

    public boolean isMatchOver() {
        if(gymLeaderPosition < gymLeaderDeck.getSize() && trainerPosition < trainerDeck.getSize()) {
            return false;
        } else{
            return true;
        }
    }

    public Player getLeader() {
        if(gymLeaderPosition > trainerPosition) {
            return Player.TRAINER;
        } else if(gymLeaderPosition < trainerPosition) {
            return Player.GYM_LEADER;
        } else {
            return null;
        }
    }

    public Round playRound() {
        PicomonCard trainerCard = trainerDeck.cardAt(trainerPosition);
        PicomonCard gymLeaderCard = gymLeaderDeck.cardAt(gymLeaderPosition);

        Round round = new Round(gymLeaderCard, trainerCard);

        if (!trainerCard.beats(gymLeaderCard) && !gymLeaderCard.beats(trainerCard)) {
            gymLeaderPosition += 1;
            trainerPosition += 1;
            round.winner = null;
        } else if(!trainerCard.beats(gymLeaderCard)) {
            trainerPosition += 1;
            round.winner = Player.GYM_LEADER;
        } else {
            gymLeaderPosition += 1;
            round.winner = Player.TRAINER;
        }
        return round;
    }

    public Round[] playMatch() {
        Round[] newMatch = new Round[trainerDeck.getSize() * gymLeaderDeck.getSize()];

        for(int i = 0; isMatchOver() == false; i++) {
            newMatch[i] = playRound();
            // remember to erase this print
            System.out.println(newMatch[i]);
        }
        return newMatch;
    }

    public static void main(String[] args) {

        System.out.println("aa");
        // Implement me!
    }

}
