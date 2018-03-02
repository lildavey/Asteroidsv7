package client;

import server.ActorID;
import server.SpaceActor;

public class EnergyActor extends SpaceActor implements ActorID {
    private int energy;
    public EnergyActor(int e) {
        energy=e;
        setImage("img/energy"+e+".png");
    }


    public int getEnergy() {
        return energy;
    }
}
