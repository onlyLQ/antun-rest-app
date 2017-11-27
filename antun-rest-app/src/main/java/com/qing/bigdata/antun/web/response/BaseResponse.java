package com.qing.bigdata.antun.web.response;

/**
 * 统一的返回值
 * @author BaseResponse 
 *
 */
public class BaseResponse {
	//返回码
	private Integer code;
	//操作错误原因
	private String message;
	//返回数据
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public BaseResponse code(Integer code){
		this.code=code;
		return this;
	}
	public BaseResponse message(String message){
		this.message=message;
		return this;
	}
	public BaseResponse data(Object data){
		this.data=data;
		return this;
	}
	
	
	
	public static BaseResponse errorResponse(){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(400);
		return baseResponse;
	}
	public static BaseResponse errorResponse(String messgae){
		BaseResponse errorResponse = errorResponse();
		errorResponse.setMessage(messgae);
		return errorResponse;
	}
	public static BaseResponse successResponse(){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(200);
		return baseResponse;
	}
	public static BaseResponse successResponse(String messgae){
		BaseResponse successResponse = successResponse();
		successResponse.setMessage(messgae);
		return successResponse;
	}
	
}
