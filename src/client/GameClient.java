package client;

import mayflower.Actor;
import mayflower.net.Client;
import server.ActorID;
import server.GunnerActor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameClient extends Client implements GameMode, ActorID {
    private GameWorld world;
    private String tempProcess, tempAction = "";


    public GameClient() {
        this("localhost");
    }

    public GameClient(String ip) {
        System.out.println("Connecting");
        this.connect(ip, 1234);
        System.out.println("Connected");
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    /**
     * TODO move instead of remove
     * TODO add IDs to every actor
     *
     * @param s
     */
    @Override
    public void process(String s) {
        if (!s.equals(tempProcess)) {
            System.out.println("Message From Server: " + s);

            List<Actor> actors = new LinkedList<Actor>();
            ArrayList<String> parts = new ArrayList<>(Arrays.asList(s.split(":")));
            //System.out.println("parts.size() = " + parts.size());

            for (String part : parts) {
                if (!"".equals(part)) {

                    int x = 0;
                    int y = 0;
                    int r = 0;
                    double v = 0;
                    int ID = 0;

                    ArrayList<String> parts2 = new ArrayList<>(Arrays.asList(part.split(",")));
                    String img = "img/" + parts2.get(0) + ".png";
                    if (parts2.size() > 1)
                        x = Integer.parseInt(parts2.get(1));
                    if (parts2.size() > 2)
                        y = Integer.parseInt(parts2.get(2));
                    if (parts2.size() > 3)
                        r = Integer.parseInt(parts2.get(3));

                    if (parts2.size() > 4)
                        v = Double.parseDouble(parts2.get(4));


                    if (parts2.size() > 5)
                        ID = Integer.parseInt(parts2.get(5));


                    switch (parts2.get(0)) {
                    /*case "spaceship":
                        actors.add(new spaceshipActor(x, y, r, (int) v));
                        break;
                    case "gunner":
                        actors.add(new GunnerActor(x, y, r, v, (server.spaceshipActor) ActorID.actors.get(ID)));
                        break;
                    case "energy":
                        actors.add(new EnergyActor(x, y, r));
                        break;*/
                        case "asteroid":
                            actors.add(new Asteroid(x, y, r, (int) v));
                            break;
                        case "laser":
                            actors.add(new Laser(x, y, r));
                            break;
                        case "ship":
                            actors.add(new spaceshipActor(x, y, r));
                            actors.add(new client.GunnerActor(x, y, Integer.parseInt(parts2.get(4))));
                            actors.add(new EnergyActor(Integer.parseInt(parts2.get(5))));
                            break;


                    }
                }

            }
            if (null != world) {
                world.update(actors);
            }
        }
        tempProcess = s;

    }

    @Override
    public void onDisconnect(String s) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnect() {
        System.out.println("Connected to server!");
    }

    @Override
    public void processPress(String action) {

        if (action != tempAction) {
            send(action + "Pressed");
            System.out.println("Sending Press: " + action + "Pressed");
        }

        tempAction = action;
    }

    @Override
    public void processRelease(String action) {
        System.out.println("tempAction = " + tempAction);

        if (action != tempAction) {
            send(action + "Released");
            System.out.println("Sending Release: " + action + "Released");
        }

        tempAction = action;

    }

    @Override
    public void processKey(String action) {

        if (!action.equals(tempAction)) {
            send(action);
            //System.out.println("tempAction = " + tempAction);
            System.out.println("Sending: " + action);
        }

        tempAction = action;

    }
}
