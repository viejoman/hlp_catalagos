package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.Menu;

import java.util.List;

public class MenuModel {

    private Boolean success;
    private String message;
    private String code;
    private List<hlpMenuModel> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<hlpMenuModel> getData() {
        return data;
    }

    public void setData(List<hlpMenuModel> data) {
        this.data = data;
    }

    public MenuModel(Boolean success, String message, String code, List<hlpMenuModel> data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public MenuModel() {
    }
}
