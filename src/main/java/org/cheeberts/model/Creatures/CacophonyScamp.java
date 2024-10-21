package org.cheeberts.model.Creatures;

public class CacophonyScamp extends Creature {

    public CacophonyScamp() {
        super();
        this.basePower = 1;
    }

    public CacophonyScamp(CacophonyScamp c) {
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
    public CacophonyScamp deepCopy() {
        return new CacophonyScamp(this);
    }
}
