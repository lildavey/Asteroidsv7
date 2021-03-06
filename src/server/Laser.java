package server;


public class Laser extends SpaceActor {
    public Laser(int x, int y, int rotation) {
//        setLocation(x,y);
        setImage("img/laser.png");
        setRotation(rotation);
    }
    public void tick()
    {
        move(5);
        for (SpaceActor actor:getWorld().getObjects(Asteroid.class)) {
            if(this.intersects(actor)) getWorld().removeObject(this);
        }
    }

    public String toString() {
        return "laser,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }

}
