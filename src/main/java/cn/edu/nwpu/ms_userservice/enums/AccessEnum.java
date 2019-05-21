package cn.edu.nwpu.ms_userservice.enums;

public enum AccessEnum {

    PLATFORM_ACCESS(1,"有进入平台权限"),
    PLATFORM_DENIED(0,"无进入平台权限"),
    EXPMANAGE_ACCESS(1, "有实验数据管理权限"),
    EXPMANAGE_DENIED(0, "无实验数据管理权限"),
    BALSZERO_ACCESS(1, "有零维内弹道计算权限"),
    BALSZERO_DENIED(0, "有零维内弹道计算权限");

    private Integer code;
    private String message;

    AccessEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

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
}
