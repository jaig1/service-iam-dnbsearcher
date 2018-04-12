package com.cisco.oneidentity.iam.model;

import java.util.List;

public class Parties {
	private String dunsNumber;	 
	private String nodeType;
	private List<PartyAddress> data ;
	private Hierarchy hierarchy;
	private ExtAttributes extAttributes;
	
	public String getDunsNumber() {
		return dunsNumber;
	}
	public void setDunsNumber(String dunsNumber) {
		this.dunsNumber = dunsNumber;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public List<PartyAddress> getData() {
		return data;
	}
	public void setData(List<PartyAddress> data) {
		this.data = data;
	}
	public Hierarchy getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(Hierarchy hierarchy) {
		this.hierarchy = hierarchy;
	}
	public ExtAttributes getExtAttributes() {
		return extAttributes;
	}
	public void setExtAttributes(ExtAttributes extAttributes) {
		this.extAttributes = extAttributes;
	}
	
}
