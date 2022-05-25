package com.akhilesh.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	@Lob
	@Column(name = "content")
	private String content;
		
	@ManyToOne
	@JoinColumn(name = "mycid", referencedColumnName = "pid")
	private Post post;

	public Comment() {
		super();
	}

	public Comment(String content, Post post) {
		super();
		this.content = content;
		this.post = post;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", content=" + content + ", post=" + post + "]";
	}
	
	
}
