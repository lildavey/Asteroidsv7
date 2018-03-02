package client;

import mayflower.Actor;

public class Laser extends Actor {
    public Laser(int x, int y, int rotation) {
        setImage("img/laser.png");
        setRotation(rotation);
        setLocation(x,y);

    }
    public void tick()
    {
        move(5);
    }

    @Override
    public void act() {

    }
}
