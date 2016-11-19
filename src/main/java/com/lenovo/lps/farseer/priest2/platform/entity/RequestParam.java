/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * JQgrid请求参数
 * 
 * @author niexm1
 * 
 */
public class RequestParam {
	protected Integer rows = 20;// 每页显示记录数(默认每页显示20条)
	protected Integer page = 1;// 页号(默认第一页)
	protected String sidx;// 排序字段
	protected String sord;// 排序类型 asc升序排序,desc按降序排

	// 总页数
	protected Long totalPages;

	// limit 开始记录数
	protected Integer offset;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
