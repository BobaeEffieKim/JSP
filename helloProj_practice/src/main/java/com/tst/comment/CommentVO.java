package com.tst.comment;


public class CommentVO {

	private int boardId;
	private int commentId;
	private String commentContent;
	private String userId;
	private String commentDate;
	
	public CommentVO() {
	}

	public CommentVO(int boardId, int commentId, String commentContent, String userId, String commentDate) {
		super();
		this.boardId = boardId;
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.userId = userId;
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "commentVO [boardId=" + boardId + ", commentId=" + commentId + ", commentContent=" + commentContent
				+ ", userId=" + userId + ", commentDate=" + commentDate + "]";
	}

	
	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
}
