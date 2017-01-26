public class Event
{
	protected String[] characters;
	protected String outputString;
	private static final String[][] peopleNames;
	private static final String[] animalNames;
	private static final String[][] creatureNames;
	private static final String[] plantNames;

	static {
		peopleNames = new String[2][];
		peopleNames[0] = new String[]{"Alexandra", "Dana", "Geanina", "Beatrice", "Camelia", "Georgiana"};
		peopleNames[1] = new String[]{"Sven", "Vlad", "John Latham", "Bogdan", "Mihai", "Sebastian", "George", "Vasile"};
		animalNames = new String[]{"Max", "Daniela", "Tom", "Joiana", "Fluffy", "Rex"};
		creatureNames = new String[2][];
		creatureNames[0] = new String[]{"cat", "goat", "sheep", "cow", "hen"};
		creatureNames[1] = new String[]{"dog", "tyrannosaurus rekt", "horse", "cock", "bull"};
		plantNames = new String[]{"daisy", "rose", "Jack Daniel's", "oak", "fosciculus fungis", "mushroom", "weed"};
	}

	public boolean contains(String[] container, String element)
	{
		for(int i=0;i<container.length;i++)
			if(container[i].equals(element))
				return true;
		return false;
	}

	public String[] getCharacters()
	{
		return characters;
	}

	public static String[][] getPeopleNames()
	{
		return peopleNames;
	}

	public static String[] getAnimalNames()
	{
		return animalNames;
	}
	
	public static String[][] getCreatureNames()
	{
		return creatureNames;
	}

	public static String[] getPlantNames()
	{
		return plantNames;
	}

	public String toString()
	{
		return outputString;
	}

}