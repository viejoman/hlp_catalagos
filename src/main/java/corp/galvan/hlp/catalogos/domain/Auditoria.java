package corp.galvan.hlp.catalogos.domain;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class),
        @TypeDef(name = "json-node", typeClass = JsonNodeStringType.class),
})
@MappedSuperclass
public class Auditoria<ID> {

    public Auditoria() {
        this.activo = true;
        fechaCreacion = new Date();
        fechaModificacion = new Date();
        usuarioCreo = 1;
        usuarioModifico = 1;
    }

    @Column(name = "activo", nullable = false)
    @ColumnDefault(value = "true")
    private boolean activo;//(campo de borrado lógico)

    @Temporal(TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)
    @ColumnDefault(value = "now()")
    private Date fechaCreacion;

    @Temporal(TIMESTAMP)
    @Column(name = "fecha_modificacion", nullable = false)
    @ColumnDefault(value = "now()")
    private Date fechaModificacion;

    @Column(name = "id_usuario_creo", nullable = false)
    private long usuarioCreo;

    @Column(name = "id_usuario_modifico", nullable = false)
    private long usuarioModifico;


}
