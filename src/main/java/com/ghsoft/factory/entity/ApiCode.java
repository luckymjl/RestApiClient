package com.ghsoft.factory.entity;

public class ApiCode {
	
	/** 接口调用成功 */
	public static final int SUCCESS = 0;
	/** 业务逻辑错误 - 返回错误信息 */
	public static final int ERROR = 1;
	
	// 100 以后为错误代码
	
	/** 系统内部错误 */
	public static final int CODE_SYSTEM_ERROR 				= 999;
	/** 无效的 api key */
	public static final int CODE_INVALID_API_KEY 			= 100;
	/** 无效的 token  */
	public static final int CODE_INVALID_TOKEN 				= 101;
	
	/** 参数错误 */
	public static final int CODE_PARAMETER_ERROR			= 102;
	/** 设备未绑定 */
	public static final int CODE_DEVICE_NOT_BIND			= 103;
	/** 设备正忙 */
	public static final int CODE_DEVICE_IS_BUSY				= 104;
	/** 设备无法连接 */
	public static final int CODE_DEVICE_OFFLINE				= 105;
	/** 设备已绑定 */
	public static final int CODE_DEVICE_HAS_BIND			= 106;
	/** 设备禁用 */
	public static final int CODE_DEVICE_IS_DISABLE			= 107;
	/** 设备权限不足（非本机构下设备） */
	public static final int CODE_DEVICE_IS_AUTH_FORBIDDEN 	= 108;
	/** 设备无此功能 */
	public static final int CODE_DEVICE_HAS_NO_ABILITY 		= 109;
	
}