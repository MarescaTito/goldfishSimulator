package org.cheeberts.util;

import org.cheeberts.constants.deckList.FortyThreeLightningBolts;
import org.cheeberts.model.GameState;
import org.cheeberts.model.creatures.HeartfireHero;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeTotalFilterTest {

    @Test
    public void filterTakesLowerLifeTotal() {
        GameState g1 = new GameState(FortyThreeLightningBolts.getDeck());
        GameState g2 = new GameState(FortyThreeLightningBolts.getDeck());
        g2.lifetotal = 19;

        Set<GameState> gameStateSet = Set.of(g1,g2);
        Set<GameState> filtered = LifeTotalFilter.lifeTotalFilter(gameStateSet);
        assertEquals(1, filtered.size());
        assertEquals(19, filtered.iterator().next().lifetotal);
    }


    @Test
    public void filterKeepsDifferentStates() {
        GameState g1 = new GameState(FortyThreeLightningBolts.getDeck());
        GameState g2 = new GameState(FortyThreeLightningBolts.getDeck());
        g2.lifetotal = 19;
        g2.creatures.add(new HeartfireHero());

        Set<GameState> gameStateSet = Set.of(g1,g2);
        Set<GameState> filtered = LifeTotalFilter.lifeTotalFilter(gameStateSet);
        assertEquals(2, filtered.size());
    }
}
