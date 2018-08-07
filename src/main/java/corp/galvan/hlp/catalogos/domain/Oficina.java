package corp.galvan.hlp.catalogos.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Oficina")
@Table(name = "oficinas", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Oficina extends Auditoria<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", unique = true, nullable = false)
    private Long idoficina;

    @Column(name="clave")
    private String clave;

    @Column(name="nombre")
    private String nombre;

    //@Column(name="codigo_foliador")
    //private String codigoFoliador;

    //@Column(name="numero_oficina")
    //private Integer numeroOficina;

    //@Column(name="razon_social")
    //private String razonSocial;

}
