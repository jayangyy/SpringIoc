package com.ioc.domains;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.annotation.User;

public abstract class BaseService<M> {  
    @Autowired //·ºÐÍ×¢Èë 
    protected BaseRepository<M> repository;   
}
 
