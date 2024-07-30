package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.println("Check-in data: dd/mm/yyyy ");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("Check-out data: dd/mm/yyyy ");
            Date checkOut = sdf.parse(sc.next());


            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println(reserva);

            System.out.println();
            System.out.println("Informe a data para atualizar a reserva: ");
            System.out.println("Check-in data: dd/mm/yyyy ");
            checkIn = sdf.parse(sc.next());

            System.out.println("Check-out data: dd/mm/yyyy ");
            checkOut = sdf.parse(sc.next());

            reserva.updateDatas(checkIn, checkOut);
            System.out.println(reserva);
        }
        catch (ParseException e){
            System.out.println("Data inválida!");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        sc.close();
    }
}
