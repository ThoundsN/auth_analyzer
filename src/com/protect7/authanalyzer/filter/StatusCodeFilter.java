package com.protect7.authanalyzer.filter;

import burp.IBurpExtenderCallbacks;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import burp.IResponseInfo;

public class StatusCodeFilter extends RequestFilter {
	
	public StatusCodeFilter(int filterIndex, String description) {
		super(filterIndex, description);
		setFilterStringLiterals(new String[]{"304"});
	}

	@Override
	public boolean filterRequest(IBurpExtenderCallbacks callbacks, int toolFlag, IRequestInfo requestInfo, IResponseInfo responseInfo) {
		if (onOffButton.isSelected() && responseInfo != null) {
			String statusCode = String.valueOf(responseInfo.getStatusCode());
			for (String stringLiteral : stringLiterals) {
				if (statusCode.equals(stringLiteral.toLowerCase()) && !stringLiteral.trim().equals("")) {
					incrementFiltered();
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean hasStringLiterals() {
		return true;
	}


	public Type getType() {
		return null;
	}


	@Override
	public boolean filterBody(IBurpExtenderCallbacks callbacks, int toolFlag, IHttpRequestResponse messageInfo) {
		return false;
	}
}