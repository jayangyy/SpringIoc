package com.domains;

public class SetIocTest {
	//����ע�����
private IocModel iocmodel; 
//һ��Ҫд��ע������set����  
public IocModel getIocmodel() {
	return iocmodel;
}

public void setIocmodel(IocModel iocmodel) {
	this.iocmodel = iocmodel;
}

public void ok(){  
	iocmodel.ok();  
}  

/*private FactoryDao factoryDao;  
����ע��
public void factoryOk(){  
    factoryDao.saveFactory();  
}  

public void setFactoryDao(FactoryDao factoryDao) {  
    this.factoryDao = factoryDao;  
}  */
}
