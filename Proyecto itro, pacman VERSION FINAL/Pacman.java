import greenfoot.*;

public class Pacman extends Actor
{
    public Pacman()
    {
        GreenfootImage imagen = getImage();
        imagen.scale(28, 28);
        setImage(imagen);
    }

    public void act()
    {
        movement();
        eatFood();
    }

    public void movement()
    {
        int oldX = getX();
        int oldY = getY();

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

        if(getOneIntersectingObject(Wall.class) != null)
        {
            setLocation(oldX, oldY);
        }
    }

    public void eatFood()
    {
        Actor comida = getOneIntersectingObject(food.class);

        if(comida != null)
        {
            getWorld().removeObject(comida);

            if(getWorld().getObjects(food.class).isEmpty())
            {
                getWorld().showText("¡GANASTE!", 300, 200);
                Greenfoot.stop();
            }
        }
    }
}