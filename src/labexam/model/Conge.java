package labexam.model;

public class Conge {
	private static Conge instance = null;
	private Boolean jours [];
	
	private Conge() {
		jours = new Boolean[365];
		for (int i = 0; i < jours.length; i++) {
			jours[i]= Boolean.TRUE;
		}
	}
	
	public static Conge instance () {
		if(instance==null) instance = new Conge();
		return instance;
	}
	
	public boolean verifierJour(int jour) {
		if (jour<365 && jour>=0) 
			return jours[jour].booleanValue();
		return Boolean.FALSE;
	}
	
	public void poserJour(int jour) {
		jours[jour] = Boolean.FALSE;
	}
}
