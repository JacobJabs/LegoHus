/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;


import Exceptions.LoginSampleException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author J.Jabr
 */
@WebServlet( name = "FrontController", urlPatterns = { "/FrontController" } )
public class FrontController extends HttpServlet{
    
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            Command action = Command.from( request );
            String view = action.execute( request, response );
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
        } catch ( LoginSampleException ex ) {
            request.setAttribute( "error", ex.getMessage() );
            request.getRequestDispatcher( "index.jsp" ).forward( request, response );
        }
    }

    
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
