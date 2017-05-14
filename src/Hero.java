import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Hero
{
	/*
	CHANGE THIS CLASS (IMPLEMENT THE HASH WITH ITEM)
	*/
	private String name;
	private int health;
	//private List<Item> itemList;
	private HashMap<Item, Integer> itemList;

	public Hero(String givenName, int givenHealth)
	{
		name = givenName;
		health = givenHealth;
		itemList = new HashMap<Item, Integer>();
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
		addItemsToInventory(item, 1);
	}

	public void addItemsToInventory(Item item, int quantity)
	{
		if( itemList.containsKey(item) )
			itemList.put(item, new Integer( itemList.get(item).intValue() + quantity ));
		else
			itemList.put(item, new Integer(quantity));
	}

	public int removeItem(Item item)
	{
		return removeItems(item, 1);
	}

	public int removeItems(Item item, int quantity)
	{
		if( !itemList.containsKey(item) )
			return 0;
		
		else
		{
			if(quantity >= itemList.get(item).intValue())
			{
				itemList.remove(item);
				return 1;
			}
		
			else
			{
				itemList.put(item, new Integer( itemList.get(item).intValue() - quantity ));
				return 1;
			}
		}
	}

	public int removeItemByName(String name)
	{
		return removeItemsByName(name, 1);
	}

	public int removeItemsByName(String name, int quantity)
	{
		Item item = null;

		for(Item key : itemList.keySet())
		{
			if(key.getName() == name)
				{
					item = key;
					break;
				}
		}

		if(item == null)
			return 0;
		
		else
		{
			if(quantity >= itemList.get(item).intValue())
			{
				itemList.remove(item);
				return 1;
			}
		
			else
			{
				itemList.put(item, new Integer( itemList.get(item).intValue() - quantity ));
				return 1;
			}
		}
	}

/*
	public int removeItemsFromInventory(Item item, int quantity)
	{
		if( !itemList.containsKey(item.getName()) )
			return 0;
		
		else
		{ 
			if(quantity >= itemList.get(item.getName()).intValue())
			{
				itemList.remove(item.getName());
				return 1;
			}
		
			else
			{
				itemList.put(item.getName(), new Integer( itemList.get(item.getName()).intValue() - quantity ));
				return 1;
			}
		}
		
		return -1;
	}
*/

	public Item getInventoryItemByName(String name)
	{
		for(Item key : itemList.keySet())
		{
			if(key.getName() == name)
				return key;
		}

		return null;
	}
/*
	public int removeInventoryItemAtIndex(int i)
	{
		if(i>=itemList.size() || i<0)
		{

			return -1;
		}

		itemList.remove(i);
		return 0;
	}
*/

	public String getEntireInventoryString()
	{
		if(itemList.size() <= 0)
			return "Empty";

		String output = "[ ";

		Set<Map.Entry<Item, Integer>> set = itemList.entrySet();

		Iterator<Map.Entry<Item, Integer>> i = set.iterator();

		while(i.hasNext())
		{
			Map.Entry<Item, Integer> inventory_entry = i.next();

			output += inventory_entry.getKey().getName() + " x ";
			output += inventory_entry.getValue().intValue();
			if(i.hasNext())
				output += ", ";
		}

		return output + " ]\n";
	}
}