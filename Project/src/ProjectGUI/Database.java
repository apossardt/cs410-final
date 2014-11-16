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
	final String JDBC_URL = "jdbc:derby:Database;create=true";
	/* 
	 * createTable should only execute when the program is initiated for the first time and
	 * sets the tables to the default
	*/
	public void createTables()throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		
		try
		{
		connection.createStatement().execute("create table passages(passage varchar(500))");
		connection.createStatement().execute("insert into passages values " 
                                + "('An Overview of Personality Disorders'),"
                                + "(''),"
				+ "('We all think we know what a \"personality\" is. It\'s all of the characterisitic ways a person behaves'),"
				+ "('and thinks: \"Michael tends to be shy\"; \" Mindy likes to be very dramatic\"; \"Juan is always),"
                                + "('suspicious of others\"; \"Annette is very outgoing\"; \"Bruce seems to be very sensitive and gets),"
                                + "('upset very easily over minor things”; “Sean has the personality of an eggplant!” We tent to type'),"
                                + "('people as behaving in one way in many different situations. For example, like Michael, many of'),"
                                + "('us are shy with people we don’t know, but we wont be shy around our friends. A truly shy'),"
                                + "('person is shy even among people he or she has known for some time. The shyness is part of'),"
                                + "('the way the person behaves in most situations. We have all probably behaved in all the ways'),"
                                + "('noted here (“dramatic,” “suspicious,” “outgoing,” “easily upset”). However, we usually consider'),"
                                + "('a way of behaving part of a person's personality only if it occurs in many times and places. In'),"
                                + "('this chapter we look at characteristic ways of behaving in relation to personality disorders. First'),"
                                + "('we examine in some detail how we conceptualize personality disorders and the issues related to'),"
                                + "('them; then we describe the disorders themselves.'),"
                                + "(''),"
                                + "('Aspects of Personality Disorders'),"
                                + "(''),"
                                + "('What if a person's characteristic ways of thinking and behaving cause significant distress to the'),"
                                + "('self or others? What if the person cant change this way of relating to the world and is unhappy?'),"
                                + "('We might consider this person to have a “personality disorder.” The DSM-V definition notes'),"
                                + "('that these personality characteristics are “inflexible and maladaptive and cause significant'),"
                                + "('functional impairment of subjective distress.” Unlike many of the disorders we have already'),"
                                + "('discussed, personality disorders are chronic; they do not come and go but originate in childhood'),"
                                + "('and continue throughout adulthood. Because they affect personality, these chronic problems'),"
                                + "('pervade every aspect of a person's life. If a man is overly suspicious, for example (a sign of a'),"
                                + "('possible paranoid personality disorder), this trait will affect almost everything he does, including'),"
                                + "('his employment (he may have to change jobs frequently if he believes co-workers conspire'),"
                                + "('against him), his relationships (he may not be able to sustain a lasting relationship if he can't'),"
                                + "('trust anyone), and even where he lives (he may have to move often if he suspects his landlord is out'),"
                                + "('to get him).'),"
                                + "(''),"
                                + "('Paranoid personality disorders'),"
                                + "(''),"
                                + "('Although it is probably very adaptive to be a little wary of other people and their motives, being'),"
                                + "('too distrustful can interfere with making friends, working with others, and, in general, getting'),"
                                + "('through daily interactions in a functional way. People with paranoid personality disorder are'),"
                                + "('excessively mistrustful and suspicious of others, without any justification. They assume other'),"
                                + "('people are out to harm or trick them, and therefor they tend not to confide in others. Consider this'),"                     
				+ "('case of Jake.')");
		System.out.println("passages table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table SMS(message varchar(80))");
		connection.createStatement().execute("insert into SMS values " 
				+ "('Tell me about your classes.'),"
				+ "('Which classes have you had that youd recommend?'),"
                                + "('What do you wanna do with your life when you get outta here?'),"
                                + "('What do you like to do in your spare time?'),"
				+ "('Had any trouble parking on campus?')");
		System.out.println("SMS table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table readingQuestions(rquestion varchar(200), answer1 varchar(80), answer2 varchar(80), answer3 varchar(80), answer4 varchar(80), answer5 varchar(80))");
		connection.createStatement().execute("insert into readingQuestions values " 
				+ "('Which of the following is not true about personality disorders?', 'are marked by distress to the individual experiencing them', 'pervade every aspect of a person's life, 'respond well to psychotherapy', 'tend to begin in childhood', ''),"
                                + "('People with paranoid personality disorder', 'are very sensitive to criticism and have an excessive need for autonomy', 'lack of emotional expressiveness and pursue vague interests', 'find social isolation extremely painful', 'all of the above', ''),"
                                + "('A person who seems \"aloof\", \"cold\" and \"indifferent\" to others but typically does not show signs of \"magical thinging\" is most likely to have which of the following disorders', 'schizoid personality disorder', 'paranoid personality disorder', 'schizotypal personality disorder', 'schizophrenic disorder', 'not enough information is given to be able to choose a best answer'),"
                                + "('According to the reading, the treatment prospects for the people with schizoid personality disorder are:', 'quite good with biological therapies alone', 'quite good with psychotherapy alone', 'reasonably good when biological therapies are combined with psychological treatments for depression.', 'not good', 'none of the aboce is correct, the reading did not address treatment outcomes of persons with schizoid personality disorder'),"
                                + "(Evidence for biological contributions to paranoid personality disorder is limited', 'True', 'False', '', '', ''),"
                                + "('According to the reading, the term \"schizoid\" was used in the 1920\'s by', 'Bixler', 'Bleuler', 'Meehl', 'Stone', 'none of the above, the term schizoid was not used until the 1960\'s'),");
		System.out.println("questions table created and records successfully inserted ...");
		}
		catch (SQLException e)
		{
			
		}
		
		try
		{
		connection.createStatement().execute("create table demographicQuestions(dquestion varchar(200), answer1 varchar(80), answer2 varchar(80), answer3 varchar(80), answer4 varchar(80), answer5 varchar(80))");
		connection.createStatement().execute("insert into demographicQuestions values " 
				+ "('I feel impatient when I read my textbooks.', 'Strongly Agree', 'Agree', 'Neutral', 'Disagree', 'Strongly Disagree')"
                                + "('I get absorbed in reading books for pleasure', 'Strongly Agree', 'Agree', 'Neutral', 'Disagree', 'Strongly Disagree'),"
                                + "('I get distracted easily when reading class assignments', 'Strongly Agree', 'Agree', 'Neutral', 'Disagree', 'Strongly Disagree'),"
                                + "('I rarely do the assigned readings for my classes', 'Strongly Agree', 'Agree', 'Neutral', 'Disagree', 'Strongly Disagree'),"
                                + "('I find it easy to focus on assigned readings', 'Strongly Agree', 'Agree', 'Neutral', 'Disagree', 'Strongly Disagree'),"
                                + "('Gender', 'Male', 'Female', '', '', ''),"
                                + "('Age', '', '', '', '', '')");
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
