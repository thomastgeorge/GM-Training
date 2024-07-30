package com.grayMatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App  implements PersonInterface {

	@Override
	public List<Person> getAllPersonsInfo() throws ClassNotFoundException, SQLException {
		String query="SELECT * FROM persons";
		
		DataSourceClass dc = new DataSourceClass();
		Connection con = DataSourceClass.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Person> lp = new ArrayList<>();
		lp=null;
		while(rs.next()) {
			lp.add(new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		return lp;
	}

	@Override
	public Person getPerson(int id) throws ClassNotFoundException, SQLException {
		String query="SELECT * FROM persons WHERE id=?";
		
		DataSourceClass dc = new DataSourceClass();
		Connection con = DataSourceClass.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 2);
		Person person = null;
		try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("mobile"), rs.getString("email"));
            }
        }
		return person;
	}

	@Override
	public Person addPerson(Person person) throws ClassNotFoundException, SQLException {
		 String query = "INSERT INTO persons (id, name, age, mobile, email) VALUES (?, ?, ?, ?, ?)";

		 Connection con = DataSourceClass.getConnection();
	     try (PreparedStatement pm = con.prepareStatement(query)) {
	    	 pm.setInt(1, person.getId());
	         pm.setString(3, person.getName());
	         pm.setInt(2, person.getAge());
	         pm.setString(4, person.getMobile());
	         pm.setString(5, person.getEmail());

	         int affectedRows = pm.executeUpdate();
	         if (affectedRows == 0) {
	             throw new SQLException("Inserting person failed, no rows affected.");
	         }
	     }
	     return person;
	}

	@Override
	public Person updatePerson(Person person, int id) throws ClassNotFoundException, SQLException {
		String query = "UPDATE persons SET age = ?, name = ?, mobile = ?, email = ? WHERE id = ?";

		Connection con = DataSourceClass.getConnection();
        try (PreparedStatement pm = con.prepareStatement(query)) {
            pm.setString(2, person.getName());
            pm.setInt(1, person.getAge());
            pm.setString(3, person.getMobile());
            pm.setString(4, person.getEmail());
            pm.setInt(5, id);

            pm.executeUpdate();           
        }
        return person;
	}

	@Override
	public Person deletePerson(int id) throws ClassNotFoundException, SQLException {
		Person person = getPerson(id);

        if (person == null) {
            return null;
        }

        String deleteQuery = "DELETE FROM persons WHERE id = ?";

		Connection con = DataSourceClass.getConnection();
        try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
        }
        return person;
	}
	
	public static void main( String[] args )
    {
        
        
    }
}
