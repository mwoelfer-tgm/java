	package junk_data;
	
	import java.sql.*;
	
	public class Junk {
	
	    public static void main(String[] args) throws SQLException {
	
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webshop", "postgres", "abc123");
	        PreparedStatement pstmt = con.prepareStatement("INSERT INTO bestellung VALUES (?, ?, ?, ?, ?, ?);");
	
	        int bnrStart = 100;
	        for(int i = 0; i < 100000; i++) {
	            pstmt.setInt(1, bnrStart + i);
	            pstmt.setDate(2, new java.sql.Date(2017, 12, 29));
	            pstmt.setString(3, "storniert");
	            pstmt.setInt(4, 1019);
	            pstmt.setString(5, "Wagner Gasse");
	            pstmt.setString(6, "Wagner Gasse");
	
	            pstmt.executeUpdate();
	
	            System.out.print("Filling bestellung with bnr = " + (bnrStart + i));
	        }
	
	
	        int anrs[] = {1, 2, 3, 11111, 22222, 33333 };
	        for(int anr : anrs) {
	            for(int i = 0; i < 100000; i++) {
	                PreparedStatement pstmtArtikel = con.prepareStatement("INSERT INTO bestellartikel VALUES (?, ?, ?);");
	                pstmtArtikel.setInt(1, anr);
	                pstmtArtikel.setInt(2, bnrStart + i);
	                pstmtArtikel.setInt(3, 10);
	                pstmtArtikel.executeUpdate();
	                System.out.print("Filling bestellartikel with anr = " + anr + ", and bnr = " + (bnrStart + i));
	            }
	        }
	    }
	
	}
