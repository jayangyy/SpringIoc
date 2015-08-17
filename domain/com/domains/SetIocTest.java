package com.domains;

public class SetIocTest {
	//属性注入测试
private IocModel iocmodel; 
//一定要写被注入对象的set方法  
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
工厂注入
public void factoryOk(){  
    factoryDao.saveFactory();  
}  

public void setFactoryDao(FactoryDao factoryDao) {  
    this.factoryDao = factoryDao;  
}  */
}
