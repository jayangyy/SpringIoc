package com.cssdriver.domains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
////װ����ģʽ����ԭ�нӿ����������¹���,���ÿ�����AOP����,��Ϊ��ӵı�Ȼ�ǹ��õĴ�������������AOP�������һ�㣬�����޸���ǰԴ���룬����ҪNEWһ��ʵ����������
public class ConcreteTimeDecorator {
/*implements IComponent*/
    
    private IComponent component;
    public ConcreteTimeDecorator(){
    	
    }
    public ConcreteTimeDecorator(IComponent component) {
        this.component = component;
    }
    public void fun() {
        long start=System.currentTimeMillis();
        System.out.println("start at "+start);
        component.fun();
        long end=System.currentTimeMillis();
        System.out.println("end at "+end+",cost "+(end-start));
    }
 //���÷�ʽ
    // ConcreteTimeDecorator concreteTimeDecorator=new ConcreteTimeDecorator(concreteAComponent);
  //  concreteTimeDecorator.fun();
}