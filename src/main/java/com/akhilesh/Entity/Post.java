package com.akhilesh.Entity;

import java.util.*;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int pid;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	@Column(name = "likes")
	private double likes;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@JsonbDateFormat("dd/MM/yyyy")
	@Column(name = "creation_date")
	private Date creationData;

	public Post() {
		super();
	}

	public Post(List<Comment> comments, double likes, Date creationData) {
		super();
		this.comments = comments;
		this.likes = likes;
		this.creationData = creationData;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public double getLikes() {
		return likes;
	}

	public void setLikes(double likes) {
		this.likes = likes;
	}

	public Date getCreationData() {
		return creationData;
	}

	public void setCreationData(Date creationData) {
		this.creationData = creationData;
	}

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", comments=" + comments + ", likes=" + likes + ", creationData=" + creationData
				+ "]";
	}

	
		
}
