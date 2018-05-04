package beans;

import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class Reservs {
    
    private static ArrayList<Reserv> reservs = new ArrayList<>();

    /**
     * @return the reservs
     */
    public static ArrayList<Reserv> getReservs() {
        return reservs;
    }
    
    public static void addReserv(Reserv reserv){
        reservs.add(reserv);
    }
}
