package com.example.app.services;


import com.example.app.interfaces.OpenPlaceHolderService;
import com.example.app.models.OpenPlaceHolderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OpenPlaceHolderController {

    public static final Logger logger= LoggerFactory.getLogger(OpenPlaceHolderController.class);

    /** The open place holder service. */
    @Autowired
    @Qualifier("openPlaceHolderService")
    private OpenPlaceHolderService openPlaceHolderService;


    /**
     * Buscar comentarios con exchange.
     *
     * @return the response entity
     */
    @GetMapping(path = "/buscarComentariosConExchange",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<OpenPlaceHolderModel>> buscarComentariosConExchange() {

        logger.info("Ingresa a metodo buscarComentariosConExchange");

        return openPlaceHolderService.searchCommentsExchange();
    }

    @GetMapping(path = "/buscarComentariosConForEntity",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<OpenPlaceHolderModel>> buscarComentariosConForEntity() {

        logger.info("Ingresa a metodo buscarComentariosConExchange");

        return new ResponseEntity<>(openPlaceHolderService.searchCommentsWithForEntity(), HttpStatus.OK);
    }

    @GetMapping(path = "/buscarComentariosConForObject",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<OpenPlaceHolderModel>> buscarComentariosConForObject() {

        logger.info("Ingresa a metodo buscarComentariosConObject");

        return new ResponseEntity<>(openPlaceHolderService.searchCommentsWithForObject(), HttpStatus.OK);
    }



}
