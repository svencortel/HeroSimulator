import java.util.Random;
import java.io.IOException;

public class ItemFindEvent extends Event
{
	Random ranGenerator = new Random();

	public ItemFindEvent(Hero hero)
	{
		int result = ranGenerator.nextInt(101)%100;

		Item newItem = null;

		try
		{
			newItem = ResourceManager.getRandomItem();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		hero.addItemToInventory(newItem);

		generateOutput(result, hero, newItem);
	}

	public ItemFindEvent(Item item, Hero hero)
	{
		
	}

	private void generateOutput(int result, Hero hero, Item item)
	{
		super.outputString = "I found " + item.getName() + ". How lucky of me!\n";
		//super.outputString += item + "\n";
		super.outputString += "Current items: " + hero.getEntireInventoryString();
		
	}
}