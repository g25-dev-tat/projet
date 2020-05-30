package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Participant;


public class DaoParticipant {

	
	// Champs

	@Inject
	private static DataSource		dataSource;

	
	// Actions

//	public int inserer( Benevole categorie ) {
//
//		Connection			cn		= null;
//		PreparedStatement	stmt	= null;
//		ResultSet 			rs		= null;
//		String				sql;
//
//		try {
//			cn = dataSource.getConnection();
//			sql = "INSERT INTO categorie ( libelle ) VALUES( ? ) ";
//			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
//			stmt.setObject( 1, categorie.getLibelle() );
//			stmt.executeUpdate();
//
//			// Récupère l'identifiant généré par le SGBD
//			rs = stmt.getGeneratedKeys();
//			rs.next();
//			categorie.setId( rs.getObject( 1, Integer.class) );
//			return categorie.getId();
//	
//		} catch ( SQLException e ) {
//			throw new RuntimeException(e);
//		} finally {
//			UtilJdbc.close( rs, stmt, cn );
//		}
//	}


//	public void modifier( Benevole categorie ) {
//
//		Connection			cn		= null;
//		PreparedStatement	stmt	= null;
//		String				sql;
//
//		try {
//			cn = dataSource.getConnection();
//			sql = "UPDATE categorie SET libelle = ? WHERE idcategorie =  ?";
//			stmt = cn.prepareStatement( sql );
//			stmt.setObject( 1, categorie.getLibelle() );
//			stmt.setObject( 2, categorie.getId() );
//			stmt.executeUpdate();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			UtilJdbc.close( stmt, cn );
//		}
//	}


	public static void supprimer(int id) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM participant WHERE id = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Participant retrouver(Participant part) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant WHERE nom = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject(1, part.getNom());
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireParticipant( rs );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public static List<Participant> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Participant> part = new LinkedList<>();
			while (rs.next()) {
				part.add( construireParticipant( rs ) );
			}
			return part;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private static Participant construireParticipant( ResultSet rs ) throws SQLException {
		Participant part = new Participant();
		part.setId( rs.getObject( "id", Integer.class ) );
		part.setNom( rs.getObject( "nom", String.class ) );
		part.setPrenom( rs.getObject( "prenom", String.class ) );
		part.setTelephone( rs.getObject( "telephone", Integer.class ) );
		part.setEmail( rs.getObject( "email", String.class ) );
		part.setAdresse( rs.getObject( "adresse", String.class ) );
		part.setJustificatifs( rs.getObject( "justificatifs", String.class ) );
		part.setCommentaire( rs.getObject( "commentaire", String.class ) );
		part.setClub( rs.getObject( "club", String.class ) );
		part.setDateNaiss( rs.getObject( "dateNaiss", LocalDate.class ) );
		return part;
	}


	public static Participant affich(Participant item) {
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM participant WHERE id= ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, item.getId());
			rs = stmt.executeQuery();

			return item;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

}
