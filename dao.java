package labyrinthe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;

public class dao {

	@Inject
	DataSource datasource;
	void inserer(competition c)
	{
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;


		try {
			cn = datasource.getConnection();

			// Insère le compte
			sql = "INSERT INTO competition (circuit, datedebut, datefin) VALUES ( ?,?,?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ); 
			stmt.setObject( 1, c.getCircuit());
			stmt.setObject( 2, c.getDatedebut());
			stmt.setObject(3, c.getDatefin());
			stmt.executeUpdate();

	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
}
