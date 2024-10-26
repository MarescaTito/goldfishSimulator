package org.cheeberts;

import org.cheeberts.constants.deckList.DuskmourneLeylineAllInOnTurnTwo;
import org.cheeberts.constants.deckList.DuskmourneLeylineSubLightningStrike;
import org.cheeberts.model.Card;
import org.cheeberts.service.GoldfishSimulator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] winTurns = new int[60];
        for(int i = 0; i < 10000; i++) {
            if(i%10 == 0) {
                System.out.println(i);
            }

            winTurns[GoldfishSimulator.turnsToWin(getSmoothedDeck(DuskmourneLeylineAllInOnTurnTwo.getDeck(), DuskmourneLeylineAllInOnTurnTwo.landRatio()))]++;
        }

        for(int i : winTurns) {
            System.out.println(i);
        }
    }

    private static List<Card> getSmoothedDeck(List<Card> deck, double ratio) {
        List<Card> deck1 = new LinkedList<>(deck);
        List<Card> deck2 = new LinkedList<>(deck);
        Collections.shuffle(deck1);
        Collections.shuffle(deck2);

        int count1 = 0;
        int count2 = 0;
        double ratio1;
        double ratio2;

        for(int i = 0; i < 7; i++) {
            if(deck1.get(deck1.size()-1-i).spell == null) {
                count1++;
            }
            if(deck1.get(deck1.size()-1-i).spell == null) {
                count2++;
            }
        }

        ratio1=(double) count1/deck1.size();
        ratio2=(double) count2/deck2.size();

        return Math.abs(ratio - ratio1) <= Math.abs(ratio - ratio2) ? deck1 : deck2;
    }
}