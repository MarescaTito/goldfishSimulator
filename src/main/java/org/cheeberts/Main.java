package org.cheeberts;

import org.cheeberts.constants.DuskmourneLeyline;
import org.cheeberts.model.Card;
import org.cheeberts.service.GoldfishSimulator;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] winTurns = new int[60];
        for(int i = 0; i < 10000; i++) {
            List<Card> deck = DuskmourneLeyline.getDeck();
            Collections.shuffle(deck);

            winTurns[GoldfishSimulator.turnsToWin(deck)]++;
        }

        for(int i : winTurns) {
            System.out.println(i);
        }
    }
}