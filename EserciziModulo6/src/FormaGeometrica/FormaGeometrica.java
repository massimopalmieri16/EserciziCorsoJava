package FormaGeometrica;

import java.util.Objects;

public class FormaGeometrica {
	int lato1;
	int lato2;

	FormaGeometrica(int lato1, int lato2){
		this.lato1 = lato1;
		this.lato2 = lato2;
	}

	public int getArea(){
		return lato1 * lato2;
	}

	public int getPerimetro(){
		return (lato1 + lato2) * 2;
	}

	@Override
	public String toString(){
		return "Forma geometrica";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormaGeometrica that = (FormaGeometrica) o;
		return lato1 == that.lato1 &&
				lato2 == that.lato2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lato1, lato2);
	}
}
