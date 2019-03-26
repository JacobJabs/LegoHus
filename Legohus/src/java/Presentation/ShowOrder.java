/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Exceptions.LoginSampleException;
import Function.Bricks;
import Function.Logic;
import Function.Order;
import Function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J.Jabr
 */
public class ShowOrder extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            int orderid = Integer.parseInt(request.getParameter("orderID"));
            Order order = Logic.getOrderByOrderID(orderid);
            Bricks b = Logic.calculateBricks(user, orderid);
            session.setAttribute("order", order);
            session.setAttribute("orderID", orderid);
            session.setAttribute("bricks", b);
        } else {
            throw new LoginSampleException(".");
        }
        return "Orders";
    }
}
