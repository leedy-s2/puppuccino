package MEMO_dto;

public class JtMemoDto {
    private int memo_no;
    private String memo_memo;
    private String mes_date;
    private String mer_date;
    
    public int getMemo_no() {
        return memo_no;
    }
    
    public String getMemo_memo() {
        return memo_memo;
    }
    
    public String getMes_date() {
        return mes_date;
    }
    
    public String getMer_date() {
        return mer_date;
    }

    public JtMemoDto(int memo_no, String memo_memo, String mes_date, String mer_date) {
        this.memo_no = memo_no;
        this.memo_memo = memo_memo;
        this.mes_date = mes_date;
        this.mer_date = mer_date;
    }

    public JtMemoDto(String memo_memo, String mes_date) {
        this.memo_memo = memo_memo;
        this.mes_date = mes_date;
    }
    
    public JtMemoDto(int memo_no, String memo_memo, String mes_date) {
        this.memo_no = memo_no;
        this.memo_memo = memo_memo;
        this.mes_date = mes_date;
    }

    public JtMemoDto(String memo_memo) {
        this.memo_memo = memo_memo;
    }
    
    public JtMemoDto() {
        
    }
    
}
