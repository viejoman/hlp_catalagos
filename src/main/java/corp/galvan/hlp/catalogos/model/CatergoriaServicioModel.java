package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.*;

import java.util.List;

public class CatergoriaServicioModel {

    private Boolean success;
    private String message;
    private String code;
    private List<CategoriaServicio> data;

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

    public List<CategoriaServicio> getData() {
        return data;
    }

    public void setData(List<CategoriaServicio> data) {
        this.data = data;
    }

    public CatergoriaServicioModel(Boolean success, String message, String code, List<CategoriaServicio> data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public CatergoriaServicioModel() {
    }

}
