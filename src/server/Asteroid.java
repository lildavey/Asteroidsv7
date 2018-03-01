package server;


import mayflower.Actor;
import mayflower.Mayflower;

import java.util.List;

public class Asteroid extends SpaceActor
{
    private double velocity;




    public Asteroid()
    {

        setImage("img/largeAsteroid.png");
        //setLocation(Mayflower.getRandomNumber(1200)-100,Mayflower.getRandomNumber(716)-75);

        turnTowards(Mayflower.getRandomNumber(1016)-50,Mayflower.getRandomNumber(716)-75);



        //setRotation(Mayflower.getRandomNumber(360)-180);

        velocity = (Mayflower.getRandomNumber(4)+1);

    }

    @Override
    public void act() {

    }

    public void tick()
    {
        move(velocity);
    }



    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation()+","+velocity;
    }
}
