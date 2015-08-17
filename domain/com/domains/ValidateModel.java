package com.domains;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class ValidateModel{
    //服务器验证方法，但是当规定了类型，MVC框架模型绑定错误会跑出500异常，比如给INT 类型传字符串，就不会进入ACTION 会直接跑出异常，服务器验证在规定了类型的情况下只能做一些特殊的验证，因为值并未绑定成功 直接抛出500异常了，
    @NotEmpty(message="{name.not.empty}")
    private String name;
    @Range(min=0, max=150,message="{age.not.inrange}")
    private String age;
    @NotEmpty(message="{email.not.empty}")
    @Email(message="{email.not.correct}")
    private String email;
    
    public void setName(String name){
        this.name=name;
    }
    public void setAge(String age){
        this.age=age;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    public String getEmail(){
        return this.email;
    }
    
}