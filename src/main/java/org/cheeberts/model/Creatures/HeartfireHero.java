package org.cheeberts.model.Creatures;

public class HeartfireHero extends Creature {

    public HeartfireHero() {
        super();
        this.basePower = 1;
    }

    public HeartfireHero(HeartfireHero c) {
        super(c);
    }

    @Override
    public void respondToNonCreatureSpell() {
        //Do nothing
    }

    @Override
    public void respondToTarget() {
        this.plusOneCounters += valiantTriggeredThisTurn ? 0 : 1;
        this.valiantTriggeredThisTurn = true;
    }

    @Override
    public HeartfireHero deepCopy() {
        return new HeartfireHero(this);
    }
}
