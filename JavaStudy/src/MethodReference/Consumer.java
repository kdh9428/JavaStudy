package xyz.springboot.user;

public interface Consumer<T> {
	
	public void accept(T t);
}
