
package ch.hearc.cours.poo.heritage.animal;

public abstract class Animal
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Animal(String nom)
		{
		this.nom = nom;
		}

	public Animal(Animal source)
		{
		this(source.nom);//copie superficielle autorisée car String est une classe inaltérable
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	public abstract Animal cloneOf();

	public abstract String mange();

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(mange());
		stringBuilder.append(SPACE);
		stringBuilder.append(nom);
		stringBuilder.append(SPACE);
		stringBuilder.append(nameHierarchie());
		return stringBuilder.toString();
		}

	public String nameHierarchie()
		{
		return Animal.class.getSimpleName();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setNom(String nom)
		{
		this.nom = nom;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getNom()
		{
		return nom;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private String nom;

	protected static final String SPACE = " ";

	}
