package io.cms.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@Entity
@Table(name = "author")
public class Author extends AbstractEntity {

	private String name;
	private String email;
	private String password;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
	private List<Article> articles = new ArrayList<>();

	@Override
	@JsonIgnore
	public Date getCreatedAt() {
		return super.getCreatedAt();
	}

	@Override
	@JsonIgnore
	public Date getUpdatedAt() {
		return super.getUpdatedAt();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
