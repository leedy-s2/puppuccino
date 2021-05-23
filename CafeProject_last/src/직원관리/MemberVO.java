package 직원관리;

public class MemberVO {
	private int mem_no;
	private String mem_id;
	private String mem_password;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private int mem_level;
	private int mem_point;
	private int mem_denied;
	private String memc_sdate;
	private String memc_edate;

	public MemberVO(String mem_id, String mem_password, String mem_name, String mem_phone, String mem_email,
			int mem_level, int mem_point, int mem_denied, String memc_sdate, String memc_edate) {
		super();
		this.mem_id = mem_id;
		this.mem_password = mem_password;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_level = mem_level;
		this.mem_point = mem_point;
		this.mem_denied = mem_denied;
		this.memc_sdate = memc_sdate;
		this.memc_edate = memc_edate;
	}

	public MemberVO(String name, String phone, int denied) {
		this.mem_name = name;
		this.mem_phone = phone;
		this.mem_denied = denied;
	}

	public MemberVO(int denied, String selid, String selpw) {
		this.mem_id = selid;
		this.mem_password = selpw;
		this.mem_denied = denied;

	}

	public MemberVO(String mem_id, String mem_password, String mem_name, String mem_phone, String mem_email,
			int denied) {
		this.mem_id = mem_id;
		this.mem_password = mem_password;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_denied = denied;
	}

	public MemberVO(String mem_name) {
		this.mem_name = mem_name;
	}

	public MemberVO(int mem_no) {
		this.mem_no = mem_no;
	}

	public MemberVO(int mem_no, String mem_id) {
		this.mem_no = mem_no;
		this.mem_id = mem_id;
	}

	public MemberVO(String id, String pw) {
		this.mem_id = id;
		this.mem_password = pw;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getMem_password() {
		return mem_password;
	}

	public String getMem_name() {
		return mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public int getMem_level() {
		return mem_level;
	}

	public int getMem_point() {
		return mem_point;
	}

	public int getMem_denied() {
		return mem_denied;
	}

	public String getMemc_sdate() {
		return memc_sdate;
	}

	public String getMemc_edate() {
		return memc_edate;
	}

}