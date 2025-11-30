package controller;

import dto.AssinaturaDTO;
import service.AssinaturaService;

/*
 controlador leve, repassa o DTO para o service
 comentarios sem acentos e sem maiusculas
*/
public class AssinaturaController {

    private final AssinaturaService service = new AssinaturaService();

    // metodo chamado pela interface (ui / main)
    public String criarAssinatura(AssinaturaDTO dto) {
        return service.criarAssinatura(dto);
    }
}
