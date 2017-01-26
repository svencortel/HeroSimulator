import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

public class HeroSimulator
{
	public static void main(String[] args) 
	{
		System.out.println(System.getProperty("user.dir"));
		Scanner user_input = new Scanner(System.in);

		System.out.println("Enter your character name:");
		String name = user_input.next();

		Hero mainHero = new Hero(name, 100);

		while(mainHero.getHealth()>0)
		{
			Random ranGen = new Random();
			Event miscEvent = new MiscellaneousEvent(mainHero);

			try{
			int nr_sec = 2;//ranGen.nextInt(9)+2;
			TimeUnit.SECONDS.sleep(nr_sec);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}

			System.out.println(miscEvent);
		}
	}
}