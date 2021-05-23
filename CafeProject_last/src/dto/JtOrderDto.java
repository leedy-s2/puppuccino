package dto;

public class JtOrderDto {

    private int od_no;
    private String od_name;
    private String od_date;
    private int od_price;
    private int mem_no;

    public int getOd_no() {
        return od_no;
    }

    public String getOd_name() {
        return od_name;
    }

    public String getOd_date() {
        return od_date;
    }

    public int getOd_price() {
        return od_price;
    }

    public int getMem_no() {
        return mem_no;
    }

    public JtOrderDto(String od_name, int od_price, int mem_no) {
        this.od_name = od_name;
        this.od_price = od_price;
        this.mem_no = mem_no;
    }

    public JtOrderDto(int od_no, int od_price) {
        this.od_no = od_no;
        this.od_price = od_price;
    }
    
    public JtOrderDto(int od_price) {
        this.od_price = od_price;
    }

}
