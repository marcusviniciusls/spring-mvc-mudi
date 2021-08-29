package br.com.alura.mudi_springmvc.mudi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ofertas")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    // Métodos Gets
    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    // Métodos SET
    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
