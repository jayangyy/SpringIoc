package com.domains;

public class DaoFactory {
	//��̬����  
    public static final FactoryDao getStaticFactoryDaoImpl(){  
        return new StaticFacotryDaoImpl().GetDao();  
    }  
}
