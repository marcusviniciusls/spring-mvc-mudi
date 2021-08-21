package br.com.alura.mudi_springmvc.mudi.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Construtores
    public Pedido(String nome, BigDecimal valorNegociado, String urlProduto, String urlImagem, String descricao, StatusPedido status) {
        this.nome = nome;
        this.valorNegociado = valorNegociado;
        this.urlProduto = urlProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
        this.status = status;
    }

    public Pedido (){}

    // Métodos Gets
    public String getNome() {
        return nome;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusPedido getStatusPedido(){
        return status;
    }

    // Métodos Set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatusPedido(StatusPedido status){
        this.status = status;
    }

    // Método to String
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valorNegociado=" + valorNegociado +
                ", dataEntrega=" + dataEntrega +
                ", urlProduto='" + urlProduto + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }
}
