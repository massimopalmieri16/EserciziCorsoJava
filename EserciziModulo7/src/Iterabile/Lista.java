package Iterabile;

public interface Lista {
	public abstract int get(int i);
	public abstract boolean contains(Object o);
	public abstract int size();
	public abstract void add(Object o);
	public abstract boolean remove(int i);
	public abstract void clear();
}
