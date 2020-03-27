package com.ese.crud.member.model.vo;

public class MemberVO {
	
	private int memberNo;
	private String memberName;
	private int deptNo;
	private String deptName;
	
	private int startIndex;
	private int cntperPage;
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCntperPage() {
		return cntperPage;
	}
	public void setCntperPage(int cntperPage) {
		this.cntperPage = cntperPage;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberName=" + memberName + ", deptNo=" + deptNo + ", deptName="
				+ deptName + "]";
	}
}
