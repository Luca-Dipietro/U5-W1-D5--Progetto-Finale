package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lombok.extern.slf4j.Slf4j;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.User;
import lucadipietro.U5_W1_D5__Progetto_Finale.exceptions.NotFoundException;
import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(User newUser){
        if(usersRepository.existsByUsername(newUser.getUsername())){
            throw new RuntimeException("L'username " + newUser.getUsername() + " è già in uso");
        }

        usersRepository.save(newUser);

        log.info("Nuovo utente " + newUser.getUsername() + " salvato con successo nel db");
    }

    public User findById(long id){
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        User found = this.findById(id);
        usersRepository.delete(found);
        log.info("Utente con id " + id + " eliminato correttamente");
    }
}
