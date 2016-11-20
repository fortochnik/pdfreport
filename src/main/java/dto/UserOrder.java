package dto;

/**
 * Created by mipan on 21.11.2016.
 */
public class UserOrder {
    private int id;
    private String login;
    private Long ordersQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getOrdersQuantity() {
        return ordersQuantity;
    }

    public void setOrdersQuantity(Long ordersQuantity) {
        this.ordersQuantity = ordersQuantity;
    }
}
