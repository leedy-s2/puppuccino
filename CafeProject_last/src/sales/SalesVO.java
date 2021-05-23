package sales;


public class SalesVO {


	/*DAO : data/access/object
	 <* VO : value object>
	 * MVC : model(데이터) / view(보여지는 뷰단) / control(제어. 작동)
	 * 아래처럼만 설정해줘도 vo 완성. 생성자 생성 + getters 확보
	 */
	
	private String item;
	private int num;
	private int pay;
	private String day;
	private int sum;
	
	private String month;
	private int sales;
	
	public SalesVO() {
		super();
		this.day = day;
	}
	public SalesVO(int sales) {
		super();
		this.sales = sales;
	}
	public String getMonth() {
		return month;
	}
	public int getSales() {
		return sales;
	}
	public SalesVO(String item, int pay) {
		super();
		this.item = item;
		this.pay = pay;
	}
	public String getItem() {
		return item;
	}
	public int getNum() {
		return num;
	}
	public int getPay() {
		return pay;
	}
	public String getDay() {
		return day;
	}





}
