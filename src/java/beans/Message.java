package beans;

import java.sql.Date;

/**
 *
 * @author dmitry
 */
public class Message {
    
    private int id;
    private int from_user_id;
    private int to_user_id;
    private String text;
    private Date date;

    public Message(int id, int from_user_id, int to_user_id, String text, Date date) {
        this.id = id;
        this.from_user_id = from_user_id;
        this.to_user_id = to_user_id;
        this.text = text;
        this.date = date;
    }

    public Message() {
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
     * @return the from_user_id
     */
    public int getFrom_user_id() {
        return from_user_id;
    }

    /**
     * @param from_user_id the from_user_id to set
     */
    public void setFrom_user_id(int from_user_id) {
        this.from_user_id = from_user_id;
    }

    /**
     * @return the to_user_id
     */
    public int getTo_user_id() {
        return to_user_id;
    }

    /**
     * @param to_user_id the to_user_id to set
     */
    public void setTo_user_id(int to_user_id) {
        this.to_user_id = to_user_id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
