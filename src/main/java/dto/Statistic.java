package dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mipan on 20.11.2016.
 */
public class Statistic {
    private List<ProductCount> topTenProduct;
    private List<UserOrder> topTenUser;
    private BigDecimal proceedsByWeek;
    private BigDecimal proceedsByMonth;

    public List<ProductCount> getTopTenProduct() {
        return topTenProduct;
    }

    public void setTopTenProduct(List<ProductCount> topTenProduct) {
        this.topTenProduct = topTenProduct;
    }

    public List<UserOrder> getTopTenUser() {
        return topTenUser;
    }

    public void setTopTenUser(List<UserOrder> topTenUser) {
        this.topTenUser = topTenUser;
    }

    public BigDecimal getProceedsByWeek() {
        return proceedsByWeek;
    }

    public void setProceedsByWeek(BigDecimal proceedsByWeek) {
        this.proceedsByWeek = proceedsByWeek;
    }

    public BigDecimal getProceedsByMonth() {
        return proceedsByMonth;
    }

    public void setProceedsByMonth(BigDecimal proceedsByMonth) {
        this.proceedsByMonth = proceedsByMonth;
    }
}
