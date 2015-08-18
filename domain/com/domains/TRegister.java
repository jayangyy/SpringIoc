package com.domains;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TRegister  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

     private Integer id;
     private String userName;
     private String userPwd;
     private String sex;
     private Integer age;


    // Constructors

    /** default constructor */
    public TRegister() {
    }

    /** minimal constructor */
    public TRegister(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public TRegister(Integer id, String userName, String userPwd, String sex, Integer age) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return this.userPwd;
    }
    
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
