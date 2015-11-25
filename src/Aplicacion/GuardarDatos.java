/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Aplicacion;

import java.io.*;
/**
 *
 * @author federico
 */
public class GuardarDatos {

    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut= new PrintWriter(System.out,true);
   
    /**
     *
     * @param nombre
     * @param matricula
     * @param grupo
     * @param puesto
     * @throws IOException
     */
    public static void grabar(String nombre, String matricula, String grupo, String puesto) throws IOException { //Importa las variables de parámetro.
       
        
        String a= "";
            try (RandomAccessFile ArchivoAlumno = new RandomAccessFile ("DatosAlumno.dat", "rw")) { //Se crea un nuevo archivo.
                
                //Se llenan los espacios sobrantes.                
                if (matricula.length()<18){
                    int m;
                    for (m=matricula.length(); m<18; m++){
                        matricula= matricula + " ";
                    }
                }
                if (nombre.length()<40){
                    int n;
                    for (n=nombre.length(); n<40; n++){
                        nombre= nombre + " ";
                    }
                }
                if (grupo.length()<30){
                    int g;
                    for (g=grupo.length(); g<30; g++){
                        grupo= grupo + " ";
                    }
                }
                if (puesto.length()<20){
                    int p;
                    for (p=puesto.length(); p<20; p++){
                        puesto= puesto + " ";
                    }
                }
                
                    int puntos=0; //Se define el valor de puntos para introducirlo en el archivo.
                
                if(ArchivoAlumno.length()>0){
                            ArchivoAlumno.seek(ArchivoAlumno.length() -220);
                            a= a + ArchivoAlumno.readChar();
                            if(a.equalsIgnoreCase(" ")){
                                 ArchivoAlumno.seek(ArchivoAlumno.length()-220);    
                                 ArchivoAlumno.writeChars(matricula);
                                 ArchivoAlumno.writeChars(nombre);
                                 ArchivoAlumno.writeChars(grupo);
                                 ArchivoAlumno.writeChars(puesto);
                                 ArchivoAlumno.writeInt(puntos);
                                 ArchivoAlumno.close();
                            }
                            else{
                                 ArchivoAlumno.seek(ArchivoAlumno.length());
                                 ArchivoAlumno.writeChars(matricula);
                                 ArchivoAlumno.writeChars(nombre);
                                 ArchivoAlumno.writeChars(grupo);
                                 ArchivoAlumno.writeChars(puesto);
                                 ArchivoAlumno.writeInt(puntos);
                                 ArchivoAlumno.close();
                            }
                }else {
                    ArchivoAlumno.seek(ArchivoAlumno.length());
                                 ArchivoAlumno.writeChars(matricula);
                                 ArchivoAlumno.writeChars(nombre);
                                 ArchivoAlumno.writeChars(grupo);
                                 ArchivoAlumno.writeChars(puesto);
                                 ArchivoAlumno.writeInt(puntos);
                                 ArchivoAlumno.close();
                }
                                                    
         MenuPrincipal M= new MenuPrincipal(); //Regresa al usuario al menú principal para que realice más operaciones.
         M.setVisible(true);           
            
        }
            
        catch(IOException e){
            Mensajes A= new Mensajes(); //Si ocurrió un error muestra la interfaz mensajes.
            A.setVisible(true);
        }
        
    } 
          
    }

   

     
     

