package org.cheeberts.model.spells.buffSpells;

import org.cheeberts.model.creatures.Creature;

public class TurnInsideOut extends BuffSpell {

    public TurnInsideOut() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.oneTurnBuffs += 3;
        //TODO ACTUALLY MANIFEST DREAD
        toBuff.bearsToProduce++;
    }

    @Override
    public TurnInsideOut deepCopy() {
        return new TurnInsideOut();
    }
}
