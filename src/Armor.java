public class Armor extends Item
{

	public Armor(String givenName, byte type, int[] stats)
	{
		super(givenName, type, stats);
		if(type < 101 || type > 105)
		{
			System.out.println("Armor type incorrect for "+ givenName +": "+type);
			System.exit(-1);
		}
	}

}