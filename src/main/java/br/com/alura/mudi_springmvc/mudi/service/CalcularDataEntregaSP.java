package br.com.alura.mudi_springmvc.mudi.service;

import java.time.LocalDate;

public class CalcularDataEntregaSP implements CalcularDateEntrega{

    @Override
    public LocalDate calcularDataEntrega(LocalDate data) {
        data = LocalDate.now();
        return data.plusDays(7);
    }
}
