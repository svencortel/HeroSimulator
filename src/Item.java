public class Item
{
	public static final byte POTION = 100;
	public static final byte ARMOR_HEAD = 101;
	public static final byte ARMOR_CHEST = 102;
	public static final byte ARMOR_HANDS = 103;
	public static final byte ARMOR_LEGS = 104;
	public static final byte ARMOR_FEET = 105;
	public static final byte WEAPON = 106;
	public static final byte ACCESSORY = 107;

	public static final byte ADDITIONAL_HP_STAT = 0;
	public static final byte REGENERATE_HP_STAT = 1;
	public static final byte RESISTANCE_STAT = 2;

	private String name;
	private byte type;
	private int health_plus;
	private int health_regen;
	private int resistance;

	public Item(String givenName, byte givenType, int[] stats)
	{
		name = givenName;
		type = givenType;
		health_plus = stats[ADDITIONAL_HP_STAT];
		health_regen = stats[REGENERATE_HP_STAT];
		resistance = stats[RESISTANCE_STAT];
	}

	public String getName()
	{
		return name;
	}

	public byte getType()
	{
		return type;
	}

	public int[] getStats()
	{
		return new int[]{health_plus, health_regen, resistance};
	}
}