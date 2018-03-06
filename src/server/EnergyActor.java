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
        if(energy<5) {
            energy++;
            setImage("img/energy" + energy + ".png");
        }
    }
    public void subtractEnergy()
    {
        if(energy>0) {
            energy--;
            setImage("img/energy" + energy + ".png");
        }
    }

    @Override
    public String toString() {


        return "energy" + ","  + getEnergy();
    }
}
