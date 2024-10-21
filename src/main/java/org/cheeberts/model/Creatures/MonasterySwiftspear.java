package org.cheeberts.model.Creatures;

public class MonasterySwiftspear extends Creature {

    public MonasterySwiftspear() {
        super();
        this.basePower = 1;
        this.haste = true;
    }

    public MonasterySwiftspear(MonasterySwiftspear c) {
        super(c);
    }

    @Override
    public void respondToNonCreatureSpell() {
        oneTurnBuffs++;
    }

    @Override
    public void respondToTarget() {
        //Do nothing
    }

    @Override
    public MonasterySwiftspear deepCopy() {
        return new MonasterySwiftspear(this);
    }
}
