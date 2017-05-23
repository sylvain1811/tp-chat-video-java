
package ch.hearc.cours.poo.template.pile.specification;

import ch.hearc.cours.poo.interfaces.entrainement.specifications.Objet_I;

public interface Pile_I <T extends Objet_I<T>>
	{

	public boolean push(T t);

	public T pop();

	public int size();

	public boolean isEmpty();
	}
