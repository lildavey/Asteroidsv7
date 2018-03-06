package server;

import mayflower.Timer;

public class GunnerActor extends SpaceActor implements ActorID {
    private spaceshipActor ship;
    private Timer timer = new Timer((int)(.25*Math.pow(10,(9))));

    public boolean fire;

    public GunnerActor(int x, int y, int r, double v, spaceshipActor ship) {
        super("img/laserCannon.png", x, y, r);
        this.ship = ship;

    }
    public GunnerActor(){setImage("img/laserCannon.png");}

    public void fireLaser()
    {


        if(timer.isDone()) {
            getWorld().addObject(new Laser(getX(), getY(), getRotation()), getX(), getY());
            timer.reset();
        }
    }


    @Override
    public void tick() {
        super.tick();
        setLocation(ship.getX(),ship.getY());

        if(fire)fireLaser();

    }

    public String toString() {
        return "gunner,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }
}
