package com.nj.jpademo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Stock 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String scode;
	private String sname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="stock_category", 
	joinColumns=@JoinColumn(name="stockid"),
	inverseJoinColumns=@JoinColumn(name="categoryid"))
	
	private List<Category> categories;
	
	public Stock()
	{
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}
