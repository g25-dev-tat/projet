package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.AdminAppli;


public class DaoCompte {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	@Inject
	private DaoRole			daoRole;

	
	// Actions

	public int inserer(AdminAppli compte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			
			// Insère le compte
			sql = "INSERT INTO adminappli (Id, Nom, Prenom, Telephone, email, adresse, login, pass) VALUES ( ?, ?, ?,?,?,?,? )";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ); 
			stmt.setObject( 1, compte.getNom() );
			stmt.setObject( 2, compte.getPrenom() );
			stmt.setObject( 3, compte.getTelephone() );
			stmt.setObject( 4, compte.getEmail() );
			stmt.setObject( 5, compte.getAdresse() );
			stmt.setObject( 6, compte.getLogin() );
			stmt.setObject( 7, compte.getPass() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			compte.setId( rs.getObject( 1, Integer.class) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		// Insère les rôles
		daoRole.insererPourCompte( compte );
		
		// Retourne l'identifiant
		return compte.getId();
	}
	

	public void modifier( AdminAppli compte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le compte
			sql = "UPDATE adminappli SET Nom = ?, Prenom = ?, Telephone = ?, email = ?, Adresse = ?, Login = ?, Pass = ? WHERE Id =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, compte.getNom() );
			stmt.setObject( 2, compte.getPrenom() );
			stmt.setObject( 3, compte.getTelephone() );
			stmt.setObject( 4, compte.getEmail() );
			stmt.setObject( 5, compte.getAdresse() );
			stmt.setObject( 6, compte.getLogin() );
			stmt.setObject( 7, compte.getPass() );
			stmt.setObject( 8, compte.getId() );
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		// Modifie les rôles
		daoRole.supprimerPourCompte( compte.getId() );
		daoRole.insererPourCompte( compte );

	}
	

	public void supprimer( int idCompte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		// Supprime les rôles
		daoRole.supprimerPourCompte( idCompte );

		try {
			cn = dataSource.getConnection();

			// Supprime le compte
			sql = "DELETE FROM adminappli WHERE Id = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, idCompte );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public AdminAppli retrouver( int idCompte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM adminappli WHERE Id = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, idCompte );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireCompte( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	public List<AdminAppli> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM adminappli ORDER BY Nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<AdminAppli> comptes = new ArrayList<>();
			while ( rs.next() ) {
				comptes.add( construireCompte(rs) );
			}
			return comptes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public AdminAppli validerAuthentification( String login, String pass )  {
		
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM adminappli WHERE Login = ? AND Pass = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, login );
			stmt.setObject( 2, pass );
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCompte( rs );			
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public boolean verifierUniciteLogin( String login, Integer id )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		if ( id == null ) id = 0;
		
		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) = 0 AS unicite"
					+ " FROM adminappli WHERE Login = ? AND Id <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject(	1, login );
			stmt.setObject(	2, id );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getBoolean( "unicite" );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private AdminAppli construireCompte( ResultSet rs ) throws SQLException {
		AdminAppli compte = new AdminAppli();
		compte.setId( rs.getObject( "Id", Integer.class ) );
		compte.setPrenom( rs.getObject( "Prenom", String.class ) );
		compte.setTelephone( rs.getObject( "Telephone", Integer.class ) );
		compte.setEmail( rs.getObject( "email", String.class ) );
		compte.setAdresse( rs.getObject( "adresse", String.class ) );
		compte.setLogin( rs.getObject( "login", String.class ) );
		compte.setPass( rs.getObject( "pass", String.class ) );
		
		compte.getRoles().setAll( daoRole.listerPourCompte( compte ) );
		return compte;
	}
	
}
