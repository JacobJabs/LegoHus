/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Exceptions.LoginSampleException;
import Function.Logic;
import Function.Order;
import Function.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J.Jabr
 */
public class ShowOrders extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Order> ol = new ArrayList();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            ol = Logic.getOrdersByUserID(user.getId());
            session.setAttribute("ordersByUserID", ol);
        } 
       
        return "ShowOrders";
    }
}
