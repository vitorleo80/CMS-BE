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
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author Vitor Correa
 * @date 28 Feb 2019
 */

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

	private String name;
	private String slug;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
	@JsonProperty(access = Access.WRITE_ONLY)
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
