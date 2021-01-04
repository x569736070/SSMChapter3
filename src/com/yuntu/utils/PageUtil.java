package com.yuntu.utils;

import java.util.List;


public class PageUtil<T> {
	//五个属性
	private int pageindex=1;//当前页(页码)
	private int pagesize=10;//页面大小
	private int counts=0;//记录总数
	private int pagecount=0;//总页数
	private int pageindexis;
	private List<T> lists;//保存当前页对象的集合
	//复用

	//get、set

	public int getPageindexis() {
		return (pageindex-1)*pagesize;
	}

	public void setPageindexis(int pageindexis) {
		this.pageindexis = pageindexis;
	}

	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
		//在设置总记录数时，一并设置总页数
		if(counts>0){
			if(counts%pagesize==0){//判断是否能整除
				pagecount=counts/pagesize;
			}else{
				pagecount=counts/pagesize+1;
			}
		}
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	/*private Integer currentPage;
	private Integer startIndex;
	private Integer pageSize=5;
	private Integer totalCount;
	private Integer totalPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		this.startIndex=(this.currentPage-1)*this.pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		//计算总页数
		this.totalPage=(int)Math.ceil((this.totalCount*1.0/this.pageSize));
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	*/
	
}
