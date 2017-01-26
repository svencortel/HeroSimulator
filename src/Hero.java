import java.util.List;
import java.util.ArrayList;

public class Hero
{
	private String name;
	private int health;
	private List<Item> itemList;

	public Hero(String givenName, int givenHealth)
	{
		name = givenName;
		health = givenHealth;
		itemList = new ArrayList<Item>();
	}

	public String getName()
	{
		return name;
	}

	public int getHealth()
	{
		return health;
	}

	public void regenHealth(int amount)
	{
		health += amount;
	}

	public void loseHealth(int amount)
	{
		health -= amount;
		if(health<0)
			health = 0;
	}

	public void addItemToInventory(Item item)
	{
		itemList.add(item);
	}

	public Item getInventoryItemAtIndex(int i)
	{
		if(i>=itemList.size() || i<0)
		{
			/*System.out.println("IndexOutOfBounds: Tried to access item "+
				i+" in inventory. Inventory size:"+itemList.size());
			System.exit(-1);*/

			return null;
		}

		return itemList.get(i);
	}

	public int removeInventoryItemAtIndex(int i)
	{
		if(i>=itemList.size() || i<0)
		{
			/*System.out.println("IndexOutOfBounds: Tried to access item "+
				i+" in inventory. Inventory size:"+itemList.size());
			System.exit(-1);*/

			return -1;
		}

		itemList.remove(i);
		return 0;
	}
}