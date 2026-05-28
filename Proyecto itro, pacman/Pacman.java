import greenfoot.*;

public class Pacman extends Actor
{
    public void act()
    {
        movement();
        eatFood();
    }

    public void movement()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 4, getY());
        }

        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 4, getY());
        }

        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 4);
        }

        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 4);
        }
    }

    public void eatFood()
    {
        Actor comida = getOneIntersectingObject(food.class);

        if(comida != null)
        {
            getWorld().removeObject(comida);
        }
    }
}
