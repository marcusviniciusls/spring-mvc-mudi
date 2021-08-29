package br.com.alura.mudi_springmvc.mudi.api;

import br.com.alura.mudi_springmvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mudi_springmvc.mudi.model.Oferta;
import br.com.alura.mudi_springmvc.mudi.model.Pedido;
import br.com.alura.mudi_springmvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/ofertas")
public class OfertaRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicaoNovaOferta){
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicaoNovaOferta.getPedidoId());
        if (pedidoBuscado.isEmpty()){
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta novaOferta = requisicaoNovaOferta.toOferta();

        novaOferta.setPedido(pedido);
        pedido.getOferta().add(novaOferta);

        pedidoRepository.save(pedido);

        return novaOferta;
    }
}
