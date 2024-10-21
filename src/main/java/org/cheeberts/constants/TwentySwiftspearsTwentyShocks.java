package org.cheeberts.constants;

import org.cheeberts.model.Card;
import org.cheeberts.model.Spells.BurnSpells.Shock;
import org.cheeberts.model.Spells.CreatureSpells.MonasterySwiftspearSpell;

import java.util.LinkedList;
import java.util.List;

public class TwentySwiftspearsTwentyShocks {
    public static List<Card> getDeck() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 20; i++) {
            deck.add(new Card(new Shock()));
        }
        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }

        return deck;
    }
}
