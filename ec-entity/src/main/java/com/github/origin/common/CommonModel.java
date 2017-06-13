package com.github.origin.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zhu on 2017/5/4.
 */
public class CommonModel<T> implements Serializable {

	private T dataObject;

	private String errorCode;

	private String errorMessage;

	public CommonModel() {
	}

	public T getDataObject() {
		return dataObject;
	}

	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



}
