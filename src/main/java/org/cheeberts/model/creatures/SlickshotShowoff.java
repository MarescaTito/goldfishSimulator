package org.cheeberts.model.creatures;

import org.cheeberts.model.GameState;

public class SlickshotShowoff extends Creature {

    public SlickshotShowoff() {
        super();
        basePower = 1;
        haste = true;
    }

    public SlickshotShowoff(SlickshotShowoff c) {
        super(c);
    }

    @Override
    public void respondToNonCreatureSpell() {
        oneTurnBuffs +=2;
    }

    @Override
    public void respondToTarget(GameState g) {
        //Do nothing
    }

    @Override
    public SlickshotShowoff deepCopy() {
        return new SlickshotShowoff(this);
    }
}
