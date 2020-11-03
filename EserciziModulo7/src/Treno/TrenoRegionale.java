package Treno;

public class TrenoRegionale extends Treno{
	TrenoRegionale(String codice) {
		super(codice, 15);
	}

	@Override
	public boolean addVagone(Vagone vagone) {
		if(vagone.getTipoVagone() == TipoVagone.PASSEGGERO){
			return super.addVagone(vagone);
		}else{
			return false;
		}
	}
}
