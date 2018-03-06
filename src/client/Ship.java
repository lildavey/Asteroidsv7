package client;

import server.EnergyActor;
import server.SpaceActor;

public class Ship extends SpaceActor{

    private client.spaceshipActor pilot;
    private client.GunnerActor gunner;
    private client.EnergyActor energyActor;

    public Ship() {
        setImage("img/blank.png");
    }

    public Ship(int xCoord, int yCoord, int pilotRotation, int gunnerRotation, int energy)
    {
        new spaceshipActor(xCoord,yCoord, pilotRotation);
        new GunnerActor(xCoord,yCoord,gunnerRotation);
        new EnergyActor(energy);

    }

    @Override
    public void act() {

    }


    /**
     *
     * @return ship,pilotRotation,velocity,gunnerRotation
     * TODO is velocity ever not zero?
     */
    @Override
    public String toString() {
        return "ship" + "," + getX() + "," + getY() + "," + pilot.getRotation()+ ","  + gunner.getRotation()+","+energyActor.getEnergy();
    }
    /*private class spaceshipActor extends SpaceActor {

        private int x,y,r,maxV, ID;
        private double velocity;
        private double acceleration, deceleration =0;

        public spaceshipActor(int xCoord, int yCoord, int rotation,double velocity,int ID)
        {
            super("img/spaceship.png", xCoord, yCoord, rotation);
            this.x = xCoord; this.y = yCoord; this.r = rotation;
            this.velocity = velocity;
            maxV = 10;
            this.ID = ID;

        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getID() {
            return ID;
        }

        *//**
         * ie Acceleration
         *//*
        public void addVelocity()
        {
            if(velocity <maxV){
                velocity +=acceleration;

            }
        }

        *//**
         * ie Deceleration
         *//*
        public void removeVelocity()
        {
            if(velocity >0){
                velocity -=deceleration;

            }
        }


        public void setAcceleration(double acceleration) {
            this.acceleration = acceleration;
        }

        public void setDeceleration(double deceleration) {
            this.deceleration = deceleration;
        }

        public void turnLeft()
        {
            turn(-2);
        }

        public void turnRight()
        {
            turn(2);
        }

        @Override
        public double getVelocity() {
            return velocity;
        }

        //@Override
        public void tick()
        {
            super.tick();

            this.move(velocity);
            addVelocity();
            removeVelocity();
        }

        public String toString()
        {
            return "spaceship,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
        }
    }

    private class GunnerActor extends SpaceActor implements ActorID {
        private server.spaceshipActor ship;
        public GunnerActor(int x, int y, int r, double v, server.spaceshipActor ship) {
            super("img/laserCannon.png", x, y, r);
            this.ship = ship;

        }


        @Override
        public void tick() {
            super.tick();
            setLocation(ship.getX(),ship.getY());
        }

        public String toString() {
            return "gunner,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
        }
    }*/


}
