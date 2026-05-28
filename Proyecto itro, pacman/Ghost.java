import greenfoot.*;

public class Ghost extends Actor
{
    public void act()
    {
        followPacman();
        touchPacman();
    }

    public void followPacman()
    {
        Actor pacman = getWorld().getObjects(Pacman.class).get(0);

        turnTowards(pacman.getX(), pacman.getY());

        move(2);
    }

    public void touchPacman()
    {
        Actor pacman = getOneIntersectingObject(Pacman.class);

        if(pacman != null)
        {
            Greenfoot.stop();
        }
    }
}
