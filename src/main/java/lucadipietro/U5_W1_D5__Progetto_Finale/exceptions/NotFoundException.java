package lucadipietro.U5_W1_D5__Progetto_Finale.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("Il record con l'id " + id + " non è stato trovato!");
    }
}
