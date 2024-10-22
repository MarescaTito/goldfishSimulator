package org.cheeberts.model.Spells.Misc;

import org.cheeberts.model.Card;
import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.EmberheartChallenger;
import org.cheeberts.model.Creatures.HeartfireHero;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

import java.util.HashSet;
import java.util.Set;

public class MightOfTheMeek extends Spell {
    public MightOfTheMeek() {
        this.manaCost = 1;
    }

    public MightOfTheMeek deepCopy() {
        return new MightOfTheMeek();
    }

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = getGameStateWithPaidCosts(gameState);

        if(paid != null) {
            boolean hasMouse = paid.creatures.stream().anyMatch(c -> (c instanceof EmberheartChallenger
                    || c instanceof HeartfireHero));

            for(int i = 0; i < paid.creatures.size(); i++) {
                GameState toAdd = new GameState(paid);

                toAdd.creatures.get(i).respondToTarget();
                toAdd.creatures.get(i).oneTurnBuffs += hasMouse ? 1 : 0;
                toAdd.hand.add(toAdd.deck.removeLast());

                if(!toAdd.playedLandForTurn) {
                    for (Card c : toAdd.hand) {
                        if (c.spell == null) {
                            toAdd.hand.remove(c);
                            toAdd.playedLandForTurn = true;
                            toAdd.untappedLands++;
                            break;
                        }
                    }
                }

                for(Creature c : toAdd.creatures) {
                    c.respondToNonCreatureSpell();
                }
                toReturn.add(toAdd);
            }
        }

        return toReturn;
    }
}
