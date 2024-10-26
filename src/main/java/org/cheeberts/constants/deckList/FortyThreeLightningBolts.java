package org.cheeberts.constants.deckList;

import org.cheeberts.model.Card;
import org.cheeberts.model.spells.burnSpells.LightningBolt;

import java.util.LinkedList;
import java.util.List;

public class FortyThreeLightningBolts {
    public static List<Card> getDeck() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 43; i++) {
            deck.add(new Card(new LightningBolt()));
        }
        for(int i = 0; i < 17; i++) {
            deck.add(new Card(null));
        }

        return deck;
    }

    public static double landRatio() {
        return 17.0/60.0;
    }
}
