
package ProjectGUI;
import com.pmstation.spss.DataConstants;
import com.pmstation.spss.MissingValue;
import com.pmstation.spss.SPSSWriter;
import com.pmstation.spss.ValueLabels;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author owen
 */
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ExportData {
    
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd-HH-mm-ss";
    private static String dbURL = "jdbc:derby://localhost:1527/sidresDB;create=true;user=sidresAdmin;password=1x!Software";
    private static String tableName;
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    // Entrance point
  public static void export() {
    try{
      // Open file output stream with filename args[0]
      OutputStream out = new FileOutputStream("data" + now() + ".sav");

      // Assign SPSS output to the file
      SPSSWriter outSPSS = new SPSSWriter(out, "utf-8");

      // Creating SPSS variable description table
      outSPSS.setCalculateNumberOfCases(false);
      outSPSS.addDictionarySection(-1);

      // Describing varible names and types
      outSPSS.addStringVar("continent", 255, "Continents of the world");
      outSPSS.addNumericVar("size", 8, 2, "Sq km");
      outSPSS.addNumericVar("population", 8, 2, "Population");

      // Create missing value
      MissingValue mv = new MissingValue();
      mv.setOneDescreteMissingValue(1);
      outSPSS.addNumericVar("countries", 8, 2, "Number of countries", mv);

      outSPSS.addDateVar("update", DataConstants.DATE_TYPE_17, "Date of last update", null);

      // Create value labels
      ValueLabels valueLabels = new ValueLabels();
      valueLabels.putLabel("Asia", "Asia Continent");
      valueLabels.putLabel("America", "America Continent");
      outSPSS.addValueLabels(1, valueLabels);

      valueLabels = new ValueLabels();
      valueLabels.putLabel(0, "No Countries");
      valueLabels.putLabel(23, "Twenty Three Countries");
      outSPSS.addValueLabels(4, valueLabels);

      outSPSS.addStringVar("description", 2200, "Description");

      // Create SPSS variable value define table
      outSPSS.addDataSection();

      // Add values for all defined variables
      outSPSS.addData("Asia");
      outSPSS.addData(new Long(44579000L));
      outSPSS.addData(new Long(3674000000L));
      outSPSS.addData(new Long(44));
      outSPSS.addData(new Date());
      outSPSS.addData("Asia is the world's largest and most populous continent, located primarily in the eastern and northern hemispheres. It covers 8.7% of the Earth's total surface area (or 30% of its land area) and with approximately 3.879 billion people, it hosts 60% of the world's current human population. During the 20th century Asia's population nearly quadrupled.[3] Asia is defined according to similar definitions presented by the Encyclop?dia Britannica[4] and the National Geographic Society[5] as 4/5 of the landmass of Eurasia – with the western portion of the latter occupied by Europe – located to the east of the Suez Canal, east of the Ural Mountains and south of the Caucasus Mountains (or the Kuma-Manych Depression) and the Caspian and Black Seas. It is bounded on the east by the Pacific Ocean, on the south by the Indian Ocean and on the north by the Arctic Ocean. It contains one country in the Mediterranean Sea - Cyprus. Given its size and diversity, Asia – a toponym dating back to classical antiquity – is more a cultural concept incorporating diverse regions and peoples than a homogeneous physical entity[6] Asia differs very widely among and within its regions with regard to ethnic groups, cultures, environments, economics, historical ties and government systems.");

      outSPSS.addData("Africa");
      outSPSS.addData(new Long(30065000L));
      outSPSS.addData(new Long(778000000L));
      outSPSS.addData(new Long(53));
      outSPSS.addData((Date) null);
      outSPSS.addData("Africa is the world's second largest and second most populous continent, after Asia. At about 30.2 million km? (11.7 million sq mi) including adjacent islands, it covers 6% of the Earth's total surface area and 20.4% of the total land area.[2] With 1.0 billion people (as of 2009, see table) in 65 territories (including 54 recognized states), it accounts for about 14.72% of the world's human population. The continent is surrounded by the Mediterranean Sea to the north, both the Suez Canal and the Red Sea along the Sinai Peninsula to the northeast, the Indian Ocean to the southeast, and the Atlantic Ocean to the west. The continent includes Madagascar and various archipelagoes and has 54 sovereign states (countries) and two states with limited recognition.");

      outSPSS.addData("North America");
      outSPSS.addData(new Long(24256000L));
      outSPSS.addData(new Long(483000000L));
      outSPSS.addData(new Long(23));
      outSPSS.addData(new Date());
      outSPSS.addData("North America (Spanish: America del Norte or Norteamerica; French: Amerique du Nord; Dutch: Noord-Amerika; Papiamento: Nort Amerika; Kalaallisut: Amerika Avannarleq) is a continent wholly within the Northern Hemisphere and almost wholly within the Western Hemisphere. It is also considered a northern subcontinent of the Americas.[2] It is bordered to the north by the Arctic Ocean, to the east by the Atlantic Ocean, to the southeast by South America, and to the west and south by the Pacific Ocean. North America covers an area of about 24,709,000 square kilometers (9,540,000 square miles), about 4.8% of the planet's surface or about 16.5% of its land area. As of July 2008, its population was estimated at nearly 529 million people. It is the third-largest continent in area, following Asia and Africa, and the fourth in population after Asia, Africa, and Europe.");

      outSPSS.addData("South America");
      outSPSS.addData(new Long(17819000L));
      outSPSS.addData(new Long(342000000L));
      outSPSS.addData(new Long(12));
      outSPSS.addData((Date) null);
      outSPSS.addData("South America (Spanish: America del Sur, Sudamerica, or Suramerica; Portuguese: America do Sul; Quechua and Aymara: Urin Awya Yala; Guarani: Nembyamerika; Dutch: Zuid-Amerika; French: Amerique du Sud) is a continent situated in the Western Hemisphere, mostly in the Southern Hemisphere, with a relatively small portion in the Northern Hemisphere. The continent is also considered a subcontinent of the Americas.[2][3] It is bordered on the west by the Pacific Ocean and on the north and east by the Atlantic Ocean; North America and the Caribbean Sea lie to the northwest. It includes twelve independent countries—Argentina, Bolivia, Brazil, Chile, Colombia, Ecuador, Guyana, Paraguay, Peru, Suriname, Uruguay, and Venezuela—and French Guiana, which is an overseas region of France. The South American countries that border the Caribbean Sea—Colombia, Venezuela, Guyana, Suriname, and French Guiana—are also known as Caribbean South America. South America has an area of 17,840,000 square kilometers (6,890,000 sq mi). Its population as of 2005 has been estimated at more than 371,090,000. South America ranks fourth in area (after Asia, Africa, and North America) and fifth in population (after Asia, Africa, Europe, and North America). The word America was coined in 1507 by cartographers Martin Waldseemuller and Matthias Ringmann, after Amerigo Vespucci, who was the first European to suggest that the lands newly discovered by Europeans were not India, but a New World unknown to Europeans.");

      outSPSS.addData("Antarctica");
      outSPSS.addData(new Long(13209000L));
      outSPSS.addData(new Long(0));
      outSPSS.addData(new Long(0));
      outSPSS.addData(new Date());
      outSPSS.addData("Antarctica is Earth's southernmost continent, encapsulating the South Pole. It is situated in the Antarctic region of the Southern Hemisphere, almost entirely south of the Antarctic Circle, and is surrounded by the Southern Ocean. At 14.0 million km2 (5.4 million sq mi), it is the fifth-largest continent in area after Asia, Africa, North America, and South America. For comparison, Antarctica is nearly twice the size of Australia. About 98% of Antarctica is covered by ice that averages at least 1 mile (1.6 km) in thickness. Antarctica, on average, is the coldest, driest, and windiest continent, and has the highest average elevation of all the continents.[6] Antarctica is considered a desert, with annual precipitation of only 200 mm (8 inches) along the coast and far less inland.[7] The temperature in Antarctica has reached ?89 °C (?129 °F). There are no permanent human residents, but anywhere from 1,000 to 5,000 people reside throughout the year at the research stations scattered across the continent. Only cold-adapted organisms survive there, including many types of algae, animals (for example mites, nematodes, penguins, seals and tardigrades), bacteria, fungi, plants, and protista. Vegetation where it occurs is tundra. Although myths and speculation about a Terra Australis (Southern Land) date back to antiquity, the first confirmed sighting of the continent is commonly accepted to have occurred in 1820 by the Russian expedition of Fabian Gottlieb von Bellingshausen and Mikhail Lazarev. The continent, however, remained largely neglected for the rest of the 19th century because of its hostile environment, lack of resources, and isolation. The Antarctic Treaty was signed in 1959 by 12 countries; to date, 47 countries have signed the treaty. The treaty prohibits military activities and mineral mining, prohibits nuclear explosions and nuclear waste disposal, supports scientific research, and protects the continent's ecozone. Ongoing experiments are conducted by more than 4,000 scientists from many nations.");

      outSPSS.addData("Europe");
      outSPSS.addData(new Long(9938000L));
      outSPSS.addData(new Long(732000000L));
      outSPSS.addData(new Long(46));
      outSPSS.addData(new Date());
      outSPSS.addData("Europe is, by convention, one of the world's seven continents. It is also known as the old continent. Comprising the westernmost peninsula of Eurasia, Europe is generally 'divided' from Asia to its east by the watershed divides of the Ural and Caucasus Mountains, the Ural River, the Caspian and Black Seas, and the waterways connecting the Black and Aegean Seas.[2] Europe is bordered by the Arctic Ocean and other bodies of water to the north, the Atlantic Ocean to the west, the Mediterranean Sea to the south, and the Black Sea and connected waterways to the southeast. Yet the borders of Europe—a concept dating back to classical antiquity—are somewhat arbitrary, as the primarily physiographic term continent can incorporate cultural and political elements. Europe is the world's second-smallest continent by surface area, covering about 10,180,000 square kilometres (3,930,000 sq mi) or 2% of the Earth's surface and about 6.8% of its land area. Of Europe's approximately 50 states, Russia is the largest by both area and population (although the country has territory in both Europe and Asia), while the Vatican City is the smallest. Europe is the third-most populous continent after Asia and Africa, with a population of 733 million or about 11% of the world's population.[3] Europe, in particular Ancient Greece, is the birthplace of Western culture.[4] It played a predominant role in global affairs from the 16th century onwards, especially after the beginning of colonialism. Between the 16th and 20th centuries, European nations controlled at various times the Americas, most of Africa, Oceania, and large portions of Asia. Both World Wars were largely focused upon Europe, greatly contributing to a decline in Western European dominance in world affairs by the mid-20th century as the United States and Soviet Union took prominence.[5] During the Cold War, Europe was divided along the Iron Curtain between NATO in the west and the Warsaw Pact in the east. European integration led to the formation of the Council of Europe and the European Union in Western Europe, both of which have been expanding eastward since the fall of the Soviet Union in 1991.");

      outSPSS.addData("Australia/Oceania");
      outSPSS.addData(new Long(7687000L));
      outSPSS.addData(new Long(31000000L));
      outSPSS.addData(new Long(14));
      outSPSS.addData(new Date());
      outSPSS.addData("Australia, officially the Commonwealth of Australia,[10] is a country in the Southern Hemisphere comprising the mainland of the Australian continent as well as the island of Tasmania and numerous smaller islands in the Indian and Pacific Oceans.[N 4] It is the world's sixth-largest country by total area. Neighbouring countries include Indonesia, East Timor and Papua New Guinea to the north; the Solomon Islands, Vanuatu and New Caledonia to the north-east; and New Zealand to the south-east. For at least 40,000 years[12] before European settlement in the late 18th century, Australia was inhabited by indigenous Australians,[13] who belonged to one or more of roughly 250 language groups.[14][15] After discovery by Dutch explorers in 1606, Australia's eastern half was claimed by Great Britain in 1770 and settled through penal transportation to the colony of New South Wales from 26 January 1788. The population grew steadily in subsequent decades; the continent was explored and an additional five self-governing Crown Colonies were established.");

      outSPSS.addData("Transylvania");
      outSPSS.addData(new Long(7345560L));
      outSPSS.addData(new Long(34565456L));
      outSPSS.addData(new Long(44));
      outSPSS.addData((Date) null);
      outSPSS.addData("Transylvania is a historical region in the central part of Romania. Bounded on the east and south by the Carpathian mountain range, historical Transylvania extended in the west to the Apuseni Mountains; however, the term sometimes encompasses not only Transylvania proper, but also the historical regions of Crisana, Maramures, and Romanian part of Banat. Transylvania has been dominated by several different peoples and countries throughout its history. It was once the nucleus of the Kingdom of Dacia (82 BC–106 AD). In 106 AD the Roman Empire conquered the territory and after that its wealth was systematically exploited. After the Roman legions withdrew in 271 AD, it was overrun by a succession of various tribes, which subjected it to various influences. During this time areas of it were under the control of the Carpi (Dacian tribe), Visigoths, Huns, Gepids, Avars, Slavs and Bulgarians. It is subject of dispute whether elements of the mixed Daco–Roman population survived in Transylvania through the Dark Ages (becoming the ancestors of modern Romanians) or the first Vlachs appeared in the area in the 13th century after a northwards migration from the Balkan Peninsula. There is an ongoing scholarly debate over the ethnicity of Transylvania's population before the Hungarian conquest (see Origin of the Romanians).");

      // Create SPSS ending section
      outSPSS.addFinishSection();

      // Close output stream
      out.close();
    } catch (FileNotFoundException exOb) {
      System.out.println("FileNotFoundException (Demo.main): "
          + exOb.getMessage());
      exOb.printStackTrace(System.out);
      return;
    } catch (IOException exOb) {
      System.out.println("IOException (Demo.main): " + exOb.getMessage());
      exOb.printStackTrace(System.out);
      return;
    }
  }
      public static String now() 
    {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());
    }
}