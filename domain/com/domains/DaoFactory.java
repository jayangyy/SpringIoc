package com.domains;

public class DaoFactory {
	//¾²Ì¬¹¤³§  
    public static final FactoryDao getStaticFactoryDaoImpl(){  
        return new StaticFacotryDaoImpl().GetDao();  
    }  
}
