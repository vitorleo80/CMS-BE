package io.cms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@Entity
@Table(name = "article")
public class Article extends AbstractEntity {

	private String title;
	private String slug;
	private String imageUrl;
	private String content;
	private boolean published;
	@ElementCollection
	@CollectionTable(name = "article_tags", joinColumns = @JoinColumn(name = "article_id"))
	private List<String> tags = new ArrayList<String>();
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Version
	private Long version;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
