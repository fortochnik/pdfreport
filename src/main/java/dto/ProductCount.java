package dto;

/**
 * Created by mipan on 21.11.2016.
 */
public class ProductCount {
    private int id;
    private String name;
    private Long count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
