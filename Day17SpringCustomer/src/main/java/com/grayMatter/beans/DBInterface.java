package com.grayMatter.beans;

import java.sql.SQLException;
import java.util.List;

public interface DBInterface {

	public List<Regions> getAll() throws SQLException;
	public Regions addRegion(Regions r) throws SQLException;
	public void removeRegion(int rid) throws SQLException;
	public Regions updateRegion(Regions r) throws SQLException;
	
	
}
