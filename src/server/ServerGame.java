package server;

import client.Asteroid;
import client.GunnerActor;
import mayflower.*;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerGame extends Mayflower implements ActorID {


    private ServerWorld world;

    public ServerGame(Server server) {
        super("Server", 1024, 768);


        world = new ServerWorld(server);
        this.setWorld(world);
    }

    /**
     * handles key presses
     *
     * @param i actor ID
     * @param s action
     */
    public void process(int i, String s) {
        SpaceActor actor = actors.get(i);


        if (actor != null) {
            /*if(actor instanceof spaceshipActor) {*/

            if (!(actor instanceof server.EnergyActor)) {


                if (s.equals("upPressed")) {
                    //actor.thrust();
                    actor.setAcceleration(2);
                    actor.setDeceleration(0);
                } else if (s.equals("upReleased")) {
                    actor.setAcceleration(0);
                    actor.setDeceleration(.05);
                }

                if (s.equals("leftPressed")) actor.turnLeft = true;
                if (s.equals("leftReleased")) actor.turnLeft = false;

                if (s.equals("rightPressed")) actor.turnRight = true;
                if (s.equals("rightReleased")) actor.turnRight = false;

                if (actor instanceof server.GunnerActor) {
                    if (s.equals("shootPressed")) ((server.GunnerActor) actor).fire = true;
                    if (s.equals("shootReleased")) ((server.GunnerActor) actor).fire = false;
                }
            }
            else if (actor instanceof server.EnergyActor) {

                if (s.equals("leftPressed")) ((EnergyActor) actor).subtractEnergy();
                if (s.equals("rightPressed")) ((EnergyActor) actor).addEnergy();
            }
            actor.lastAction = s;

        }


    }

    public void join(int i) {


        if (i % 3 == 1) {
            int x = (int) (Math.random() * 700) + 50;
            int y = (int) (Math.random() * 500) + 50;
            Ship ship = new server.Ship();
            ships.put(i, ship);


            SpaceActor pilot = new spaceshipActor(x, y, 0, 0, i);
            world.addObject(pilot, x, y);

            actors.put(i, pilot);
            ships.get(i).setPilot(pilot);


 /*           SpaceActor energyActor = new server.EnergyActor(5);
            world.addObject(energyActor, 20, 50);

            actors.put(i, energyActor);
            ships.get(i).setEnergyActor(energyActor);*/
        }
        if (i % 3 == 2) {
            SpaceActor gunnerActor = new server.GunnerActor(actors.get(i - 1).getX(), actors.get(i - 1).getY(), 0, 0, (spaceshipActor) actors.get(i - 1));
            world.addObject(gunnerActor, actors.get(i - 1).getX(), actors.get(i - 1).getY());

            actors.put(i, gunnerActor);
            ships.get(i - 1).setGunner(gunnerActor);
        }
        if (i % 3 == 0 && i != 0) {
            SpaceActor energyActor = new server.EnergyActor(5);
            world.addObject(energyActor, 20, 50);

            actors.put(i, energyActor);
            ships.get(i - 2).setEnergyActor(energyActor);
        }


        //world.addObject(new server.Asteroid(0,10),(int) (Math.random() * 700) + 50,(int) (Math.random() * 500) + 50);


    }

    public void leave(int i) {
        Actor actor = actors.get(i);
        if (null != actor) {
            world.removeObject(actor);
        }
    }

    @Override
    public void init() {
    }
}
