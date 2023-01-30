package Servlet;

import Model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "Guest The Number", urlPatterns = "/guestTheNumber")
public class GuestTheNumber extends HttpServlet {

    public static String  toInt (String num)
    {
        String []numList = num.split(" ");
        String finalString = "";
        for (String item :numList
        ) {
            if (!item.equals(" "))
            {
                finalString+=item ;
            }
        }
        return finalString;
    }
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("start", start); //start =0
        req.getRequestDispatcher("guestTheNumber.jsp").forward(req, resp);

    }

    Player player1 = new Player("Tam");
    Player player2 = new Player("Thanh");
    Player player3 = new Player("Minh");
    List<Player> playerList = new ArrayList<>();

    int countTimes; //count times for each player
    int rand;
    int count = 0; //start from player 0
    int start = count;
    int number = 0;

    //back from guestTheNumber.jsp
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numGuest;

        //----------------initialize player list----------------
        if (start == 0) //first time at start =0
        {
            String numberr = req.getParameter("number");
            if (isNumeric(numberr))
            {
                System.out.println("yes");
                number = Integer.parseInt(toInt(numberr));  //to count how many players
            }
           else
            {
                System.out.println("no");
                req.getRequestDispatcher("guestTheNumber.jsp").forward(req, resp);
                resp.sendRedirect("http://localhost:8080/guestTheNumber");
                return ;
            }
        }

        if (start != -1) {


            if (start >= 1) {
                String name = req.getParameter("playerName");
                start += 1;
                playerList.add(new Player(name));
                req.setAttribute("start", start);
                if (start - 1 == number) {
                    start = -1;
                }

            }
            if (start == 0) {
                start += 1;
                req.setAttribute("start", start);
            }

        }

        //after initialize , start =-1
        //---------------Each player guess---------------
        if (start == -1) {
            req.setAttribute("start", start); //set variable : start
            countTimes = playerList.get(count).getCountTimes(); //countTimes start at 0
            if (count == 0 && countTimes == 0) //start at this point
            {
                numGuest = 0;
                req.setAttribute("count", 0); //set variable : numGuess
            } else {

                numGuest = Integer.parseInt(toInt(req.getParameter("numGuest"))); //to take the guesting number from file jsp

            }
            rand = playerList.get(count).getRandNum();

            //set attribute again
            req.setAttribute("name", playerList.get(count).getName());
            req.setAttribute("rand", rand);
            if (count >=1 )
            {
                req.setAttribute("countTimes", countTimes+1);
            }
            else
            {
                req.setAttribute("countTimes", countTimes);
            }
            req.setAttribute("numGuest", numGuest);
            req.setAttribute("count", count);

            playerList.get(count).setCountTimes(++countTimes); //increase count times

            //after player finish own game , turn to next player
            if (numGuest == rand) {

                count += 1; //turn to next player

                //if this is the last player
                if (count == playerList.size()) {
                    System.out.println("final = " + (playerList.size()));
                    countTimes = -1;
                    req.setAttribute("countTimes", countTimes);
                    Collections.sort(playerList);
                    req.setAttribute("playerList", playerList);

                } else {
                    countTimes = 0;
                    rand = playerList.get(count).getRandNum();

                    req.setAttribute("name", playerList.get(count).getName());
                    req.setAttribute("rand", rand);
                    req.setAttribute("countTimes", countTimes);
                }
            }
        }

        req.getRequestDispatcher("guestTheNumber.jsp").forward(req, resp);

    }
}
