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
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class),
        @TypeDef(name = "json-node", typeClass = JsonNodeStringType.class),
        @TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
})
@MappedSuperclass
public class Auditoria<ID> {

    @Column(name = "usuario_creo_id", nullable = true)
    @ColumnDefault(value = "1")
    private ID usuarioCreo;

    @Column(name = "usuario_modifico_id", nullable = true)
    @ColumnDefault(value = "1")
    private ID usuarioModifico;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creo", nullable = true)
    private Date fechaCreacion;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_modifico", nullable = true)
    private Date fechaModificacion;

    @Column(name = "activo", nullable = true)
    @ColumnDefault(value = "true::boolean")
    private boolean activo;


}
