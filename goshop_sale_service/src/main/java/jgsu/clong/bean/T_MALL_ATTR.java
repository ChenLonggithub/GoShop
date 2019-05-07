package jgsu.clong.bean;

import java.io.Serializable;
import java.util.Date;

public class T_MALL_ATTR  implements Serializable {

	private int id;
	//属性名称
	private String shxm_mch;
	//是否启用
	private String shfqy;
	//分类编号2
	private int flbh2;
	private Date chjshj;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShxm_mch() {
		return shxm_mch;
	}

	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}

	public String getShfqy() {
		return shfqy;
	}

	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}

	public int getFlbh2() {
		return flbh2;
	}

	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	@Override
	public String toString() {
		return "T_MALL_ATTR{" +
				"id=" + id +
				", shxm_mch='" + shxm_mch + '\'' +
				", shfqy='" + shfqy + '\'' +
				", flbh2=" + flbh2 +
				", chjshj=" + chjshj +
				'}';
	}
}
