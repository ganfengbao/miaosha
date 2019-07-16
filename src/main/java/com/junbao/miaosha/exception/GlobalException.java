package com.junbao.miaosha.exception;


import com.junbao.miaosha.result.CodeMsg;

/**
 * @author 小笨蛋
 */
public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public GlobalException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

}
