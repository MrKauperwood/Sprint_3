package responses;

import java.util.List;

/**
 * Author: Alexey Bondarenko
 * Date: 17.04.2022
 */
public class ListOfOrdersResponse {

    private List<Order> orders;
    private PageInfo pageInfo;
    private List<AvailableStations> availableStations;

    public ListOfOrdersResponse() {
    }

    public ListOfOrdersResponse(List<Order> orders, PageInfo pageInfo, List<AvailableStations> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AvailableStations> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<AvailableStations> availableStations) {
        this.availableStations = availableStations;
    }
}
