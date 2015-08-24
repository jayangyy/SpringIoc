package com.domains;

public interface IDAO<T> {
	public void insert(T model);
    public void update(T model);
    public void delete(T model);
    public <T> T doSomething(T param);
}
