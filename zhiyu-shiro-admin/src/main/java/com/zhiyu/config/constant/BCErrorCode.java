package com.zhiyu.config.constant;

/**
 * @author wengzhiyu
 * @date 2020/01/07
 */
public enum BCErrorCode {
    /**
     * 异常状态
     */
    SUCCESS("成功", 0),
    ERROR("失败", -1),
    SYSTEM_ERROR("系统出错", 1),
    PARAMETER_ERROR("参数校验失败", 2),
    UPLOAD_FILE_TYPE_ERROR("上传文件类型错误", 3),
    VERIFICATION_CODE_ERROR("验证码错误",4),
    VERIFICATION_CODE_FAIL_COUNT_ERROR("验证码错误次数过多请重新获取",5),
    AUTHORITY_ERROR("权限不足", 7),

    ILLEGAL_REQUEST_ERROR("非法请求",999),

    USER_NOT_EXIST("用户不存在", 1000),
    COMPANY_NOT_EXIST("企业主体未设置",1001),


    START_PROCESS_INSTANCE_ERROR("钉钉审批实例发起错误", 2000),
    GET_PROCESS_INSTANCE_ERROR("钉钉审批实例获得详细信息错误", 2001),
    GET_USER_PROFILE_ERROR("钉钉获得用户详情失败", 2002),
    GET_HRM_EMPLOYEE_LIST_ERROR("钉钉获取员工花名册字段信息失败", 2002),
    GET_JSAPI_TICKET_ERROR("钉钉获得JSAPI签名失败", 2003),
    GET_PROCESS_BY_USER_ID_ERROR("钉钉获得可见审批模板失败", 2004),


    ZGJ_GET_SEAL_ERROR("章管家找不到印章", 2101),
    ZGJ_GET_CONTRACT_TYPE_ERROR("章管家找不到合同类别", 2102),
    ZGJ_GET_PERSON_ERROR("章管家找不到对应的人", 2103),
    ZGJ_CREATE_PERSON_ERROR("章管家新建用户失败", 2104),
    ZGJ_SEAL_APPLY_ERROR("章管家添加用印申请失败", 2105),
    ZGJ_FIND_PROCESS_ZB_ERROR("章管家找不到对应的审批实例子表", 2106),


    PARTNER_PROJECT_NULL_ERROR("找不到对应项目",3000),
    PARTNER_PROJECT_RELEVANCE_ERROR("找不到项目的关联关系",3001),
    PARTNER_USER_DATA_COMPLETE_ERROR("用户数据不完整,无法登录",3002),
    PARTNER_USER_ALREADY_EXIST_ERROR("用户已经存在",3003),
    PARTNER_NOT_FIND_ORDER_ERROR("找不到订单",3004),
    PARTNER_DATA_FULL_ERROR("信息不完整", 3005),
    PARTNER_PROJECT_DATA_FULL_ERROR("项目的信息不完整", 3005),
    PARTNER_USER_DATA_FULL_ERROR("用户的信息不完整", 3005),


    PARTNER_HAVE_PAID_ERROR("该项目已支付", 3100),


    E_APPID_NULLITY("无效的企业",2201),
    E_SIGN_FIELD_NULL("根据审批实例找不到签名域",2002),



    HTTP_ERROR("发送HTTP请求失败",9999),
    USER_NOT_AUTHORIZED("用户未授权",100007),
    USER_IS_NULL("至少选择一个面试官人员",-1),
    USER_NAME_NOT_NULL("面试人员姓名不能为空",-1),
    USER_GENDER_NOT_NULL("面试人员性别不能为空",-1),
    USER_EMAIL_NOT_NULL("面试人员邮箱不能为空",-1),
    USER_PHONE_NOT_NULL("面试人员手机号不能为空",-1),
    USER_CID_NOT_NULL("创建人ID为空",-1),
    USER_UID_NOT_NULL("修改人ID为空",-1),
    USER_NOT_NULL("传入数据为null",-1),
    USER_QUERY_NOT_NULL("查询数据为null",-1),
    USER_ID_NOT_NULL("主键ID为空",-1),



    ;




    private String msg;
    private Integer code;

    BCErrorCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
