package corp.galvan.hlp.catalogos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import corp.galvan.hlp.catalogos.converters.LocalDateTimeConverter;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity(name = "Usuario")
@Table(name = "usuarios", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMappings( {
        @SqlResultSetMapping(
                name = "UsuarioGrupoMapping",
                classes = @ConstructorResult(
                        targetClass = Grupo.class,
                        columns = {
                                @ColumnResult(name = "idgrupo", type = Long.class),
                                @ColumnResult(name = "grupo")
                        })
        ),

        @SqlResultSetMapping(
                name = "UsuarioHLPMapping",
                entities = {
                        @EntityResult(
                                entityClass = Usuario.class,
                                fields = {
                                        @FieldResult(name = "idusuario", column = "idusuario"),
                                        @FieldResult(name = "usuario", column = "usuario"),
                                        @FieldResult(name = "passwd", column = "passwd"),
                                        @FieldResult(name = "configuraciones", column = "configuraciones"),
                                        @FieldResult(name = "privilegiosSit", column = "privilegiossit"),
                                        @FieldResult(name = "nombre", column = "nombre"),
                                        @FieldResult(name = "apaterno", column = "apaterno"),
                                        @FieldResult(name = "amaterno", column = "amaterno"),
                                        @FieldResult(name = "idgrupo", column = "idgrupo"),
                                        @FieldResult(name = "idoficina", column = "idoficina"),
                                        @FieldResult(name = "sucursal", column = "sucursal"),
                                        @FieldResult(name = "email", column = "email"),
                                        @FieldResult(name = "activo", column = "activo"),
                                        @FieldResult(name = "fechaCreacion", column = "fecharegistro"),
                                        @FieldResult(name = "fechaModificacion", column = "fechamodifica"),
                                        @FieldResult(name = "usuarioCreo", column = "usrcreoid"),
                                        @FieldResult(name = "usuarioModifico", column = "usrmodificoid"),
                                        @FieldResult(name = "iddepartamento", column = "iddepartamento"),
                                        @FieldResult(name = "ciudad", column = "ciudad"),
                                        @FieldResult(name = "direccion", column = "direccion"),
                                        @FieldResult(name = "imagenPath", column = "imagenpath"),
                                        //@FieldResult(name = "skype", column = "skype"),
                                        @FieldResult(name = "telefono", column = "telefono"),
                                        @FieldResult(name = "idpuesto", column = "idpuesto"),
                                        //@FieldResult(name = "identidad", column = "identidad"),
                                        @FieldResult(name = "municipio", column = "municipio")
                                }
                        ),
                        @EntityResult(
                                entityClass = Grupo.class,
                                fields = {
                                        @FieldResult(name = "idgrupo", column = "id_grupo"),
                                        @FieldResult(name = "nombre", column = "nombre_grp"),
                                        @FieldResult(name = "activo", column = "activo_grp"),
                                        @FieldResult(name = "fechaCreacion", column = "fecharegistro_grp"),
                                        @FieldResult(name = "fechaModificacion", column = "fechamodifica_grp"),
                                        @FieldResult(name = "usuarioCreo", column = "usrcreoid_grp"),
                                        @FieldResult(name = "usuarioModifico", column = "usrmodificoid_grp")
                                }
                        ),
                        @EntityResult(
                                entityClass = Oficina.class,
                                fields = {
                                        @FieldResult(name = "idoficina", column = "id_oficina"),
                                        @FieldResult(name = "clave", column = "clave_ofc"),
                                        @FieldResult(name = "nombre", column = "nombre_ofc"),
                                        //@FieldResult(name = "numeroOficina", column = "numerooficina_ofc"),
                                        //@FieldResult(name = "razonSocial", column = "razonsocial_ofc"),
                                        @FieldResult(name = "activo", column = "activo_ofc"),
                                        @FieldResult(name = "fechaCreacion", column = "fecharegistro_ofc"),
                                        @FieldResult(name = "fechaModificacion", column = "fechamodifica_ofc"),
                                        @FieldResult(name = "usuarioCreo", column = "usrcreoid_ofc"),
                                        @FieldResult(name = "usuarioModifico", column = "usrmodificoid_ofc")
                                }
                        )

                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
        name = "getUsuarioByGrupoSucursal",
        query =
                "SELECT usr.id as idusuario, usr.oficina_id idsucursal, usr.grupo_id idgrupo, usr.usuario, usr.cve_acceso passwd, " +
                        "usr.activo, usr.fecha_creo fecharegistro, usr.nombre, usr.apellido_paterno apaterno, usr.apellido_materno amaterno, " +
                        "usr.email, ofc.clave sucursal " +
                        "FROM desarrollo.usuarios usr " +
                        "JOIN desarrollo.oficinas ofc ON ofc.id = usr.oficina_id " +
                        "WHERE usr.grupo_id = :p_idgrupo and usr.oficina_id = :p_idsucursal",
        resultClass = Usuario.class
        ),
        @NamedNativeQuery(
                name = "funcGetUsuarioByGrupoSucursal",
                query = "select * from desarrollo.getUsuariosByIdGrupoOficina(:p_idgrupo, :p_idsucursal)",
                resultSetMapping = "UsuarioHLPMapping"
        ),
        @NamedNativeQuery(
                name = "funcGetUsuariosByIdOficina",
                query = "select * from desarrollo.getUsuariosByIdOficina(:p_idoficina)",
                resultSetMapping = "UsuarioHLPMapping"
        )
})
@NamedStoredProcedureQuery(
        name = "obtenerUsuariosByIdGrupoOficina",
        procedureName = "desarrollo.getUsuariosByIdGrupoOficina",
        parameters = {
                @StoredProcedureParameter(name="idgrupo", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name="idoficina", mode = ParameterMode.IN, type = Long.class)
        }
)
public class Usuario extends Auditoria<Long> implements Serializable {

    private static final String WRITE = "HMAC(?,'fenix3009%%h4sk3ll80','sha256')";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long idusuario;

    @Column(name = "usuario")
    private String usuario;

    @ColumnTransformer(write = WRITE)
    @Column(name = "cve_acceso")
    private byte[] passwd;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apaterno;

    @Column(name = "apellido_materno")
    private String amaterno;

    @Column(name = "email")
    private String email;

    @Column(name = "oficina_id")
    private Long idoficina;

    @Transient
    private Oficina oficina;

    @Column(name = "grupo_id")
    private Long idgrupo;

    @Transient
    private Grupo grupo;

    @Column(name = "ciudad")
    private String ciudad;

    @Type(type = "jsonb")
    @Column(name = "configuracion", columnDefinition = "jsonb")
    private List<Configuracion> configuraciones;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "imagen_path")
    private String imagenPath;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "privilegios_sit")
    private byte[] privilegiosSit;

    //@Column(name = "skype")
    //private String skype;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "departamento_id")
    private Long iddepartamento;

    //@Column(name = "entidad_id")
    //private Long identidad;

    @Column(name = "puesto_id")
    private Long idpuesto;

}

