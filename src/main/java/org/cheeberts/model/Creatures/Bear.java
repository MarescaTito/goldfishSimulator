package org.cheeberts.model.Creatures;

public class Bear extends Creature {

    public Bear() {
        super();
        this.basePower = 2;
    }

    public Bear(Bear c) {
        super(c);
    }

    @Override
    public void respondToNonCreatureSpell() {
        //Do nothing
    }

    @Override
    public void respondToTarget() {
        //Do nothing
    }

    @Override
    public Bear deepCopy() {
        return new Bear(this);
    }
}
