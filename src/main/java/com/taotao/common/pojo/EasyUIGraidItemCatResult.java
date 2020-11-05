package com.taotao.common.pojo;

/**
 * 该实体类用于EasyUI页面和后台进行数据传输
* <p>Title: EasyUIGraidItemCatResult.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-24_10:51:43
* @version 1.0
 */
public class EasyUIGraidItemCatResult {
	
	private Long id;
	private String text;
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
