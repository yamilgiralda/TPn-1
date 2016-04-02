import java.util.Scanner;                                 //Libreria para ingresar un String por consola.
import java.util.Vector;                                  //Libreria para generar vectores de dimensión variable.
import java.lang.Math;                                    //Operaciones matemáticas.
import java.util.StringTokenizer;                         //Para dividir el String en tokens(de numeros y operadores).
public class Calculadora{
	
	public Calculadora(){
		
	}
	Scanner in = new Scanner(System.in);                    //Creo objeto "in" que me va a permitir ingresar Strings por consola.
	
	private String setOperacion(){                          //Metodo que me deja ingresar Strings por consola
		String Operacion;
		Operacion=in.next();		
		return Operacion;
	}
	
	
	public void Calcular() {
		/*------------Separacion del String en Tokens--------------*/
		String Operacion = setOperacion();
		StringTokenizer st = new StringTokenizer(Operacion,"+-*%",true);  //Creamos Tokens que se separan con los operandos.      

		
		/*------------Separacion de Tokens en num y oper------------*/	
		int inum=0;
		int ioper=0;
		Vector<Integer> num = new Vector<Integer>();
		Vector<String> oper = new Vector<String>();
		boolean esnum = true;                                            //Los num y oper estan intercalados, entonces usaremos el bool para separar
					                                                     //los toquens.
		while (st.hasMoreTokens()){                                      //Mientras haya tokens.
			if(esnum){                                                   //Separamos numeros.     
				num.add(Integer.parseInt(st.nextToken()));               //agrego numero al vector(convierto numero a int(tomo el next token)))
				//System.out.println(inum + "->" + num[inum]);
				esnum=false;
				inum++;
			}
			else{                                                        //Separamos operadores.
				oper.add(st.nextToken());                                //agrego String al vector(tomo el next token))
				//System.out.println(ioper + "->" + oper[ioper]);
				esnum=true;
				ioper++;
			}
		}
		
		/*--------------------Operacion--------------------*/
		int i=0;
		double resultado;
		resultado=num.elementAt(0);                                         //resultado toma el valor del 1º valor ingresado.
		
		while(ioper!=0){	
			if(oper.elementAt(i).compareTo("+")==0){                        //Si el operador es "+".
				resultado+=num.elementAt(i+1);
				//System.out.println(resultado);
			}
			else if(oper.elementAt(i).compareTo("-")==0){                   //Si el operador es "-".
				resultado-=num.elementAt(i+1);
				//System.out.println(resultado);
			}
			else if(oper.elementAt(i).compareTo("*")==0){                   //Si el operador es "*".
				resultado*=num.elementAt(i+1);
				//System.out.println(resultado);
			}

			else if(oper.elementAt(i).compareTo("%")==0){                   //Si el operador es "%".
				resultado/=num.elementAt(i+1)/100;
				//System.out.println(resultado);
			}
			i++;
			ioper--;
		}
		System.out.println(Operacion + "=" + resultado);	
	}
}
