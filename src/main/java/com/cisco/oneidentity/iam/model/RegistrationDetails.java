package com.cisco.oneidentity.iam.model;

public class RegistrationDetails {
	
	private PartyDetails party;
	
	private RequestBase get;

	public PartyDetails getParty() {
		return party;
	}

	public void setParty(PartyDetails party) {
		this.party = party;
	}

	public RequestBase getGet() {
		return get;
	}

	public void setGet(RequestBase get) {
		this.get = get;
	}
	
	
}
