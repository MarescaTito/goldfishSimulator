package org.cheeberts.service;

import org.cheeberts.model.Card;
import org.cheeberts.model.Spells.BurnSpells.LightningBolt;
import org.cheeberts.model.Spells.CreatureSpells.MonasterySwiftspearSpell;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldfishSimulatorTest {
    @Test
    void allSwiftSpearsWinInFive() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 6; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }

        assertEquals(5, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void swiftspearsAndBoltsWinInThree() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new LightningBolt()));
        }

        assertEquals(3, GoldfishSimulator.turnsToWin(deck));
    }
}
