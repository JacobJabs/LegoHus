/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Exceptions.LoginSampleException;
import Function.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author J.Jabr
 */
public class OrderMapper {
    
    public static void createOrder( Order order, int userid ) throws LoginSampleException {
        try {
            Connection con = DBConnecter.connection();
            String SQL = "INSERT INTO `order` ( length, width, height, fk_userid ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, userid);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException(ex.getMessage() );
        }
    }
    
    public static ArrayList<Order> getOrdersByUserID( int userid ) throws LoginSampleException {
        try {
            Connection con = DBConnecter.connection();
            String SQL = "SELECT * FROM `order` "
                    + "WHERE fk_userid=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, userid );
            ResultSet rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while ( rs.next() ) {
                Order order = new Order( rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"));
                orders.add( order );
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage() );
            
        }
        }
    
     public static Order getOrderByOrderID( int orderid ) throws LoginSampleException {
        try {
            Connection con = DBConnecter.connection();
            String SQL = "SELECT * FROM `order` "
                       + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, orderid );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
            Order order = new Order( rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"));
                return order;
            } else {
                throw new LoginSampleException("Could not find order" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage() );
        }
    }
}
