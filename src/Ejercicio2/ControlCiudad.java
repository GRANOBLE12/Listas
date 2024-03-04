/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1059356842
 */
public class ControlCiudad {

    ArrayList registro = new ArrayList();
    Scanner in = new Scanner(System.in);

    void agregarCiudad() {
        System.out.println("Digite el nombre de la ciudad");
        String Nombre = in.next();
        System.out.println("Digite la cantidad de habiantes");
        int Cantidad = in.nextInt();
        System.out.println("Digite la temperatura Promedio");
        double promTemperatura = in.nextInt();

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(Nombre);
        ciudad.setNumHabitantes(Cantidad);
        ciudad.setPromTemperatura(promTemperatura);

        registro.add(ciudad);
        System.out.println("Datos de la persona registrados exitosamente");
    }
    void Listar() {
        if (registro.isEmpty()) {
            System.out.println("No hay Ciudades registradas");
        } else {
            System.out.println("Listando...");
            for (int i = 0; i < registro.size(); i++) {
                Ciudad ciudadRecuperada = (Ciudad) registro.get(i);
                
                System.out.println("Nombre/Num habiatntes/PromedioTem");
                System.out.println(ciudadRecuperada.getNombre() + "/"
                        + ciudadRecuperada.getNumHabitantes()+"/"
                        +ciudadRecuperada.getPromTemperatura());
            }
        }
    }
    void buscarPorNombre() {
        System.out.println("Buscando por nombre..");
        System.out.println("Digite el nombre a buscar");
        String nomBuscar = in.next();

        boolean bandera = false;
        for (int i = 0; i < registro.size(); i++) {
            Ciudad ciudadEncontrada = (Ciudad) registro.get(i);

            if (ciudadEncontrada.getNombre().equals(nomBuscar)) {
                System.out.println("Nobre: " + ciudadEncontrada.getNombre());
                System.out.println("Numero de Habitantes: " + ciudadEncontrada.getNumHabitantes());
                System.out.println("Temperatura Promedio: " + ciudadEncontrada.getPromTemperatura());

                bandera = true;
            }
        }
        if (bandera == false) {
            System.out.println("ciudad NO registrada!!!");
        }
    }
    void promedioTemperturas(){
        int suma=0;
        double promedio=0;
        for (int i = 0; i < registro.size(); i++) {
            Ciudad temCiudad=(Ciudad)registro.get(i);
            suma+=temCiudad.getPromTemperatura();
            
        }
        promedio=suma/registro.size();
        System.out.println("El promedio de la tempertura es: "+promedio);
    }
    void menu() {
        int opcion = 0;
        do {
            System.out.println("""
                               \n*****MENU DE OPCIONES*****
                               1. Rgistrar Ciudad
                               2. Consultar todos los registros
                               3. buscar por Nombre
                               4. Promedio de temperaturas
                               Opcion:""");

            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    this.agregarCiudad();
                    break;
                case 2:
                    this.Listar();
                    break;
                case 3:
                    this.buscarPorNombre();
                    break;
                case 4:
                    this.promedioTemperturas();
                    break;
            }
        } while (opcion > 0 && opcion < 5);
    }
}

