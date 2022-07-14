package com.example.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
/**
 *
 * The class OpenLibraModel
 *
 * */
public class OpenPlaceHolderModel implements Serializable {
    /**
     * The constant serialVersionUID
     * */
    private static  final  long serialVerionUID= 4548578464564652115L;

    /*
    * the ID
     */
    @JsonProperty("postId")
    private Integer postId;

    /**the id
     * */
    @JsonProperty("id")
    private Integer id;
    /*the author
    * */
    @JsonProperty("name")
    private String name;
    /* email
    **/
    @JsonProperty("email")
    private String email ;
    /* description
    * */
    @JsonProperty("body")
    private String body;


    public OpenPlaceHolderModel(){}

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
          StringBuilder builder=new StringBuilder();
          builder.append("OpenPlaceHolderModel [postId=");
          builder.append(postId);
          builder.append(", id=");
          builder.append(id);
          builder.append(", name=");
        builder.append(name);
        builder.append(", email=");
        builder.append(email);
        builder.append(", body=");
        builder.append(body );
        builder.append(" ]");

        return  builder.toString();


    }
}
