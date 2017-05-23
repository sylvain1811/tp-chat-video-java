
package ch.hearc.cours.poo.doublerepresentation;

import ch.hearc.cours.kitbase.tools.MathTools;

public class Complex
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Complex(double re, double im)
		{
		//Cartésien
			{
			this.re = re;
			this.im = im;
			}

		//Polaire
			{
			updatePolaire();
			}
		}

	/**
	 * Impossible car même signature que le constructeur cartésien
	 */
	//	public Complex(double mod, double arg)
	//		{
	//		this.mod = mod;
	//		this.arg = arg;
	//		}

	public Complex(Complex source)
		{
		this(source.re, source.im);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Complex cloneOf()
		{
		return new Complex(this);
		}

	@Override
	protected Object clone() throws CloneNotSupportedException
		{
		return this.cloneOf();
		}

	/**
	 * z1 est this
	 */
	public Complex add(Complex z2)
		{
		//v1:Musée des horreurs:
		//Deux raisons,
		//(R1): Attributs construits à l'extérieur du constructeur, donc au mauvais endroit
		//(R2): Code non compatible à l'injection de nouveaux attributs (attributs polaires)
		//			{
		//			Complex z = new Complex(0, 0);
		//			z.re=this.re+z2.re;
		//			z.im=this.im+z2.im;
		//			return z;
		//			}

		//v2:Parfaite
			{
			return new Complex(this.re + z2.re, this.im + z2.im);
			}
		}

	public Complex mult(double scalar)
		{
		return new Complex(this.re * scalar, this.im * scalar);
		}

	public Complex opposit()
		{
		return this.mult(-1);
		}

	public Complex sub(Complex z2)
		{
		return this.add(z2.opposit());
		}

	public Complex mult(Complex z2)
		{
		return Complex.createPolaire(this.mod * z2.mod, this.arg + z2.arg);
		}

	/**
	 * n : nombre entier uniquement
	 */
	public Complex pow(int n)
		{
		return Complex.createPolaire(Math.pow(this.mod, n), this.arg * n);
		}

	public Complex div(double scalar)
		{
		return this.mult(1 / scalar);
		}

	public Complex div(Complex z2)
		{
		return Complex.createPolaire(this.mod / z2.mod, this.arg - z2.arg);
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Complex [re=");
		builder.append(this.re);
		builder.append(", im=");
		builder.append(this.im);
		builder.append(", mod=");
		builder.append(this.mod);
		builder.append(", arg=");
		builder.append(this.arg);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	/**
	 * Epsilon pris en compte par défaut
	 */
	public boolean isEquals(Complex z2)
		{
		//		//v1:Suffisant
		//			{
		//			return MathTools.isEquals(this.re, z2.re) && MathTools.isEquals(this.im, z2.im);
		//			}

		//		//v2:ou (suffisant)
		//			{
		//			return MathTools.isEquals(this.mod,z2.mod) && MathTools.isEquals(this.arg,z2.arg);
		//			}

		//v3:Luxe
			{
			return MathTools.isEquals(this.mod, z2.mod) && MathTools.isEquals(this.re, z2.re) && MathTools.isEquals(this.im, z2.im);
			}
		}

	@Override
	public boolean equals(Object obj)
		{
		if (obj instanceof Complex)
			{
			Complex z2 = (Complex)obj;
			return isEquals(z2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setRe(double re)
		{
		this.re = re;
		updatePolaire();
		}

	public void setIm(double im)
		{
		this.im = im;
		updatePolaire();
		}

	public void setMod(double mod)
		{
		this.mod = mod;
		updateCartesien();
		}

	public void setArg(double arg)
		{
		this.arg = arg;
		updateCartesien();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double getRe()
		{
		return this.re;
		}

	public double getIm()
		{
		return this.im;
		}

	public double getMod()
		{
		return this.mod;
		}

	public double getArg()
		{
		return this.arg;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static Complex createPolaire(double mod, double arg)
		{
		return new Complex(toRe(mod, arg), toIm(mod, arg));
		}

	public static Complex createGravity(Complex[] tabComplex)
		{
		// V1 : Non-objet ! V2 meilleur
		//			{
		//			double reGavity = 0;
		//			double imGravity = 0;
		//			for(Complex complex:tabComplex)
		//				{
		//				reGavity += complex.re;
		//				imGravity += complex.im;
		//				}
		//			return new Complex((reGavity / tabComplex.length), (imGravity / tabComplex.length));
		//			}

		// V2
			{
			Complex gravity = createPolaire(0, 0);

			for(Complex complex:tabComplex)
				{
				gravity = gravity.add(complex);
				}
			return gravity.div(tabComplex.length);
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void updatePolaire()
		{
		this.mod = Complex.toMod(re, im);
		this.arg = toArg(re, im);//Deux syntaxes équivalentes
		}

	private void updateCartesien()
		{
		this.re = toRe(mod, arg);
		this.im = toIm(mod, arg);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static double toMod(double re, double im)
		{
		return Math.sqrt(re * re + im * im);
		}

	private static double toArg(double re, double im)
		{
		return Math.atan2(im, re);//Idem à Math.atan (im/re) et gère le cas ou re=0
		}

	private static double toRe(double mod, double arg)
		{
		return mod * Math.cos(arg);
		}

	private static double toIm(double mod, double arg)
		{
		return mod * Math.sin(arg);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input:représentation cartésienne
	private double re;
	private double im;

	//tools:représentation polaire
	private double mod;
	private double arg;
	}
