package Iterabile;

import java.util.Arrays;

public class MiaStringa implements Iterabile, Lista{
	private String miaStringa;
	private int index;

	MiaStringa(String miaStringa){
		this.miaStringa = miaStringa;
		index = 0;
	}
	MiaStringa(){
		this.miaStringa = "";
		index = 0;
	}

	@Override
	public Object next() {
		if(index >= miaStringa.length()) return null;
		return miaStringa.charAt(index ++);
	}

	@Override
	public boolean hasNext() {
		return index < miaStringa.length();
	}

	@Override
	public void reset() {
		index = 0;
	}

	@Override
	public int get(int i) {
		return miaStringa.charAt(i);
	}

	@Override
	public boolean contains(Object o) {
		char[] charMiaStringa = miaStringa.toCharArray();
		for(char i:charMiaStringa){
			if(i == (char) o) return true;
		}
		return false;
	}

	@Override
	public int size() {
		return miaStringa.length();
	}

	@Override
	public void add(Object o) {
		miaStringa += o;
	}

	@Override
	public boolean remove(int i_remove) {
		if(i_remove >= miaStringa.length()) return false;
		String miaStringaTemp = "";
		for(int i = 0; i < miaStringa.length(); i ++){
			if(i != i_remove){
				miaStringaTemp += miaStringa.charAt(i);
			}
		}
		miaStringa = miaStringaTemp;
		return true;
	}

	@Override
	public void clear() {
		miaStringa = "";
		index = 0;
	}
}
