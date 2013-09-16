package com.example.phonemate.data.types;

public class VoiceRecordingItem {

	String uri;
	String callSid;
	String dateCreated;
	
	
	
	
	
	public VoiceRecordingItem(String uri, String callSid, String dateCreated) {
		super();
		this.uri = uri;
		this.callSid = callSid;
		this.dateCreated = dateCreated;
	}
	
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
	
}
