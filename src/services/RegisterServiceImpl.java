package services;
import java.sql.*;

import main.DB2ConnectionManager;
import materials.EstateAgent;

public class RegisterServiceImpl implements RegisterServiceIF {

    private Connection connection;
    private Statement stmt;
    
    public RegisterServiceImpl() {
	try {
	    connection = DB2ConnectionManager.getInstance().getConnection();
	    stmt = connection.createStatement();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public boolean registerEstateAgent(EstateAgent agent) {
	try {
	    String sqlInsertStatement = 
		    "INSERT INTO " 
	          + "estate_agent(name, address, login, password) "
		  + "VALUES (?, ?, ?, ?)";

	    PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
	    prepStmt.setString(1, agent.getName());
	    prepStmt.setString(2, agent.getAddress());
	    prepStmt.setString(3, agent.getLogin());
	    prepStmt.setString(4, agent.getPassword());
	    prepStmt.executeUpdate();
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean estateAgentExist(String loginName) {
	try {
	    String sqlSelectStatement = 
			  "SELECT * "
			+ "FROM estate_agent "
			+ "WHERE login = '" + loginName + "'";

	    ResultSet resultSelt = stmt.executeQuery(sqlSelectStatement);
	    return resultSelt.next();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean deleteEstateAgent(String loginName) {
	if(estateAgentExist(loginName)) {
	    try {
		String sqlDeleteStatement = 
			"DELETE FROM estate_agent "
		      + "WHERE login = '" + loginName + "'";
		
		stmt.executeUpdate(sqlDeleteStatement);
		return true;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return false;
    }

    @Override
    public boolean updateColumnInEstateAgent(String column, String loginName, String newAttribute) {
	if(estateAgentExist(loginName)) {
	    try {
		String sqlUpdateStatement = 
			"UPDATE estate_agent "
		      + "SET " + column + " = '" + newAttribute + "' " 
		      + "WHERE login = '" + loginName + "'";
		
		stmt.executeUpdate(sqlUpdateStatement);
		return true;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return false;
    }

}
