package br.com.geradorASN.entity.rest.v4.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

	@JsonProperty("Id")
	private Integer Id;

	@JsonProperty("Comment")
	private String Comment;

	@JsonProperty("IsPublic")
	private Boolean IsPublic;

	@JsonProperty("CreationDateTime")
	private String CreationDateTime;

	public Integer getId() {
		return Id;
	}

	public String getComment() {
		return Comment;
	}

	public boolean getIsPublic() {
		return IsPublic;
	}

	public String getCreationDateTime() {
		return CreationDateTime;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public void setComment(String Comment) {
		this.Comment = Comment;
	}

	public void setIsPublic(boolean IsPublic) {
		this.IsPublic = IsPublic;
	}

	public void setCreationDateTime(String CreationDateTime) {
		this.CreationDateTime = CreationDateTime;
	}

	@Override
	public String toString() {
		return "Comment [Id=" + Id + ", Comment=" + Comment + ", IsPublic=" + IsPublic + ", CreationDateTime="
				+ CreationDateTime + "]";
	}

}