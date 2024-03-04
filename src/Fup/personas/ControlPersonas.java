/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fup.personas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1059356842
 */
public class ControlPersonas {

    ArrayList registro = new ArrayList();
    Scanner in = new Scanner(System.in);

    //metoo para añadir personas a la lista
    void agregarPersona() {
        //pedir los datos
        System.out.println("Digite el nombre");
        String name = in.next();
        System.out.println("Digite el apellido");
        String lastname = in.next();
        System.out.println("Digite la cedula");
        int id = in.nextInt();

        //creo un objeto de tipo persona
        Persona per = new Persona();
        //seteo los datos que digito el usuario
        per.setNombre(name);
        per.setApellido(lastname);
        per.setCedula(id);
        //agrego el objeto a la lista
        registro.add(per);
        System.out.println("Datos de la persona registrados exitosamente");
    }

    void consutarTodo() {
        if (registro.isEmpty()) {
            System.out.println("No hay personas registradas");
        } else {
            System.out.println("Listando...");
            for (int i = 0; i < registro.size(); i++) {
                Persona perRecuperada = (Persona) registro.get(i);

                System.out.println(perRecuperada.getNombre() + " "
                        + perRecuperada.getApellido() + " "
                        + perRecuperada.getCedula());
            }
        }
    }

    //metodo para buscar por cedula
    void buscarPorCedula() {
        System.out.println("Buscando por cedula..");
        System.out.println("Digite la cedula a buscar");
        int cedBuscar = in.nextInt();

        boolean bandera = false;
        for (int i = 0; i < registro.size(); i++) {
            Persona perEncontrada = (Persona) registro.get(i);

            if (perEncontrada.getCedula() == cedBuscar) {
                System.out.println("Nobre: " + perEncontrada.getNombre());
                System.out.println("Apellido: " + perEncontrada.getApellido());
                bandera = true;
            }
        }
        if (bandera == false) {
            System.out.println("ersona NO registrada!!!");
        }
    }

    void menu() {
        int opcion = 0;
        do {
            System.out.println("""
                               \n*****MENU DE OPCIONES*****
                               1. Rgistrar persona
                               2.Consultar todos los registros
                               3. buscar por Cedula
                               4.Salir 
                               Opcion:""");

            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    this.agregarPersona();
                    break;
                case 2:
                    this.consutarTodo();
                    break;
                case 3:
                    this.buscarPorCedula();
                    break;
                
            }
        } while (opcion > 0 && opcion < 4);
    }
}
