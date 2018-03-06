package server;

import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;
import mayflower.World;
import mayflower.net.Server;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServerWorld extends World implements ActorID
{
    private Server server;
    private Timer timer;

    public ServerWorld(Server server)
    {
        setBackground("img/background.png");
        //750000
        timer = new Timer(750000);
        this.server = server;
        //addObject(new spaceshipActor(100,100,45,0),100,100);
        //addObject(new Asteroid( 100,100,90, 1),100,100);
    }

    @Override
    public void addObject(Actor a, int x, int y)
    {
        super.addObject(a, x, y);
        //System.out.println("Adding: "+ a + " to " + x +", " + y);
    }

    @Override
    public void removeObject(Actor a)
    {
        System.out.println("Removing: "+ a + " ID: " + " at " + a.getX() +", " + a.getY());
        super.removeObject(a);

    }

    @Override
    public void act()
    {
        //System.out.println("MouseAt: "+Mayflower.getMouseInfo().getX()+", "+Mayflower.getMouseInfo().getY());
        //System.out.println("test");

        if(timer.isDone())
        {

            if(getObjects(Asteroid.class).size()<5) {
                addObject(new Asteroid(), Mayflower.getRandomNumber(1017), -150);
            }

            List<SpaceActor> actors = getObjects(SpaceActor.class);
            for(SpaceActor actor : actors)
            {
               if((actor.getX()<-200)||(actor.getX()>1200)||(actor.getY()<-200)||(actor.getY()>900))removeObject(actor);
                actor.tick();
                //System.out.println("actors.size() = " + actors.size());
                //if(actor instanceof Ship) System.out.println("actor.toString() = " + actor.toString());

                //System.out.println("toString() = " + toString());
            }



            timer.reset();
            if(null != server)
            {
                server.send(this.toString());
            }
        }
    }

    public String toString()
    {
        String str = "";

        List<SpaceActor> actors = getObjects(SpaceActor.class);
        for(Actor actor : actors)
        {
            if(actor instanceof Laser || actor instanceof Asteroid)
            str += actor.toString() + ":";

        }

        for (Ship ship :
                ships.values()) {
            str += ship.toString() + ":";
        }

        return str;
    }
}
