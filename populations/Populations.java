/**
 *  Program 1c
 *  WorldCityPopulations prints the population of various cities in the world. 
 *  CS108-3
 *  September 9,2018
 *  Drake Nguyen
  */
public class Populations {
	public static void main(String[] args)
	{
		printHeader();
		printStats(getCities(),getPopulations());
	}
	public String getIdentificationString()
	{
		return "Program 1c, Drake Nguyen";
	}
	/**
	 * 
	 * @returns 2D array with the population numbers
	 */
	public static double[][] getPopulations()
	{
		double[][] popArray = {
					{24153000,1384688986},
					{18590000,1384688986},
					{18000000,207862518},
					{14657000,81257239},
					{14543000,162951560},
					{13617000,126168156},
					{13197596,143964513},
					{12877000,105920222},
					{12784000,1384688986},
					{12400000,1296834042},
					{12038000,207652865},
					{11908000,1384688986},
					{11548000,1384688986},
					{11035000,1296834042},
					{10608000,1384688986},
					{10355000,207862518},
					{10290000,50791919},
					{10152000,1384688986},
					{10125000,86300000},
					{9752000,31773839},
		};
		return popArray;
	}
	/**
	 * 
	 * @returns 1D array with the names of cities
	 */
	public static String[] getCities()
	{
		String[] cityArray = {
				"Shanghai,China",
				"BEIJING,China",
				"Karachi,Pakistan",
				"Istanbul,Turkey",
				"DHAKA,Bangladesh",
				"TOKYO,Japan",
				"MOSCOW,Russia",
				"MANILA,Philippines",
				"Tianjin,China",
				"Mumbai,India",
				"Sao Paulo,Brazil",
				"Shenzhen,China",
				"Guangzhou,China",
				"DELHI,India",
				"Wuhan,China",
				"Lahore,Pakistan",
				"Seoul,South Korea",
				"Chengdu,China",
				"KINSHASA,Congo D.R.",
				"LIMA,Peru",
		};
		return cityArray;
	}
	/**
	 * prints table column header
	 */
	public static void printHeader()
	{
		System.out.printf("%-15s%-17s%10s%12s%3s\n", "City", "Country", "Population", "Percent","");
		System.out.println(repeat('-',54));
	}
	/**
	 * 
	 * @param ch
	 * @param numOfCharsInString
	 * @returns String with ch the length of param numOfCharsInString
	 */
	public static String repeat(char ch, int numOfCharsInString)
	{
		String ret = "";
		for(int i = 0; i < numOfCharsInString; i++)
		{
			//replace minus sign with em dash
			if(ch == '-') {
				ch = '\u2014';
			}
			//otherwise, all chars remain the same
			ret += ch;
		}
		return ret;
	}
	/**
	 * prints city and population data, calculating the percentage of country population living in the city
	 * @param cities
	 * @param population
	 */
	public static void printStats(String[] cities, double[][] population)
	{
		for(int i = 0; i < population.length; i++)
		{	
			if(population[i][0] > 10000000) {
			//calculate percentage
			double percentage = (population[i][0]/population[i][1])*100;
			//separate city and country by , to correctly put into responding column	
			String[] sep = cities[i].split(",");
			System.out.format("%-15s%-17s%,10.0f%12.3f\n", sep[0],sep[1],population[i][0],percentage);
		}
			else {
				break;
			}
		}
	}
}
