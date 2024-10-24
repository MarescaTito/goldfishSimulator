package org.cheeberts.model.Creatures;

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
    public void respondToTarget() {
        //Do nothing
    }

    @Override
    public SlickshotShowoff deepCopy() {
        return new SlickshotShowoff(this);
    }
}
