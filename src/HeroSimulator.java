import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class HeroSimulator
{
	public static void main(String[] args) 
	{
		System.out.println(System.getProperty("user.dir"));
		Path path = Paths.get("../Resources/files/Items/Potion.txt");

		System.out.println(path.toAbsolutePath());

		Scanner user_input = new Scanner(System.in);

		System.out.println("Enter your character name:");
		String name = user_input.next();

		Hero mainHero = new Hero(name, 100);
		Random ranGen = new Random();

		while(mainHero.getHealth()>0)
		{
			try
			{
				int nr_sec = 2;//ranGen.nextInt(9)+2;
				TimeUnit.SECONDS.sleep(nr_sec);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			
			int outcome = ranGen.nextInt(2);

			if(outcome<1)
			{
				Event miscEvent = new MiscellaneousEvent(mainHero);

				System.out.println(miscEvent);
			}
			else {
				Event randomItemFindEvent = new ItemFindEvent(mainHero);

				System.out.println(randomItemFindEvent);
			}
		}
	}
}