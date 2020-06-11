package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Tache;

public class DaoTache {
	
	// Champs

	@Inject
	private static DataSource		dataSource;

	
	// Actions

	public Integer AffectationTache(Tache tache, int idPoste_Val_ret_meth_affect) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO tache (id, nomtache, date, id_poste) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			
				stmt.setObject(1, tache.getNom());
				stmt.setObject(2, tache.getDate());
				stmt.setObject(3, idPoste_Val_ret_meth_affect);
				stmt.executeUpdate();

				// Récupère l'identifiant généré par le SGBD
				rs = stmt.getGeneratedKeys();
				rs.next();
				tache.setId( rs.getObject( 1, Integer.class) );
				return tache.getId();
				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

}
