package com.grayMatter.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class DBUtils implements DBInterface {

Connection con=null;
	
	@Override
	public List<Regions> getAll() throws SQLException{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM regions");
		List<Regions> rlist = new ArrayList<Regions>();
		while(rs.next()) {
			rlist.add(new Regions(rs.getInt(1), rs.getString(2)));
		}
		return rlist;
	}

	@Override
	public Regions addRegion(Regions r) throws SQLException {
		int count=0;
		Regions savedRegion = null;
		PreparedStatement ps = con.prepareStatement("INSERT INTO regions VALUES(?, ?)");
		ps.setInt(1, r.getRid());
		ps.setString(2, r.getRname());
		count=ps.executeUpdate();
		if(count>0)
			System.out.println("Added Record");
		else
			System.out.println("Error: Record Not Added");
		
		ps =con.prepareStatement("SELECT * FROM regions WHERE region_id=?");
		ps.setInt(1, r.getRid());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			savedRegion=new Regions(rs.getInt(1), rs.getString(2));
		}
		return savedRegion;
	}

	@Override
	public void removeRegion(int rid) throws SQLException {
		int count=0;
		PreparedStatement ps = con.prepareStatement("DELETE FROM regions WHERE region_id = ?");
		ps.setInt(1, rid);
		count=ps.executeUpdate();
		if(count>0)
			System.out.println("Deleted Record");
		else
			System.out.println("Error: Record Not Deleted");
		
	}

	@Override
	public Regions updateRegion(Regions r) throws SQLException {
		int count=0;
		Regions savedRegion = null;
		PreparedStatement ps = con.prepareStatement("UPDATE regions SET region_name = ? WHERE region_id = ?");
		ps.setString(1, r.getRname());
		ps.setInt(2, r.getRid());
		count=ps.executeUpdate();
		if(count>0)
			System.out.println("Updated Record");
		else
			System.out.println("Error: Record Not Updated");
		
		ps =con.prepareStatement("SELECT * FROM regions WHERE region_id=?");
		ps.setInt(1, r.getRid());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			savedRegion=new Regions(rs.getInt(1), rs.getString(2));
		}
		return savedRegion;
	}
}
