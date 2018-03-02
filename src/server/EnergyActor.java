package server;

public class EnergyActor extends SpaceActor implements ActorID {
    private int energy;
    public EnergyActor(int e) {
        energy=e;
        //setImage("img/energy"+e+".png");
    }
    public void setEnergy(int e)
    {
        energy=e;
        setImage("img/energy"+e+".png");
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "energy" + "," + getX() + "," + getY() + "," + getEnergy();
    }
}
