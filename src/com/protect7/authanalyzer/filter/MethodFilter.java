package com.protect7.authanalyzer.filter;

import burp.IBurpExtenderCallbacks;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import burp.IResponseInfo;

public class MethodFilter extends RequestFilter {
	
	public MethodFilter(int filterIndex, String description) {
		super(filterIndex, description);
		setFilterStringLiterals(new String[]{"OPTIONS"});
	}

	@Override
	public boolean filterRequest(IBurpExtenderCallbacks callbacks, int toolFlag, IRequestInfo requestInfo, IResponseInfo responseInfo) {
		if(onOffButton.isSelected()) {		
			String requestMethod = requestInfo.getMethod();
			for(String method : stringLiterals) {
				if(requestMethod.toLowerCase().equals(method.toLowerCase()) && !method.trim().equals("")) {
					incrementFiltered();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean filterBody(IBurpExtenderCallbacks callbacks, int toolFlag, IHttpRequestResponse messageInfo) {
		return false;
	}

	public Type getType() {
		return null;
	}

	@Override
	public boolean hasStringLiterals() {
		return true;
	}
}