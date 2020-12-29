package br.com.hibejix.loja.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author macrusal on 29/12/20
 * @project quarkus-loja
 */
@Entity
@Table(name = "produto")
public class Produto extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public BigDecimal valor;

    @CreationTimestamp
    public Date datacriacao;

    @UpdateTimestamp
    public Date dataAtualizacao;

}
