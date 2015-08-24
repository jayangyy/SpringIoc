package com.cssdriver.domains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
////装饰者模式，在原有接口上面增加新功能,觉得可以用AOP代替,因为添加的必然是公用的处理方法，所以用AOP更加灵活一点，不用修改以前源代码，不需要NEW一个实例在来调用
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
 //调用方式
    // ConcreteTimeDecorator concreteTimeDecorator=new ConcreteTimeDecorator(concreteAComponent);
  //  concreteTimeDecorator.fun();
}