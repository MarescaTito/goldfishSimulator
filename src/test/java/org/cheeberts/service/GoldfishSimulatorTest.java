package org.cheeberts.service;

import org.cheeberts.model.Card;
import org.cheeberts.model.spells.buffSpells.TurnInsideOut;
import org.cheeberts.model.spells.burnSpells.Shock;
import org.cheeberts.model.spells.creatureSpells.CacophonyScampSpell;
import org.cheeberts.model.spells.creatureSpells.EmberheartChallengerSpell;
import org.cheeberts.model.spells.creatureSpells.HeartfireHeroSpell;
import org.cheeberts.model.spells.creatureSpells.MonasterySwiftspearSpell;
import org.cheeberts.model.spells.misc.BurnTogether;
import org.cheeberts.model.spells.misc.MightOfTheMeek;
import org.cheeberts.model.spells.nonCreaturePermanents.LeylineOfResonance;
import org.cheeberts.spells.TwentyDamageForOneMana;
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
    void swiftspearsAndShocksWinInThree() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new Shock()));
        }

        assertEquals(3, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void swiftspearsAndInsideOutsWinInThree() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new Shock()));
        }

        assertEquals(3, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void swiftspearsInsideOutsAndLeylinesWinInTwo() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 2; i++) {
            deck.add(new Card(new TurnInsideOut()));
        }
        for(int i = 0; i < 2; i++) {
            deck.add(new Card(new LeylineOfResonance()));
        }

        assertEquals(2, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void swiftspearsInsideOutsAndLeylineWinInSix() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 2; i++) {
            deck.add(new Card(new TurnInsideOut()));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new LeylineOfResonance()));
        }

        assertEquals(6, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void scampInsideOutsLeylineWinInTwo() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new CacophonyScampSpell()));
        }
        for(int i = 0; i < 2; i++) {
            deck.add(new Card(new TurnInsideOut()));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new LeylineOfResonance()));
        }

        assertEquals(2, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void heartfireHeroLeylineInsideOutBurnTogetherWinInTwo() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }

        deck.add(new Card(new HeartfireHeroSpell()));
        deck.add(new Card(new TurnInsideOut()));
        deck.add(new Card(new LeylineOfResonance()));
        deck.add(new Card(new BurnTogether()));

        assertEquals(2, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void heartfireHeroInsideOutWinInEight() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }

        deck.add(new Card(new HeartfireHeroSpell()));
        deck.add(new Card(new TurnInsideOut()));
        deck.add(new Card(new LeylineOfResonance()));

        assertEquals(8, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void slickShotAndShocksWinInThree() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 20; i++) {
            deck.add(new Card(null));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new CacophonyScampSpell()));
        }
        for(int i = 0; i < 2; i++) {
            deck.add(new Card(new TurnInsideOut()));
        }
        for(int i = 0; i < 1; i++) {
            deck.add(new Card(new LeylineOfResonance()));
        }

        assertEquals(2, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void heartfireHeroMightOfTheMeekWinInTen() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 30; i++) {
            deck.add(new Card(null));
        }

        deck.add(new Card(new HeartfireHeroSpell()));
        deck.add(new Card(new MightOfTheMeek()));
        deck.add(new Card(new LeylineOfResonance()));

        assertEquals(10, GoldfishSimulator.turnsToWin(deck));
    }

    @Test
    void emberHeartImpulseDraws() {
        List<Card> deck = new LinkedList<>();

        deck.add(new Card(new TwentyDamageForOneMana()));
        for(int i = 0; i < 7; i++) {
            deck.add(new Card(null));
        }
        deck.add(new Card(new TurnInsideOut()));
        deck.add(new Card(new EmberheartChallengerSpell()));

        assertEquals(3, GoldfishSimulator.turnsToWin(deck));
    }

}
