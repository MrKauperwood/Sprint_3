package responses;

/**
 * Author: Alexey Bondarenko
 * Date: 17.04.2022
 */
public class PageInfo {
    private Integer page;
    private Integer total;
    private Integer limit;

    public PageInfo(Integer page, Integer total, Integer limit) {
        this.page = page;
        this.total = total;
        this.limit = limit;
    }

    public PageInfo() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
