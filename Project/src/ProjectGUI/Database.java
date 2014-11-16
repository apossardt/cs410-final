package ProjectGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	final String JDBC_URL = "jdbc:derby:outputDatabase;create=true";
	/* 
	 * createTable should only execute when the program is initiated for the first time and
	 * sets the tables to the default
	 * I figure we can do this with a try statement to see if the tables return null or something
	*/
	public void createTables()throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		
		try
		{
		connection.createStatement().execute("create table passages(passage varchar(500))");
		connection.createStatement().execute("insert into passages values " 
				+ "('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),"
				+ "('bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb'),"
				+ "('ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc')");
		System.out.println("passages table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table SMS(message varchar(80))");
		connection.createStatement().execute("insert into SMS values " 
				+ "('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),"
				+ "('bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb'),"
				+ "('cccccccccccccccccccccccccccccccccccccccccccccccc')");
		System.out.println("SMS table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table readingQuestions(rquestion varchar(200), answer1 varchar(80), answer2 varchar(80), answer3 varchar(80), answer4 varchar(80), answer5 varchar(80))");
		connection.createStatement().execute("insert into readingQuestions values " 
				+ "('what is the capital of connecticut?', 'New Haven', 'Hartford', 'Bristol', 'New Amsterdam', 'Italy')");
		System.out.println("questions table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table demographicQuestions(dquestion varchar(200), answer1 varchar(80), answer2 varchar(80), answer3 varchar(80), answer4 varchar(80), answer5 varchar(80))");
		connection.createStatement().execute("insert into demographicQuestions values " 
				+ "('what is the capital of connecticut?', 'New Haven', 'Hartford', 'Bristol', 'New Amsterdam', 'Italy')");
		System.out.println("questions table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table timingData(participant varchar(10), buttonPress varchar(1), linenumber varchar(4), elapsedtime varchar(20))");
		System.out.println("timingData table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table readingData(participant varchar(10), Response varchar(1), questionNumber varchar(4), elapsedtime varchar(20))");
		System.out.println("ReadingData table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table demographicData(participant varchar(10), Response varchar(255), questionNumber varchar(4), elapsedtime varchar(20))");
		System.out.println("DemographicData table created and records successfully inserted ...");
		
		}
		catch (SQLException e)
		{
			
		}
		
	}
	
	
	
	/* 
	 * getPassage returns the passage in an arraylist form with each entry representing a line of text
	 */
	ArrayList<String> getPassage()throws ClassNotFoundException, SQLException
	{
		String SQL_STATEMENT = " select * from passages";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ArrayList<String> passage = new ArrayList<String>();

		while (resultSet.next())
		{
			passage.add(resultSet.getString(1));
		}
		if (statement != null) 
			statement.close();
		if (connection != null) 
			connection.close();
		return passage;
	}
	
	
	/*
	 * getSMS recieves the requested SMS number that coincides with its id and returns 
	 * the proper text. this only applies if we think these should be editable.
	*/
	ArrayList<String> getSMS()throws ClassNotFoundException, SQLException
	{
		String SQL_STATEMENT = " select * from SMS";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ArrayList<String> message = new ArrayList<String>();

		while (resultSet.next())
		{
			message.add(resultSet.getString(1));
		}
		if (statement != null) 
			statement.close();
		if (connection != null) 
			connection.close();
		return message;
	}
	
	/*
	 * getReadQuestions returns an array of string type that contains the question and its 5 responses respectively
	*/
	
	ArrayList<String[]> getReadQuestion()throws ClassNotFoundException, SQLException
	{
		String SQL_STATEMENT = " select * from readingQuestions";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		String[] question = new String[columnCount];
		ArrayList<String[]> questions = new ArrayList<String[]>();
		while (resultSet.next())
		{
			for (int x = 1; x <= columnCount; x++)
				question[x -1] = resultSet.getString(x);
			questions.add(question);
		}
		if (statement != null) 
			statement.close();
		if (connection != null) 
			connection.close();
		return questions;
	}
	
	/*
	 * getDemoQuestions returns an array of string type that contains the question and its 5 responses respectively
	*/
	
	ArrayList<String[]> getDemoQuestion()throws ClassNotFoundException, SQLException
	{
		String SQL_STATEMENT = " select * from demographicQuestions";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		String[] question = new String[columnCount];
		ArrayList<String[]> questions = new ArrayList<String[]>();
		while (resultSet.next())
		{
			for (int x = 1; x <= columnCount; x++)
				question[x -1] = resultSet.getString(x);
			questions.add(question);
		}
		if (statement != null) 
			statement.close();
		if (connection != null) 
			connection.close();
		return questions;
	}
	
	/*
	 * inserts a keystroke into the database.
	*/
	
	public void insertKeyStroke(int participant, int key, int line, int time)throws ClassNotFoundException, SQLException
	{
		String insert = "('"+participant+"', '"+key+"', '"+line+"', '"+time+"')";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("insert into timingData values " 
				+ insert);
	}
	
	/*
	 * inserts a reading response into the database.
	*/
	
	public void insertReadResponse(int participant, int response, int line, int time)throws ClassNotFoundException, SQLException
	{
		String insert = "('"+participant+"', '"+response+"', '"+line+"', '"+time+"')";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("insert into readingData values " 
				+ insert);
	}
	
	/*
	 * inserts a demographic response as an int into the database.
	*/
	
	public void insertDemoResponse(int participant, int response, int line, int time)throws ClassNotFoundException, SQLException
	{
		String insert = "('"+participant+"', '"+response+"', '"+line+"', '"+time+"')";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("insert into demographicData values " 
				+ insert);
	}
	
	/*
	 * inserts a demographic response as a String into the database.
	*/
	
	public void insertDemoResponse(int participant, String response, int line, int time)throws ClassNotFoundException, SQLException
	{
		String insert = "('"+participant+"', '"+response+"', '"+line+"', '"+time+"')";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("insert into demographicData values " 
				+ insert);
	}
	
	/*
	 * resets the database to its default settings. not sure if this should clear the user data as well
	*/
	
	public void reset()throws ClassNotFoundException, SQLException
	{
		createTables();
	}
	
}
