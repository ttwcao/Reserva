package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de checkout deve ser após a data de check-in");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duracao(){
        //calcuclar duração em dias com base nas duas datas
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDatas(Date checkIn, Date checkOut) throws DomainException{
        Date agora = new Date();
        if(checkIn.before(agora) || checkOut.before(agora)){
            throw new DomainException("Datas de reserva para atualização devem ser datas futuras");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de checkout deve ser após a data de check-in");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto: "
                + numeroQuarto
                + ", check-in: "
                + simpleDateFormat.format(checkIn)
                + ", checkout: "
                + simpleDateFormat.format(checkOut)
                + ", "
                + duracao()
                + " noites";
    }
}
