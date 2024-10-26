package org.cheeberts;

import org.cheeberts.constants.deckList.*;
import org.cheeberts.model.Card;
import org.cheeberts.service.GoldfishSimulator;
import org.cheeberts.util.SmoothedDeck;

public class Main {
    public static void main(String[] args) {
        int[] winTurns = new int[60];
        for(int i = 0; i < 10000; i++) {
            if(i%10 == 0) {
                System.out.println(i);
            }
            winTurns[GoldfishSimulator.turnsToWin(SmoothedDeck.getSmoothedDeck(DuskmourneLeyline.getDeck(),
                    DuskmourneLeyline.landRatio()))]++;
        }

        for(int i : winTurns) {
            System.out.println(i);
        }
    }


}