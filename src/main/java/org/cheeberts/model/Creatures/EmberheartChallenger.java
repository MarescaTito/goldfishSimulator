package org.cheeberts.model.Creatures;

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

    //TODO HANDLE THIS VALIANT TRIGGER
    @Override
    public void respondToTarget() {
        this.valiantTriggeredThisTurn = true;
    }

    @Override
    public EmberheartChallenger deepCopy() {
        return new EmberheartChallenger(this);
    }
}
