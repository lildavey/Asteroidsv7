package client;

import server.ActorID;
import server.SpaceActor;

public class EnergyActor extends SpaceActor implements ActorID {
    private int energy;
    public EnergyActor(int x,int y, int e) {
        energy=e;
        setImage("img/energy"+e+".png");
        setLocation(x,y);
    }


    public int getEnergy() {
        return energy;
    }
}
