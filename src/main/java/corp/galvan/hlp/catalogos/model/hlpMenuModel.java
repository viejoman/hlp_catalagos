package corp.galvan.hlp.catalogos.model;

import java.util.List;

public class hlpMenuModel {

    private Long id;
    private String text;
    private String iconCls;
    private List<hlpItemMenuModel> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<hlpItemMenuModel> getItems() {
        return items;
    }

    public void setItems(List<hlpItemMenuModel> items) {
        this.items = items;
    }
}
