
package ProjectGUI;
import com.pmstation.spss.SPSSWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author owen
 */
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExportData {
    
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd-HH-mm-ss";
    private static String dbURL = "jdbc:derby://localhost:1527/sidresDB;create=true;user=sidresAdmin;password=1x!Software";
    private static String[] tableNames = {"PASSAGERESULTS", "QUESTIONRESULTS", "SMSRESULTS", "SURVEYRESULTS"};
    // Entrance point
  public static void export() throws ClassNotFoundException, SQLException {
    try{
      // Open file output stream with filename args[0]
      OutputStream out = new FileOutputStream("data" + now() + ".sav");

      // Assign SPSS output to the file
      SPSSWriter outSPSS = new SPSSWriter(out, "utf-8");

      // Creating SPSS variable description table
      outSPSS.setCalculateNumberOfCases(false);
      outSPSS.addDictionarySection(-1);

      // Describing varible names and types
      outSPSS.addStringVar("event", 255, "Event that transpired");
      outSPSS.addStringVar("id#", 255, "user id");
      outSPSS.addStringVar("time", 255, "elapsed time");
      outSPSS.addStringVar("question", 255, "which question was asked?");
      outSPSS.addStringVar("response", 255, "response from question if any");
      outSPSS.addStringVar("correct", 255, "was the response correct?");


      // Create SPSS variable value define table
      outSPSS.addDataSection();
      ArrayList<String[]> data;
        data = getData();
      // Add values for all defined variables
      while(data.isEmpty() != true)
      {
          String[] entry = new String[6];
          entry = data.remove(0);
          for (int x = 0; x < 6; x++)
          {
              if(x < entry.length && entry[x] != null)
                  outSPSS.addData(entry[x]);
              else
                  outSPSS.addData("");
          }
      }
      
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

    static ArrayList<String[]> getData()throws ClassNotFoundException, SQLException
    {
       int numOfResultTables = 4;

       ArrayList<String[]> message = new ArrayList<String[]>();
       for(int table = 0; table < numOfResultTables; table ++)
       {

           String SQL_STATEMENT = " select * from " + tableNames[table];
           Connection connection = DriverManager.getConnection(dbURL);
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
           int columnCount = resultSetMetaData.getColumnCount();
           int lines;
           int ID;
           
           if(table == 0)
           {
               while (resultSet.next())
               {
                   String[] entry = new String[columnCount];

                       entry[0] = resultSet.getString(2) + " line:" +resultSet.getString(3);
                       entry[1] = resultSet.getString(5);
                       entry[2] = resultSet.getString(4);
                       message.add(entry);
               }
               if (statement != null) 
                       statement.close();
               if (connection != null) 
                       connection.close();
           }

           if(table == 1)
           {
               while (resultSet.next())
               {
                   String[] entry = new String[columnCount];

                       entry[0] = "Reading Questions| number:" + resultSet.getString(3);
                       entry[1] = resultSet.getString(2);
                       entry[2] = resultSet.getString(6);
                       entry[3] = resultSet.getString(3);
                       entry[4] = resultSet.getString(4);
                       entry[5] = resultSet.getString(5);
                       message.add(entry);
               }
               if (statement != null) 
                       statement.close();
               if (connection != null) 
                       connection.close();
           }
           if(table == 2)
           {
               while (resultSet.next())
               {
                   String[] entry = new String[columnCount];
                       entry[0] = "SMS";
                       entry[1] = resultSet.getString(1);
                       entry[2] = resultSet.getString(2);
                       entry[3] = resultSet.getString(3);
                       entry[4] = "word count:" + resultSet.getString(5) + " | response:" + resultSet.getString(4);
                       message.add(entry);
               }
               if (statement != null) 
                       statement.close();
               if (connection != null) 
                       connection.close();
           }
           if(table == 3)
           {

               while (resultSet.next())
               {
                   String[] entry = new String[columnCount];
                       entry[0] = "Demographic Questions| number:" + resultSet.getString(3);
                       entry[1] = resultSet.getString(2);
                       entry[3] = resultSet.getString(3);
                       entry[4] = resultSet.getString(5) + "" + resultSet.getString(4);
                       message.add(entry);
               }
               if (statement != null) 
                       statement.close();
               if (connection != null) 
                       connection.close();
           }
       }
        return message;
    }
}
  
