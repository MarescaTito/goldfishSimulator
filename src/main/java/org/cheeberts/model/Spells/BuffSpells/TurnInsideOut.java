package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;

public class TurnInsideOut extends BuffSpell {

    public TurnInsideOut() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.oneTurnBuffs += 3;
        //TODO ACTUALLY MANIFEST DREAD
        toBuff.bearsToProduce++;
        toBuff.respondToTarget();

    }
}
