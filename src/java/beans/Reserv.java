package beans;

/**
 *
 * @author dmitry
 */
public class Reserv {
    
    private int id;
    private int idUser;
    private int idProduct;
    private int kol;

    public Reserv(int id, int idUser, int idProduct, int kol) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.kol = kol;
    }

    public Reserv() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the kol
     */
    public int getKol() {
        return kol;
    }

    /**
     * @param kol the kol to set
     */
    public void setKol(int kol) {
        this.kol = kol;
    }
    
}
