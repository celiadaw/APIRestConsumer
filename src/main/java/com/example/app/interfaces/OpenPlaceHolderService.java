package com.example.app.interfaces;

import com.example.app.models.OpenPlaceHolderModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

/*
*
* The Interface OpenPlaceHolderService
*
* */
public interface OpenPlaceHolderService {
    /**
     *
     * Search comments with exchange
     *
     * @return the response entity
     *
     * */
    ResponseEntity<List<OpenPlaceHolderModel>> searchCommentsExchange ();

    /**
     * Search comments with for entity
     *
     * @return the response entity

    **/
    List<OpenPlaceHolderModel> searchCommentsWithForEntity();

    /**
     * Search comments with for object
     *
     * */
    List<OpenPlaceHolderModel> searchCommentsWithForObject();











}
