import greenfoot.*;

public class Ghost extends Actor
{
    private int velX = 2;
    private int velY = 0;

    public Ghost()
    {
        GreenfootImage imagen = getImage();
        imagen.scale(28, 28);
        setImage(imagen);
    }

    public void act()
    {
        elegirMejorDireccion();
        intentarMover();
        touchPacman();
    }

    private void intentarMover()
    {
        int oldX = getX();
        int oldY = getY();
        setLocation(oldX + velX, oldY + velY);
        if(getOneIntersectingObject(Wall.class) != null)
        {
            setLocation(oldX, oldY);
        }
    }

    private void elegirMejorDireccion()
    {
        Actor pacman = getWorld().getObjects(Pacman.class).get(0);
        int dx = pacman.getX() - getX();
        int dy = pacman.getY() - getY();

        int dirH = dx >= 0 ? 2 : -2;
        int dirV = dy >= 0 ? 2 : -2;

        // 4 direcciones ordenadas: primero hacia Pacman, luego alternativas
        int[][] direcciones;
        if(Math.abs(dx) > Math.abs(dy))
        {
            direcciones = new int[][]{ {dirH, 0}, {0, dirV}, {0, -dirV}, {-dirH, 0} };
        }
        else
        {
            direcciones = new int[][]{ {0, dirV}, {dirH, 0}, {-dirH, 0}, {0, -dirV} };
        }

        // Probar cada una hasta encontrar una sin pared
        int oldX = getX();
        int oldY = getY();
        for(int[] d : direcciones)
        {
            setLocation(oldX + d[0], oldY + d[1]);
            if(getOneIntersectingObject(Wall.class) == null)
            {
                setLocation(oldX, oldY);
                velX = d[0];
                velY = d[1];
                return;
            }
            setLocation(oldX, oldY);
        }
        velX = 0;
        velY = 0;
    }

    public void touchPacman()
    {
        Actor pacman = getOneIntersectingObject(Pacman.class);
        if(pacman != null)
        {
            getWorld().showText("GAME OVER", 300, 200);
            Greenfoot.stop();
        }
    }
}

