package client;

import mayflower.Actor;

public class GunnerActor extends Actor {

    public GunnerActor(int x, int y, int r) {
        setImage("img/laserCannon.png");
        setLocation(x,y);
        setRotation(r);
    }

    @Override
    public void act() {

    }
}
