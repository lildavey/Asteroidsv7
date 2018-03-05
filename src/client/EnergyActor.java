package client;

import mayflower.MayflowerImage;
import server.ActorID;
import server.SpaceActor;

public class EnergyActor extends SpaceActor implements ActorID {
    private int energy;
    public EnergyActor(int x,int y, int e) {
        energy=e;

        MayflowerImage img = new MayflowerImage("img/energy"+e+".png");

        setImage(img);

        setLocation(x,y);
    }


    public int getEnergy() {
        return energy;
    }
}
