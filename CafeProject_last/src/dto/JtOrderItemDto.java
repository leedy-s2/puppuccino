package dto;

public class JtOrderItemDto {
    private int odi_no;
    private int od_no;
    private int it_no;
    private String odi_name;
    private String odi_date;
    private int odi_price;
    private int mem_no;
    private int odi_cnt;

    public int getOdi_no() {
        return odi_no;
    }
    
    public int getOd_no() {
        return od_no;
    }
    
    public int getIt_no() {
        return it_no;
    }
    
    public String getOdi_name() {
        return odi_name;
    }
    
    public String getOdi_date() {
        return odi_date;
    }
    
    public int getOdi_price() {
        return odi_price;
    }
    
    public int getOdi_cnt() {
        return odi_cnt;
    }
    
    public int getMem_no() {
        return mem_no;
    }
    
    public JtOrderItemDto(int od_no, int it_no, String odi_name, int odi_price, int mem_no) {
        this.od_no = od_no;
        this.it_no = it_no;
        this.odi_name = odi_name;
        this.odi_price = odi_price;
        this.mem_no = mem_no;
    }

    public JtOrderItemDto(int od_no, int it_no, String odi_name, int odi_price, int odi_cnt, int mem_no) {
        this.od_no = od_no;
        this.it_no = it_no;
        this.odi_name = odi_name;
        this.odi_price = odi_price;
        this.odi_cnt = odi_cnt;
        this.mem_no = mem_no;
    }

    public JtOrderItemDto(int od_no) {
        this.od_no = od_no;
    }
}
