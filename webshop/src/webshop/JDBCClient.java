package webshop;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCClient {

	Connection con;
	
	JDBCClient() throws SQLException{
		//Initialize the connection with test user that has priviliges
		this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webshop","test","test");
	}
	/***
	 * Makes an preparedStatemenent and then fills and ArrayList with Artikel
	 * @return List of all articles
	 * @throws SQLException
	 */
	List<Artikel> getAllArticles() throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM artikel");
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Artikel> rl = new ArrayList<>();
		while(rs.next()){
			int anr = rs.getInt("anr");
			String abez = rs.getString("abez");
			String ainfo = rs.getString("info");
			Float preis = rs.getFloat("npreis");
			int vstueckz = rs.getInt("vstueckz");
			rl.add(new Artikel(anr,abez,ainfo,preis,vstueckz));
		}
		return rl;
	}
	
	/***
	 * Makes an preparedStatement and then inserts the desired article into the database with executeUpdate()
	 * @param a the desired article to be inserted into the database
	 * @throws SQLException
	 */
	void addArticle(Artikel a) throws SQLException {
		PreparedStatement ptsmt = con.prepareStatement("INSERT INTO artikel(anr,abez,npreis,vstueckz,info) values(?,?,?,?,?)");
		ptsmt.setInt(1, a.getAnr());
		ptsmt.setString(2, a.getAbez());
		ptsmt.setFloat(3, a.getPreis());
		ptsmt.setInt(4, a.getVstueckz());
		ptsmt.setString(5, a.getAinfo());
		ptsmt.executeUpdate();
	}
	
	/**
	 * Makes an preparedStatement and then updates the desired article with the values
	 * @param a the article to be updated
	 * @throws SQLException
	 */
	void saveArticle(Artikel a) throws SQLException {
		PreparedStatement ptsmt = con.prepareStatement("UPDATE artikel SET anr=?,abez=?,npreis=?,vstueckz=?,info=? WHERE anr=?");
		ptsmt.setInt(1, a.getAnr());
		ptsmt.setString(2, a.getAbez());
		ptsmt.setFloat(3, a.getPreis());
		ptsmt.setInt(4, a.getVstueckz());
		ptsmt.setString(5, a.getAinfo());
		ptsmt.setInt(6, a.getAnr());
		ptsmt.executeUpdate();
	}
	
	/**
	 * Delete an article based on the primary key anr
	 * @param anr primary key which defines an article so it can be deleted
	 * @throws SQLException
	 */
	void delArticle(int anr) throws SQLException{
		PreparedStatement ptsmt = con.prepareStatement("DELETE FROM artikel WHERE anr=?");
		ptsmt.setInt(1, anr);
		ptsmt.executeUpdate();
	}
}
