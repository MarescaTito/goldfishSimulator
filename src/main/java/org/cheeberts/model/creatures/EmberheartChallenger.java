package org.cheeberts.model.creatures;

import org.cheeberts.model.GameState;
import org.cheeberts.model.Card;

public class EmberheartChallenger extends Creature {

    public EmberheartChallenger() {
        super();
        this.basePower = 2;
        this.haste = true;
    }

    public EmberheartChallenger(EmberheartChallenger c) {
        super(c);
    }

    @Override
    public void respondToNonCreatureSpell() {
        oneTurnBuffs++;
    }

    @Override
    public void respondToTarget(GameState g) {
        if(!valiantTriggeredThisTurn) {
            Card toImpulse = g.deck.removeLast();
            toImpulse.impulsed = true;
            g.hand.add(toImpulse);
        }
        this.valiantTriggeredThisTurn = true;
    }

    @Override
    public EmberheartChallenger deepCopy() {
        return new EmberheartChallenger(this);
    }
}
