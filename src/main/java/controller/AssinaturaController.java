package controller;

import dto.AssinaturaDTO;
import services.AssinaturaService;

/*
 controlador leve, repassa o DTO para o service
s
*/
public class AssinaturaController {

    private final AssinaturaService service = new AssinaturaService();

    // metodo chamado pela interface (ui / main)
    public String criarAssinatura(AssinaturaDTO dto) {
        return service.criarAssinatura(dto);
    }
}
