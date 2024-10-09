package com.example.ThinkOnDemo.domain.support;

public class JsonResult {
	private Integer status;

	private String msg;

	private Object data;

	public static JsonResult build(Integer status, String msg, Object data) {
		return new JsonResult(status, msg, data);
	}

	public JsonResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public JsonResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult() {

	}

	public Boolean isOK() {
		return this.status == 200;
	}

	public static JsonResult ok(Object data) {
		return new JsonResult(data);
	}

	public static JsonResult ok() {
		return new JsonResult(null);
	}

	public static JsonResult erorMsg(String msg) {
		return new JsonResult(500, msg, null);
	}

	public static JsonResult erorMap(Object data) {
		return new JsonResult(501, "error", data);
	}

	public static JsonResult erorTokenMsg(String msg) {
		return new JsonResult(502, msg, null);
	}

	public static JsonResult erorException(String msg) {
		return new JsonResult(555, msg, null);
	}

	public static JsonResult errorUserQQ(String msg) {
		return new JsonResult(556, msg, null);
	}

	public static JsonResult noLogin(String msg) {
		return new JsonResult(500001, msg, null);
	}

	public JsonResult status(Integer status) {
		this.setStatus(status);
		return this;
	}

	public JsonResult msg(String msg) {
		this.setMsg(msg);
		return this;
	}

	public JsonResult data(Object data) {
		this.setData(data);
		return this;
	}
}
