package co.edu.vo;

public class MemberVO {
	
	String memberId;
	String memberPasswd;
	String memberName;
	String memberAddress;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPasswd() {
		return memberPasswd;
	}
	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	
	public MemberVO() {}
	
	public MemberVO(String memberId, String memberPasswd, String memberName, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPasswd = memberPasswd;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
	}
	
	
	

	
}
