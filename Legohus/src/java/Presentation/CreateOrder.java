/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Exceptions.LoginSampleException;
import Function.Order;
import Function.Logic;
import Function.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J.Jabr
 */
public class CreateOrder extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Order> ol = new ArrayList();
        HttpSession session = request.getSession();
        int length = Integer.parseInt( request.getParameter("length") );
        int width = Integer.parseInt( request.getParameter("width") );
        int height = Integer.parseInt( request.getParameter("height") );
        if ( length > 0 && width > 0 && height > 0 ) {
            User user = ( User ) request.getSession().getAttribute( "user" );
            ol = Logic.getOrdersByUserID( user.getId() );
            Logic.createOrder( length, width, height, user.getId() );
            session.setAttribute( "ordersByUserID", ol );
        } else {
            throw new LoginSampleException("Some of the inputs are either empty or below 1" );
        }
        return "vieworders";
    }
}
