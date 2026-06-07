import greenfoot.*;

public class MyWorld extends World
{
    private String[] mapa = {
        "XXXXXXXXXXXXXXX",
        "X.............X",
        "X.XXX.X.X.XXX.X",
        "X.............X",
        "X.X.X.XXX.X.X.X",
        "X.X.X.....X.X.X",
        "X.X.X.XXX.X.X.X",
        "X.............X",
        "X.XXX.X.X.XXX.X",
        "XXXXXXXXXXXXXXX"
    };

    public MyWorld()
    {    
        super(600, 400, 1);
        setBackground("space_background.png");

        construirLaberinto();

        Pacman pacman = new Pacman();
        addObject(pacman, 300, 220);

        Ghost ghost = new Ghost();
        addObject(ghost, 60, 60);

        // Colocar comida SOLO en celdas marcadas con "." en el mapa
        int colocadas = 0;
        int intentos = 0;
        while(colocadas < 10 && intentos < 300)
        {
            intentos++;
            int col = Greenfoot.getRandomNumber(15);
            int fila = Greenfoot.getRandomNumber(10);

            if(mapa[fila].charAt(col) == '.')
            {
                int x = col * 40 + 20;
                int y = fila * 40 + 20;

                // Evitar duplicar comida en una misma celda
                if(getObjectsAt(x, y, food.class).isEmpty())
                {
                    food comida = new food();
                    addObject(comida, x, y);
                    colocadas++;
                }
            }
        }
    }

    public void construirLaberinto()
    {
        for(int fila = 0; fila < mapa.length; fila++)
        {
            for(int col = 0; col < mapa[fila].length(); col++)
            {
                if(mapa[fila].charAt(col) == 'X')
                {
                    Wall pared = new Wall();
                    addObject(pared, col * 40 + 20, fila * 40 + 20);
                }
            }
        }
    }
}