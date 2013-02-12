<%-- 
    Document   : result
    Created on : Feb 3, 2013, 2:30:57 PM
    Author     : Jenni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Order:</h1>
        <p>
            <% String entree = (String) request.getAttribute("entree");
            String entreeCost = (String) request.getAttribute("entreeCost");
            String side = (String) request.getAttribute("side");
            String sideCost = (String) request.getAttribute("sideCost");
            String drink = (String) request.getAttribute("drink");
            String drinkCost = (String) request.getAttribute("drinkCost");
            String totalCost = (String) request.getAttribute("totalCost");
            String tax = (String) request.getAttribute("tax");
            String tip = (String) request.getAttribute("suggestedTip");
            
            out.println("Entree: " + entree + "  $" + entreeCost +"<br/>");
            out.println("Side: " + side + "  $" + sideCost + "<br/>");
            out.println("Drink: " + drink + "  $" + drinkCost +"<br/>");
            out.println("Total:  $" + totalCost+ "<br/>" );
            out.println("Tax:  $" + tax +"<br/>" );
            out.println("Suggested Tip:  $" + tip +"<br/>");
            %>
        </p>
    </body>
</html>
