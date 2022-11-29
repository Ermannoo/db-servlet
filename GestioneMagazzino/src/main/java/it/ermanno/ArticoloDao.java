package it.ermanno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.ermanno.Articolo;

public class ArticoloDao {
	
	public void insert(Articolo a) throws SQLException
	{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			
			Class.forName(driver);
			
			//Creiamo la stringa per instaurare la connessione
			String url = "jdbc:mysql://localhost:3306/gest_magazzino";
			
			//Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "pesce", "pescee");
			
			String updateTableSQL = "INSERT INTO articolo (descrizione, quantita) VALUES (?,?)";
			
			cmd = dbConnection.prepareStatement(updateTableSQL);
			
			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());
			
			//execute update SQL statement
			cmd.executeUpdate();
			
			System.out.println("Record has been updated to DBUSER table!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(cmd!=null)
			{
				cmd.close();
			}
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
		}	
	}
}