package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
}
