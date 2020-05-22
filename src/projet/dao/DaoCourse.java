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
import projet.data.Course;


public class DaoCourse {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int CreerCourse(Course course) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO course ( id, date, intitule, depart, arrivee, tarif) VALUES( ?, ?, ?, ?, ?, ?) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, course.getDate() );
			stmt.setObject( 2, course.getIntitule() );
			stmt.setObject( 3, course.getDepart() );
			stmt.setObject( 3, course.getArrivee() );
			stmt.setObject( 3, course.getTarif() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			course.setId( rs.getObject( 1, Integer.class) );
			return course.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier(Course course) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE course SET date = ?, intitule = ?, depart = ?, arrivee = ?, tarif = ? WHERE id =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, course.getDate() );
			stmt.setObject( 2, course.getIntitule() );
			stmt.setObject( 3, course.getDepart() );
			stmt.setObject( 4, course.getArrivee() );
			stmt.setObject( 5, course.getTarif() );
			stmt.setObject( 6, course.getId() );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int id ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM course WHERE id = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Course retrouver(String intitule) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM course WHERE intitule = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(1, intitule);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCourse( rs );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Course> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM course ORDER BY intitule";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Course> course = new LinkedList<>();
			while (rs.next()) {
				course.add( construireCourse( rs ) );
			}
			return course;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Course construireCourse( ResultSet rs ) throws SQLException {
		Course course = new Course();
		course.setId( rs.getObject( "id", Integer.class ) );
		course.setDate( rs.getObject( "date", LocalDate.class ) );
		course.setIntitule( rs.getObject( "intitule", String.class ) );
		course.setDepart( rs.getObject( "depart", String.class ) );
		course.setArrivee( rs.getObject( "arrivee", String.class ) );
		course.setTarif( rs.getObject( "tarif", Double.class ) );
		return course;
	}

}
