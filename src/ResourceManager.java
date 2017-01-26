import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Stream;

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
		Path path = Paths.get(".").getParent();
		path = Paths.get(path.toUri().toString(), "Resources", "files", "Items", "Potion.txt");

		long lineCount = 0;

		try(Stream<String> stream = Files.lines(path))
		{
			lineCount = stream.count();
		}

		int actual_index = (int)(i % lineCount);
		int reminder_index = actual_index+1;

		int[] stats = new int[3];

		List<String> lines = Files.readAllLines(path);

		while(lines[actual_index].substring(0,1).equals("-"))
		{
			String buff_name = lines[actual_index].substring(1,lines[actual_index].indexOf('='));
			switch(buff_name)
			{
				case "health_regen": stats[1] = Integer.parseInt(lines[actual_index].
					substring(lines[actual_index].indexOf('='),lines[actual_index].length()));
									break;
				case "resistance": stats[2] = Integer.parseInt(lines[actual_index].
					substring(lines[actual_index].indexOf('='),lines[actual_index].length()));
									break;
				default: System.out.println("wtf: "+buff_name+", "+actual_index);
						break;
			}
			actual_index--;
		}

		String potion_name = lines[actual_index];
		actual_index = reminder_index;

		while(lines[actual_index].substring(0,1).equals("-"))
		{
			String buff_name = lines[actual_index].substring(1,lines[actual_index].indexOf('='));
			switch(buff_name)
			{
				case "health_regen": stats[1] = Integer.parseInt(lines[actual_index].
					substring(lines[actual_index].indexOf('='),lines[actual_index].length()));
									break;
				case "resistance": stats[2] = Integer.parseInt(lines[actual_index].
					substring(lines[actual_index].indexOf('='),lines[actual_index].length()));
									break;
				default: System.out.println("wtf: "+buff_name+", "+actual_index);
						break;
			}
			actual_index++;
		}

		return new Potion(potion_name, stats);

		/*
		File dir = new File(".");
		File potions_file = new File(dir.getParentFile().getCanonicalPath() +
									 File.separator + "Resources" + File.separator +
									 "files" + File.separator + "Items" + 
									 File.separator + "Potion.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(potions_file)));

		String line = null;
		while((line = br.readLine()) != null || i<0)
		{

		}
		*/
	}

	public static Potion getPotion(String potionName)
	{
		return null;
	}

	public static Armor getArmor(int i) throws IOException
	{
		/*
		File dir = new File(".");
		File armors_file = new File(dir.getParentFile().getCanonicalPath() +
									 File.separator + "Resources" + File.separator +
									 "files" + File.separator + "Items" + 
									 File.separator + "Armor.txt");
		*/
		return null;

	}

	public static Armor getArmor(String armorName)
	{
		return null;
	}

}