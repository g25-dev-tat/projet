package labyrinthe;

import javax.inject.Inject;

public class modelecompetition {
	@Inject
	dao dao;
	competition c = new competition();
	public competition getC() {
		return c;
	}
	public void setC(competition c) {
		this.c = c;
	}
 public void inserer()
 {
	 dao.inserer(c);
 }
}
