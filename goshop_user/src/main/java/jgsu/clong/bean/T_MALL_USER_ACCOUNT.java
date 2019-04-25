package jgsu.clong.bean;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class T_MALL_USER_ACCOUNT {

	@FormParam("id")
	private int id;
	@FormParam("yh_mch")
	private String yh_mch;
	@FormParam("yh_nch")
	private String yh_nch;
	@FormParam("yh_mm")
	private String yh_mm;
	@FormParam("yh_xm")
	private String yh_xm;
	@FormParam("yh_shjh")
	private String yh_shjh;
	@FormParam("yh_yx")
	private String yh_yx;
	@FormParam("yh_tx")
	private String yh_tx;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYh_mch() {
		return yh_mch;
	}

	public void setYh_mch(String yh_mch) {
		this.yh_mch = yh_mch;
	}

	public String getYh_nch() {
		return yh_nch;
	}

	public void setYh_nch(String yh_nch) {
		this.yh_nch = yh_nch;
	}

	public String getYh_mm() {
		return yh_mm;
	}

	public void setYh_mm(String yh_mm) {
		this.yh_mm = yh_mm;
	}

	public String getYh_xm() {
		return yh_xm;
	}

	public void setYh_xm(String yh_xm) {
		this.yh_xm = yh_xm;
	}

	public String getYh_shjh() {
		return yh_shjh;
	}

	public void setYh_shjh(String yh_shjh) {
		this.yh_shjh = yh_shjh;
	}

	public String getYh_yx() {
		return yh_yx;
	}

	public void setYh_yx(String yh_yx) {
		this.yh_yx = yh_yx;
	}

	public String getYh_tx() {
		return yh_tx;
	}

	public void setYh_tx(String yh_tx) {
		this.yh_tx = yh_tx;
	}

}
