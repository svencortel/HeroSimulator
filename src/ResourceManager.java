import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public final class ResourceManager
{

	public static Item getRandomItem() throws IOException
	{
		Random ranGenerator = new Random();

		int result = ranGenerator.nextInt(2);
		String item_folder = "";
		Item foundItem = null;

		if(result<1)
		{
			return getPotion(ranGenerator.nextInt(1000));
		}
		else
		{
			return getArmor(ranGenerator.nextInt(1000));
		}

	}

	public static Potion getPotion(int i) throws IOException
	{
		Path path = Paths.get("../Resources/files/Items/Potion.txt");
		//path = Paths.get(path.toUri().toString(), "Resources", "files", "Items", "Potion.txt");

		long lineCount = 0;

		try(Stream<String> stream = Files.lines(path))
		{
			lineCount = stream.count();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

		int actual_index = (int)(i % lineCount);
		int reminder_index = actual_index+1;

		int[] stats = new int[]{0, 0, 0};

		List<String> lines = Files.readAllLines(path);

		if(lines.get(actual_index).substring(0,1).equals("-"))
		{
			actual_index --;
		}
		String potion_name = lines.get(actual_index);
		actual_index ++;

		
		String buff_name = lines.get(actual_index).substring(1,lines.get(actual_index).indexOf('='));
		switch(buff_name)
		{
			case "health_regen": stats[1] = Integer.parseInt(lines.get(actual_index).
				substring(lines.get(actual_index).indexOf('=')+2,lines.get(actual_index).length()-1));
								break;
			case "resistance": stats[2] = Integer.parseInt(lines.get(actual_index).
				substring(lines.get(actual_index).indexOf('=')+2,lines.get(actual_index).length()-1));
								break;
			default: System.out.println("wtf: "+buff_name+", "+actual_index);
					break;
		}
	

		return new Potion(potion_name, stats);
		
	}

	public static Potion getPotion(String potionName)
	{
		return null;
	}

	public static Armor getArmor(int i) throws IOException
	{
		Path path = Paths.get("../Resources/files/Items/Armor.txt");
		//path = Paths.get(path.toUri().toString(), "Resources", "files", "Items", "Potion.txt");

		long lineCount = 0;

		try(Stream<String> stream = Files.lines(path))
		{
			lineCount = stream.count();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

		int actual_index = (int)(i % lineCount);
		int reminder_index = actual_index+1;

		int[] stats = new int[]{0, 0, 0};
		byte armor_type = 0;

		List<String> lines = Files.readAllLines(path);

		if(lines.get(actual_index).substring(0,1).equals("-"))
		{
			actual_index --;
		}
		else if(lines.get(actual_index).substring(0,1).equals("/"))
		{
			actual_index ++;
		}

		String armor_name = lines.get(actual_index);
		actual_index ++;
		
		String buff_name = lines.get(actual_index).substring(1,lines.get(actual_index).indexOf('='));
		switch(buff_name)
		{
			case "health_regen": stats[1] = Integer.parseInt(lines.get(actual_index).
				substring(lines.get(actual_index).indexOf('=')+2,lines.get(actual_index).length()-1));
								break;
			case "resistance": stats[2] = Integer.parseInt(lines.get(actual_index).
				substring(lines.get(actual_index).indexOf('=')+2,lines.get(actual_index).length()-1));
								break;
			default: System.out.println("wtf: "+buff_name+", "+actual_index);
					break;
		}

		while(!lines.get(actual_index).substring(0,1).equals("/"))
			actual_index --;

		switch(lines.get(actual_index))
		{
			case "/HEAD/": armor_type = Item.ARMOR_HEAD; break;
			case "/CHEST/": armor_type = Item.ARMOR_CHEST; break;
			case "/HANDS/": armor_type = Item.ARMOR_HANDS; break;
			case "/LEGS/": armor_type = Item.ARMOR_LEGS; break;
			case "/FEET/": armor_type = Item.ARMOR_FEET; break;
			default: System.out.println("wtf: "+lines.get(actual_index)+", "+actual_index);
					break;
		}

		return new Armor(armor_name, armor_type, stats);

	}

	public static Armor getArmor(String armorName)
	{
		return null;
	}

}