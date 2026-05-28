import greenfoot.*;

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1);

        Pacman pacman = new Pacman();
        addObject(pacman, 300, 200);

        Ghost ghost = new Ghost();
        addObject(ghost, 100, 100);

        for(int i = 0; i < 10; i++)
        {
            food comida = new food();

            addObject(comida,
                Greenfoot.getRandomNumber(600),
                Greenfoot.getRandomNumber(400));
        }
    }
}
