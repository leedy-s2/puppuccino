package goods;

public class GoodsVO {
    private int it_no;
    private int ca_no;
    private String it_name;
    private int it_price;
    private int it_cust_price;
    private int it_order;
    private int it_use;
    private String it_date;

    public GoodsVO(int it_no, int ca_no, String it_name, int it_price, int it_cust_price, String it_date) {
        super();
        this.it_no = it_no;
        this.ca_no = ca_no;
        this.it_name = it_name;
        this.it_price = it_price;
        this.it_cust_price = it_cust_price;
        this.it_date = it_date;
    }

    public GoodsVO(int ca_no, String it_name, int it_price, int it_cust_price) {
        super();
        this.ca_no = ca_no;
        this.it_name = it_name;
        this.it_price = it_price;
        this.it_cust_price = it_cust_price;
    }

    public GoodsVO(String name, int it_price, int it_cust_price, int ca_no) {
        super();
        this.it_no = ca_no;
        this.it_name = name;
        this.it_price = it_price;
        this.it_cust_price = it_cust_price;
    }

    public int getIt_no() {
        return it_no;
    }

    public int getCa_no() {
        return ca_no;
    }

    public String getIt_name() {
        return it_name;
    }

    public int getIt_price() {
        return it_price;
    }

    public int getIt_cust_price() {
        return it_cust_price;
    }

    public int getIt_order() {
        return it_order;
    }

    public int getIt_use() {
        return it_use;
    }

    public String getIt_date() {
        return it_date;
    }

}
