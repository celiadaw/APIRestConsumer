package com.example.app.services;

import com.example.app.interfaces.OpenPlaceHolderService;
import com.example.app.models.OpenPlaceHolderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service("openPlaceHolderService")
public class OpenPlaceHolderServiceImpl implements OpenPlaceHolderService {

    /** The logger
     * */
    public  static  final Logger logger = LoggerFactory.getLogger(OpenPlaceHolderServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;




    /**
 *
 * Search comments with exchange
 * @return response entity
 *
 * */

    @Override
    public ResponseEntity<List<OpenPlaceHolderModel>> searchCommentsExchange() {
        logger.info(" Inicia la busqueda de comentarios con exchange");

        HttpHeaders headers=new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<OpenPlaceHolderModel> entity =new HttpEntity<>(headers);

        ResponseEntity<List<OpenPlaceHolderModel>> response=restTemplate.exchange(

                "https://jsonplaceholder.typicode.com/comments", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<OpenPlaceHolderModel>>() {
                });

        logger.info("Response: {}", response.getBody());


        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    /**
     *
     * Search comments with entity
     * @return the response entity
     * */


    @SuppressWarnings({"uncheked", "rawtypes"})
    @Override
    public List<OpenPlaceHolderModel> searchCommentsWithForEntity() {
        logger.info(" Inicia la busqueda de comentarios con for entity");

        restTemplateMethod();

        ResponseEntity<List> response =restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments", List.class);

        logger.info("Response: {}",  response.getBody());

        List<OpenPlaceHolderModel>  modelLIst=response.getBody();

        return modelLIst;
    }


  //**
  //
  // Search comments with for object
  // @return the list
  // */

    @SuppressWarnings("uncheked")
    @Override
    public List<OpenPlaceHolderModel> searchCommentsWithForObject() {

        logger.info("Inicio busqueda de comentarios con for object");


        restTemplateMethod();

        List<OpenPlaceHolderModel> response =restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", List.class);

        logger.info("Response {}", response);

        List<OpenPlaceHolderModel> modelList= response;



        return modelList;
    }

    private void restTemplateMethod() {
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                return  execution.execute(request, body);
            }

        });
    }
}
