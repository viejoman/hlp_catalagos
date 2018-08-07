package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.Inhibidor;

import java.util.List;

public class InhibidorModel {

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

    public List<Inhibidor> getData() {
        return data;
    }

    public void setData(List<Inhibidor> data) {
        this.data = data;
    }

    private Boolean success;
    private String message;
    private String code;
    private List<Inhibidor> data;

}
