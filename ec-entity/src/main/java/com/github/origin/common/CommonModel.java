package com.github.origin.common;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by Zhu on 2017/5/4.
 */
@Data
public class CommonModel<T> implements Serializable {

	private T dataObject;

	private String errorCode;

	private String errorMessage;

}
