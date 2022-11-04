package sec01.ex02;

import java.sql.Date;

public class BoardVO {
	private int BNO;
	private String TITLE;
	private String CONTENT;
	private String WRITER;
	private Date REGDATE;
	private Date UPDATEDATE;
	
	public BoardVO(int bNO, String tITLE, String cONTENT, String wRITER, Date rEGDATE, Date uPDATEDATE) {
		BNO = bNO;
		TITLE = tITLE;
		CONTENT = cONTENT;
		WRITER = wRITER;
		REGDATE = rEGDATE;
		UPDATEDATE = uPDATEDATE;
	}
	public int getBNO() {
		return BNO;
	}
	public void setBNO(int bNO) {
		BNO = bNO;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}
	public Date getUPDATEDATE() {
		return UPDATEDATE;
	}
	public void setUPDATEDATE(Date uPDATEDATE) {
		UPDATEDATE = uPDATEDATE;
	}
	@Override
	public String toString() {
		return "BoardVO [BNO=" + BNO + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", WRITER=" + WRITER + ", REGDATE="
				+ REGDATE + ", UPDATEDATE=" + UPDATEDATE + "]";
	}
	
	
	
	
	

}
