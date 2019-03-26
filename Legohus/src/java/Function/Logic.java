/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Data.OrderMapper;
import Data.UserMapper;
import Exceptions.LoginSampleException;
import java.util.ArrayList;
import javax.security.auth.login.LoginException;

/**
 *
 * @author J.Jabr
 */
public class Logic {
    
    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User( email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder( int length, int width, int height, int userid ) throws LoginSampleException{
        Order order = new Order( length, width, height );
        OrderMapper.createOrder( order, userid );
        return order;
    }
    
    public static ArrayList<Order> getOrdersByUserID( int userid ) throws LoginSampleException {
        return OrderMapper.getOrdersByUserID( userid );
    }
   
        
    public static Order getOrderByOrderID( int orderid ) throws LoginSampleException {
        return OrderMapper.getOrderByOrderID( orderid );
    }
    
    public static Bricks calculateBricks( User user, int id ) throws LoginSampleException {
        Order order = OrderMapper.getOrderByOrderID(id);
        LegoHouseCalcu lhc = new LegoHouseCalcu();
        return lhc.makeLegoHous( order.getLength(), order.getWidth(), order.getHeight() );
    }
}
