import java.util.HashMap;
import java.util.Map;


public class PicomonDeck {

    private PicomonCard[] cards;

    public PicomonDeck() {
        // Note how the default deck thus has 10 cards.
        this(new PicomonCard[] {
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard()
        });
    }

    public PicomonDeck(PicomonCard... cards) {
        this.cards = cards;
    }

    public PicomonCard cardAt(int index) {
        if (index < 0 || index > cards.length - 1) {
            throw new IllegalArgumentException();
        } else {
            return cards[index];
        }
    }

    public int getSize() {
        return cards.length;
    }

    public void shuffle() {
        PicomonCard[] result = new PicomonCard[cards.length];
        int midsies = cards.length / 2;


        if(cards.length % 2 == 0){
            result[0] = cards[midsies];
            result[1] = cards[0];
            int indexValue = 0;

            for (int i = 2; i < cards.length; i++) {
                if(i % 2 == 0){
                    indexValue += midsies + 1;
                    result[i] = cards[indexValue];
                } else {
                    indexValue -= midsies;
                    result[i] = cards[indexValue];
                }
            }
        }

        if(cards.length % 2 != 0) {
            result[0] = cards[(cards.length -1) / 2];
            result[1] = cards[0];
            int indexValueOdd = 0;

            for (int i = 2; i < cards.length; i++) {
                if(i % 2 == 0) {
                    indexValueOdd += (cards.length + 1) / 2;
                    result[i] = cards[indexValueOdd];
                } else {
                    indexValueOdd -= (cards.length -1) /2;
                    result[i] = cards[indexValueOdd];
                }
            }

        }
        cards = result;
    }

    public boolean orderedEquals(PicomonDeck other) {
        if(cards.length != other.cards.length) {
            return false;
        }
        for(int i = 0; i < cards.length; i++) {
            if (!this.cards[i].equals(other.cards[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "[\n";
        for (PicomonCard card: cards) {
            result += "    ";
            result += card;
            result += "\n";
        }
        return result + "]";
    }

    // Advanced Java---study with caution.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        PicomonDeck other = (PicomonDeck)obj;
        // Due to the possibility of duplicates, deck comparison is a notch trickier.
        // Our approach is to count the cards in each deck then ensure that the cards
        // and counts are the same.
        return tally().equals(other.tally());
    }

    private Map<PicomonCard, Integer> tally() {
        Map<PicomonCard, Integer> result = new HashMap<PicomonCard, Integer>();
        for (PicomonCard card: cards) {
            Integer value = result.get(card);
            if (value == null) {
                result.put(card, 1);
            } else {
                result.put(card, value + 1);
            }
        }

        return result;
    }
}
