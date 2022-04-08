package structure;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Main {
	
	/**
	 * This is to add an inventory to the shop.
	 * @param diccionario
	 * @return ArrayList of ArrayList of string
	 */
		private static ArrayList<ArrayList<String>> tokenDic(String dir) {
			try {
				
				
				BufferedReader read= new BufferedReader(new FileReader(dir));
				String line;
				ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
				while( (line = read.readLine() ) != null) {
					ArrayList<String> arr = new ArrayList<String>();

					String [] temp = line.split(",");
					arr.add(temp[0]);
					arr.add(temp[1]);
					arr.add(temp[2]);
					
					array.add(arr);
				    
				}

			    System.out.print("Inventory loaded\n");
				read.close();
				return array;
				}
			
			
			catch (Exception e) {
				System.out.print("El archivo no es posible de ordenar dado que no solo posee numeros\n");
				return null;
			}
		}
		/**
		 * 
		 * @param scan
		 * @param dic
		 */
		private static void translate(String scan, Diccionario dic) {
			String[] values = scan.split(" ");
			String translation = new String();
			for ( int k = 0 ; k < values.length ; k++ ) {
				if (dic.searchWord(values[k])!= null) {
					translation = translation +" "+dic.searchWord(values[k]);	
				}
				else {
					translation = translation+" "+"*"+values[k];
				}
			}
			System.out.print("\nLa traduccion: "+translation);
			
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Diccionario dic1 = new Diccionario();
		System.out.print("Ingrese la direccion donde esta guardada la direccion: ");
		String dir = scan.nextLine();
//		C:\Users\Windows 10\Documents\UVG\CODING\Algoritmos y estructuras de datos\HDT\HDT7\Others\diccionario.txt
		dic1.loadDic(tokenDic(dir));
		dic1.getAssociations();
		Boolean notexit = true;
		while (notexit) {
			
			System.out.print("\nSeleccione entre las siguientes opciones:\n1. Traduce un texto en ingles o frances\n2. Insercion de nuevos elementos\n3. Eliminar algun valor (espaniol)\n4. Modificacion de palabras\n5. Obtener asociaciones\n6. Salir\n (1,2,3,4,5)\n");
			switch(scan.nextLine()) {
			case "1":{
				String enunciado = scan.nextLine();
				translate(enunciado, dic1);
				break;
				
			}case "2":{
				
				System.out.print("\nIngrese el valor en ingles: ");
				String englishValue = scan.nextLine();
				System.out.print("\nIngrese el valor en frances: ");
				String frenchValue = scan.nextLine();
				System.out.print("\nIngrese el valor en espaniol: ");
				String spanishValue = scan.nextLine();
				dic1.addWord(englishValue, frenchValue, spanishValue);
				
				break;
				
			}case "3":{
				
				System.out.print("\nIngrese el valor a borrar (espaniol): ");
				dic1.removeWord(scan.nextLine());
				break;
				
			}case "4":{
				
				System.out.print("\nIngrese el valor en ingles: ");
				String valueEnglish = scan.nextLine();
				System.out.print("\nIngrese el valor a modificar (espaniol): ");
				String valueSpanish = scan.nextLine();
				dic1.changeWord(valueEnglish, valueSpanish);
				break;
				
			}case "5":{
				
				dic1.getAssociations();
				
				break;
				
			}case "6":{
				
				notexit = false;
				
				break;
				
			}
			
			
			}
		}
		scan.close();
	}

}
