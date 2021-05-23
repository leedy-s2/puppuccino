package 직원관리;

public class MemberAttendVO {
	private int memc_no;
	private int mem_no;
	private String mem_id;
	private String memc_sdate;
	private String memc_edate;
	private String memc_ssdate;
	private String memc_eedate;
	private String mem_name;
	
	public int getMemc_no() {
		return memc_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public String getMemc_sdate() {
		return memc_sdate;
	}
	public String getMemc_edate() {
		return memc_edate;
	}
	public String getMemc_ssdate() {
		return memc_ssdate;
	}
	public String getMemc_eedate() {
		return memc_eedate;
	}
	public MemberAttendVO(int memc_no, int mem_no, String mem_id, String memc_sdate, String memc_edate,
			String memc_ssdate, String memc_eedate) {
		super();
		this.memc_no = memc_no;
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.memc_sdate = memc_sdate;
		this.memc_edate = memc_edate;
		this.memc_ssdate = memc_ssdate;
		this.memc_eedate = memc_eedate;
	}
	public MemberAttendVO(String name) {
		this.mem_name = name;
	}
	
	public MemberAttendVO(int temp, int mem_no, String mem_id, String mem_name, String memc_sdate) {
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.memc_sdate = memc_sdate;
	}
	public MemberAttendVO(int mem_no, String mem_name, String memc_sdate, String memc_edate) {
		this.mem_no = mem_no;
		this.setMem_name(mem_name);
		this.memc_sdate = memc_sdate;
		this.memc_edate = memc_edate;
	}
	public MemberAttendVO(MemberVO vo) {
		// TODO Auto-generated constructor stub
	}
	public MemberAttendVO(int mem_no) {
		this.mem_no = mem_no;
	}
	public MemberAttendVO(int mem_no, String mem_id) {
		this.mem_no = mem_no;
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
}
