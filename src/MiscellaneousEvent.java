import java.util.Random;

public class MiscellaneousEvent extends Event
{

	public MiscellaneousEvent(Hero hero)
	{
		Random ranGenerator = new Random();
		int result = ranGenerator.nextInt(101) % 100;
		
		generateOutput(result, hero);

		super.outputString = super.outputString + "(" + result + ")";
	}

	private void generateOutput(int result, Hero hero)
	{
		Random ranGenerator = new Random();
		String[] vowels = new String[]{"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};

		if(result<25)
		{
			int gender = ranGenerator.nextInt(2);

			String creatureName = super.getCreatureNames()[gender]
				[ranGenerator.nextInt(super.getCreatureNames()[gender].length)];
			
			String animalName = super.
				getAnimalNames()[ranGenerator.nextInt(super.getAnimalNames().length)];
			
			super.outputString = "I met "+
			(contains(vowels,creatureName.substring(0,1)) ? "an" : "a")+
			" "+creatureName+". "+ (gender==0 ? "Her" : "His") +" name was "+animalName+". Was.";
		}
		else if(result<50)
		{
			super.outputString = "Sometimes I wonder if there is someone monitoring my actions.";
		}
		else if(result<75)
		{
			int gender = ranGenerator.nextInt(2);

			String personName = super.getPeopleNames()[gender]
				[ranGenerator.nextInt(super.getPeopleNames()[gender].length)];

			String plantName = super.
				getPlantNames()[ranGenerator.nextInt(super.getPlantNames().length)];

			super.outputString = personName +
			" was holding "+(contains(vowels,plantName.substring(0,1)) ? "an" : "a") +
			" "+ plantName + " while screeching autistically because someone had messed up " +
			(gender == 0 ? "her" : "his") + " collection.\nPoor "+ 
			(gender == 0 ? "girl" : "guy")+".";
		}
		else
		{
			int gender = ranGenerator.nextInt(2);

			String personName = super.getPeopleNames()[gender]
				[ranGenerator.nextInt(super.getPeopleNames()[gender].length)];

			if(ranGenerator.nextInt(10)<5)
				super.outputString = personName + " just told me \"Fuck you, "+hero.getName()+"\".";
			else
			{
				String personName2 = super.getPeopleNames()[gender]
					[ranGenerator.nextInt(super.getPeopleNames()[gender].length)];

				while(personName.equals(personName2) || personName2.equals(hero.getName()))
					personName2 = super.getPeopleNames()[gender]
					[ranGenerator.nextInt(super.getPeopleNames()[gender].length)];

				super.outputString = personName + " just told me \"Fuck you, "+personName2+"\".";
				super.outputString += " I think "+(gender == 0 ? "she" : "he") +
										" mistook me for someone else.";

			}
		}
	}
}