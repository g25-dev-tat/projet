package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Equipe;
import projet.data.Participant;


public class DaoEquipe {

	
	// Champs

	@Inject
	private static DataSource		dataSource;
	@Inject
	private DaoParticipant	daopart;

	
	// Actions

//	public int inserer(Equipe eq)  {
//
//		Connection			cn		= null;
//		PreparedStatement	stmt	= null;
//		ResultSet 			rs 		= null;
//		String				sql;
//
//		try {
//			cn = dataSource.getConnection();
//
//			// Insère le personne
//			sql = "INSERT INTO personne ( idcategorie, nom, prenom ) VALUES ( ?, ?, ? )";
//			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
//			stmt.setInt(	1, personne.getCategorie().getId() );
//			stmt.setString(	2, personne.getNom() );
//			stmt.setString(	3, personne.getPrenom() );
//			stmt.executeUpdate();
//
//			// Récupère l'identifiant généré par le SGBD
//			rs = stmt.getGeneratedKeys();
//			rs.next();
//			personne.setId( rs.getObject( 1, Integer.class ) );
//	
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			UtilJdbc.close( stmt, cn );
//		}
//
//		// Insère les telephones
//		daoTelephone.insererPourPersonne( personne );
//		
//		// Retourne l'identifiant
//		return personne.getId();
//	}

	
//	public void modifier(AdminAppli personne)  {
//
//		Connection			cn		= null;
//		PreparedStatement	stmt	= null;
//		String 				sql;
//
//		try {
//			cn = dataSource.getConnection();
//
//			// Modifie le personne
//			sql = "UPDATE personne SET idcategorie = ?, nom = ?, prenom = ? WHERE idpersonne =  ?";
//			stmt = cn.prepareStatement( sql );
//			stmt.setObject( 1, personne.getCategorie().getId() );
//			stmt.setObject( 2, personne.getNom() );
//			stmt.setObject( 3, personne.getPrenom() );
//			stmt.setObject( 4, personne.getId() );
//			stmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			UtilJdbc.close( stmt, cn );
//		}
//
//		// Modifie les telephones
//		daoTelephone.modifierPourPersonne( personne );
//	}

	
	public static void supprimer(int id)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le personne
			sql = "DELETE FROM equipe WHERE id = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, id );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Equipe retrouver(Equipe eq)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM equipe WHERE nomeq = ?";
            stmt = cn.prepareStatement(sql);
            stmt.setObject( 1, eq.getNomEq());
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireEquipe(rs);
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	
	public static List<Equipe> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM equipe ORDER BY id";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			List<Equipe> eq = new ArrayList<>();
			while (rs.next()) {
				eq.add( construireEquipe(rs) );
			}
			return eq;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

//	public List<AdminAppli> listerPourMemo( int idMemo )   {
//
//		Connection			cn		= null;
//		PreparedStatement	stmt	= null;
//		ResultSet 			rs 		= null;
//		String				sql;
//
//		try {
//			cn = dataSource.getConnection();
//
//			sql = "SELECT p.* FROM personne p" 
//				+ " INNER JOIN concerner c ON p.idpersonne = c.idpersonne" 
//				+ " WHERE c.idmemo = ?" 
//				+ " ORDER BY nom, prenom";
//			stmt = cn.prepareStatement(sql);
//			stmt.setObject( 1, idMemo ); 
//			rs = stmt.executeQuery();
//			
//			List<AdminAppli> personnes = new ArrayList<>();
//			while (rs.next()) {
//				personnes.add( construireEquipe(rs) );
//			}
//			return personnes;
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			UtilJdbc.close( rs, stmt, cn );
//		}
//	}

    
    public int compterPourEquipe(int id) {
    	
		Connection			cn		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;

		try {
			cn = dataSource.getConnection();
            String sql = "SELECT COUNT(*) FROM equipe WHERE id = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, id );
            rs = stmt.executeQuery();

            rs.next();
            return rs.getInt( 1 );

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
    }
	
	
	// Méthodes auxiliaires
	
	private static Equipe construireEquipe(ResultSet rs) throws SQLException {

		Equipe eq= new Equipe();
		eq.setId(rs.getObject( "id", Integer.class ));
		eq.setNomEq(rs.getObject( "nomeq", String.class ));
		eq.setPaye(rs.getObject( "paye", Boolean.class ));
		eq.setValide(rs.getObject( "valide", Boolean.class ));
		eq.setCommentaire(rs.getObject( "commentaire", String.class ));
		eq.setNbr_Repas(rs.getObject( "nbrerepas", Integer.class ));
		eq.setTemps_mis(rs.getObject( "temps_mis", Time.class ));
		
		return eq;
	}


	public DaoParticipant getDaopart() {
		return daopart;
	}


	public void setDaopart(DaoParticipant daopart) {
		this.daopart = daopart;
	}

	public static Equipe affich(Participant item, Equipe eq) {
		Connection			cn		= null;
		PreparedStatement	stmt=null;
		ResultSet 			rs = null;
		String				sql;
		
		int id=affch(item);

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM equipe WHERE id= ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, id);
			rs = stmt.executeQuery();

			return eq;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	public static int affch(Participant item) {
		
		Connection			cn		= null;
		PreparedStatement	stmt=null ;
		ResultSet 			rs = null;
		String				sql;
		int e = 0;

		try {
			cn = dataSource.getConnection();
			
			sql = "SELECT id_equipe FROM participant WHERE id= ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, item.getId());
			rs = stmt.executeQuery();

			return e;

		} catch (SQLException err) {
			throw new RuntimeException(err);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
		
	}
	
}
