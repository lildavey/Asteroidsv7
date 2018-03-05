package server;

public class EnergyActor extends SpaceActor implements ActorID {
    private int energy;
    public EnergyActor(int e) {
        energy=e;
        setImage("img/energy"+e+".png");
    }
    public void setEnergy(int e)
    {
        energy=e;
        //setImage("img/energy"+e+".png");
    }

    public int getEnergy() {
        return energy;
    }

    public void addEnergy()
    {
        energy++;
        setImage("img/energy"+energy+".png");
    }
    public void subtractEnergy()
    {
        energy--;
        setImage("img/energy"+energy+".png");
    }

    @Override
    public String toString() {


        return "energy" + "," + 20 + "," + 50 + "," + getEnergy();
    }
}
