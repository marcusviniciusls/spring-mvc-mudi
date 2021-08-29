package br.com.alura.mudi_springmvc.mudi.dto;

import br.com.alura.mudi_springmvc.mudi.model.Oferta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private Long pedidoId;
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    private String valor;
    private String comentario;
    @NotNull
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String dataEntrega;

    // Método Gets
    public Long getPedidoId() {
        return pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public String getComentario() {
        return comentario;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega,formatter));
        oferta.setValor(new BigDecimal(this.valor));

        return oferta;
    }
}
