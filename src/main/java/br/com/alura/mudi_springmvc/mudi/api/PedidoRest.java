package br.com.alura.mudi_springmvc.mudi.api;

import br.com.alura.mudi_springmvc.mudi.model.Pedido;
import br.com.alura.mudi_springmvc.mudi.model.StatusPedido;
import br.com.alura.mudi_springmvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public List<Pedido> getPedidoAguardandoOfertas(){
        Sort sort = Sort.by("id").descending();
        PageRequest pageRequest = PageRequest.of(0,10,sort);
        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest);
    }
}
