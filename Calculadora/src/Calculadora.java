import java.util.Scanner; 
import java.util.Vector;                                  //Libreria para ingresar Strings por consola.
import java.lang.Math;
import java.util.StringTokenizer;
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
		StringTokenizer st = new StringTokenizer(Operacion,"+-",true);        
		
		/*------------Separacion de Tokens en num y oper------------*/	
		int inum=0;
		int ioper=0;
		Vector<Integer> num = new Vector<Integer>();
		Vector<String> oper = new Vector<String>();
		boolean esnum = true;
					
		while (st.hasMoreTokens()){
			if(esnum){
				num.add(Integer.parseInt(st.nextToken()));
				//System.out.println(inum + "->" + num[inum]);
				esnum=false;
				inum++;
			}
			else{
				oper.add(st.nextToken());
				//System.out.println(ioper + "->" + oper[ioper]);
				esnum=true;
				ioper++;
			}
		}
		
		/*--------------------Operacion--------------------*/
		int i=0;
		int resultado;
		resultado=num.elementAt(0);
		
		while(ioper!=0){	
			if(oper.elementAt(i).compareTo("+")==0){
				resultado+=num.elementAt(i+1);
				//System.out.println(resultado);
			}
			else if(oper.elementAt(i).compareTo("-")==0){
				resultado-=num.elementAt(i+1);
				//System.out.println(resultado);
			}
			i++;
			ioper--;
		}
		System.out.println(Operacion + "=" + resultado);	
	}
}
