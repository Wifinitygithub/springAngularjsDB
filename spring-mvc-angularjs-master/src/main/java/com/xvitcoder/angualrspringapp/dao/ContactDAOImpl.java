package com.xvitcoder.angualrspringapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.xvitcoder.angualrspringapp.beans.Train;
import com.xvitcoder.angualrspringapp.controller.TrainController;

//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class ContactDAOImpl implements ContactDAO {
 
	 final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);
    private JdbcTemplate jdbcTemplate;
 
    public static boolean isEnabled(){
        return true;
    }

    public static void log(Object o){
        System.out.println(o.toString());
    }
    

    
    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    public void saveOrUpdate(Train contact) {
        if (ContactDAOImpl.isEnabled())
        	ContactDAOImpl.log("message here");
        
        logger.debug("5666666666666666666666");
    	/*if (contact.getId() > 0) {
            // update
            String sql = "UPDATE train SET id=1, name='uday', speed=234, "
                        + "diesel=true WHERE id=1";
            jdbcTemplate.update(sql, 1, contact.getName(),
                    contact.getSpeed(), contact.getDiesel());
        } else {
        	*/logger.debug("99999999999999999999999999999999");
            // insert
            String sql = "INSERT INTO train (id, name, speed, diesel)"
                        + " VALUES (?,?,?,?)";
            logger.debug("88888888888888888888888888888888");
            jdbcTemplate.update(sql, 1, contact.getName(),
                    contact.getSpeed(), contact.getDiesel());
            
        //}
    }
 
    public void delete(int contactId) {
    	 String sql = "DELETE FROM train WHERE id=?";
    	    jdbcTemplate.update(sql, contactId);
    }
 
    public List<Train> list() {
    	 String sql = "SELECT * FROM train";
    	    List<Train> listContact = jdbcTemplate.query(sql, new RowMapper<Train>() {
    	 
    	        public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
    	        	Train aContact = new Train();
    	 
    	            aContact.setId((long) rs.getInt("id"));
    	            aContact.setName(rs.getString("name"));
    	            aContact.setSpeed(rs.getInt("speed"));
    	            aContact.setDiesel(rs.getBoolean("diesel"));    	           
    	            return aContact;
    	        }
    	 
    	    });
    	 
    	    return listContact;
    }
 
    public Train get(int contactId) {
    	 String sql = "SELECT * FROM train WHERE id=" + contactId;
    	    return jdbcTemplate.query(sql, new ResultSetExtractor<Train>() {
    	 
    	        public Train extractData(ResultSet rs) throws SQLException,
    	                DataAccessException {
    	            if (rs.next()) {
    	            	Train aContact = new Train();
    	            	aContact.setId((long) rs.getInt("id"));
        	            aContact.setName(rs.getString("name"));
        	            aContact.setSpeed(rs.getInt("speed"));
        	            aContact.setDiesel(rs.getBoolean("diesel")); 
    	                return aContact;
    	            }
    	 
    	            return null;
    	        }
    	 
    	    });
    }
 
}