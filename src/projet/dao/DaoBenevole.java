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
import projet.data.Benevole;
import projet.data.Course;


public class DaoBenevole {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public void insererUnBenevole(Benevole benevol) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO benevole (id, nom, prenom, telephone, email, adresse, commentaire, permisC, dateNaiss) VALUES (?,?,?,?,?,?,?,?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			
				stmt.setObject(1, benevol.getNom());
				stmt.setObject(2, benevol.getPrenom());
				stmt.setObject(3, benevol.getTelephone());
				stmt.setObject(4, benevol.getEmail());
				stmt.setObject(5, benevol.getAdresse());
				stmt.setObject(6, benevol.getCommentaire());
				stmt.setObject(7, benevol.isPermisC());
				stmt.setObject(8, benevol.getDateNaiss());
				stmt.executeUpdate();

				// Récupère l'identifiant généré par le SGBD
				rs = stmt.getGeneratedKeys();
				rs.next();
				benevol.setId( rs.getObject( 1, Integer.class) );
				
			//for( Course telephone : benevole.getTelephone() ) {
			//}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void modifierUnBenevole(Benevole benevol) {

		Connection			cn			= null;
		PreparedStatement	stmtDelete	= null;
		PreparedStatement	stmtInsert	= null;
		PreparedStatement	stmtUpdate	= null;
		ResultSet 			rs 			= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			sql = "DELETE FROM benevole WHERE id = ?";
			stmtDelete = cn.prepareStatement( sql );
			for ( Benevole ben : listerPourPersonne(personne) ) {
				if ( ! personne.getTelephones().contains( ben ) ) {
					stmtDelete.setObject( 1, ben.getId() );
					stmtDelete.executeUpdate();
				}
			}

			sql = "INSERT INTO telephone ( idpersonne, libelle, numero ) VALUES (?,?,?)";
			stmtInsert = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			sql = "UPDATE telephone SET idpersonne = ?, libelle = ?, numero = ? WHERE idtelephone = ?";
			stmtUpdate = cn.prepareStatement( sql );
			for( Course telephone : personne.getTelephones() ) {
				if ( telephone.getId() == null || telephone.getId() == 0 ) {
					stmtInsert.setObject( 1, personne.getId());
					stmtInsert.setObject( 2, telephone.getLibelle() );
					stmtInsert.setObject( 3, telephone.getNumero() );
					stmtInsert.executeUpdate();
					// Récupère l'identifiant généré par le SGBD
					rs = stmtInsert.getGeneratedKeys();
					rs.next();
					telephone.setId( rs.getObject( 1, Integer.class) );
				} else {
					stmtUpdate.setObject( 1, personne.getId());
					stmtUpdate.setObject( 2, telephone.getLibelle() );
					stmtUpdate.setObject( 3, telephone.getNumero() );
					stmtUpdate.setObject( 4, telephone.getId());
					stmtUpdate.executeUpdate();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmtDelete, stmtInsert, stmtUpdate, cn );
		}
	}


	public void supprimerPourPersonne( int idPersonne ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime les telephones
			sql = "DELETE FROM telephone  WHERE idpersonne = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, idPersonne );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(  stmt, cn );
		}
	}


	public List<Benevole> listerBenevole(Benevole benevol) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM telephone WHERE idpersonne = ? ORDER BY libelle";
			stmt = cn.prepareStatement(sql);
			stmt.setObject( 1, personne.getId() );
			rs = stmt.executeQuery();

			List<Course> telephones = new ArrayList<>();
			while (rs.next()) {
				telephones.add( construireTelephone( rs, personne ) );
			}
			return telephones;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Course construireTelephone( ResultSet rs, AdminAppli personne ) throws SQLException {
		Course telephone = new Course();
		telephone.setId(rs.getObject( "idtelephone", Integer.class ));
		telephone.setLibelle(rs.getObject( "libelle", String.class ));
		telephone.setNumero(rs.getObject( "numero", String.class ));
		return telephone;
	}


	public Benevole listerTout() {
		// TODO Auto-generated method stub
		return null;
	}


	public Benevole retrouver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void supprimer(Integer id) {
		// TODO Auto-generated method stub
		
	}


	public Integer inserer(Benevole courant) {
		// TODO Auto-generated method stub
		return null;
	}


	public void modifier(Benevole courant) {
		// TODO Auto-generated method stub
		
	}

}
