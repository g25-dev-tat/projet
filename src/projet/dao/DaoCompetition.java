package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Competition;


public class DaoCompetition {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int CreerCompetition( Competition compet ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO competition (id, circuit, echeancedeb, echeancefin) VALUES( ?, ?, ?, ?) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, compet.getCricuit() );
			stmt.setObject( 2, compet.getEcheanceDeb() );
			stmt.setObject( 3, compet.getEcheanceFin() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			compet.setId( rs.getObject( 1, Integer.class) );
			
			return compet.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Competition compet ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE competition SET circuit = ?, echeancedeb = ?, echeancefin = ? WHERE id =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, compet.getCricuit() );
			stmt.setObject( 2, compet.getEcheanceDeb() );
			stmt.setObject( 3, compet.getEcheanceFin() );
			
			stmt.setObject( 4, compet.getId() );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int id) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			
			cn = dataSource.getConnection();
			sql = "DELETE FROM competition WHERE id = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, id );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Competition retrouver( int id ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM competition WHERE echeancedeb = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCompetition(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Competition> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM competition ORDER BY echeancedeb";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Competition> compet= new LinkedList<>();
			while (rs.next()) {
				compet.add( construireCompetition( rs) );
			}
			return compet;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
    public int compterPourCompetition(int id) {
    	
		Connection			cn		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;

		try {
			cn = dataSource.getConnection();
            String sql = "SELECT COUNT(*) FROM memo WHERE id = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, id);
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
	
	private Competition construireCompetition( ResultSet rs) throws SQLException {
		Competition compet = new Competition();
		compet.setId( rs.getObject( "id", Integer.class ) );
		compet.setCricuit( rs.getObject( "circuit", String.class ) );
		compet.setEcheanceDeb( rs.getObject( "echeancedeb", LocalDate.class ) );
		compet.setEcheanceFin( rs.getObject( "echeancefin", LocalDate.class ) );
		
		return compet;
	}

}
