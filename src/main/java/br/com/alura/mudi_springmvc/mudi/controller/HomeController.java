package br.com.alura.mudi_springmvc.mudi.controller;

import br.com.alura.mudi_springmvc.mudi.model.Pedido;
import br.com.alura.mudi_springmvc.mudi.model.StatusPedido;
import br.com.alura.mudi_springmvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping()
    public String home(Model model, Principal principal){

        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest pageRequest = PageRequest.of(0,1,sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pageRequest);
        model.addAttribute("pedidos",pedidos);
        return "home";
    }
}
