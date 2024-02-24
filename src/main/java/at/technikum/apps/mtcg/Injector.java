package at.technikum.apps.mtcg;

import at.technikum.apps.mtcg.controller.*;
import at.technikum.apps.mtcg.repository.DatabaseUserRepository;
import at.technikum.apps.mtcg.repository.UserRepository;
import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;

import java.util.ArrayList;
import java.util.List;

/*
TO DO TO INJECT PROPERLY:
AbcRepoImage abcRepo = new AbcRepo() (DB and Memory should be same and if not be synced by usage)
AbcService abcService = new AbcService(abcRepo)
controllerList.add(new AbcController(abcService))
 */
public class Injector {

    public List<Controller> createControllerList() {
        List<Controller> controllerList = new ArrayList<>();
        UserRepository userRepository = new DatabaseUserRepository();
        UserService userService = new UserService(userRepository);
        controllerList.add(new UserController(userService));
        //session needs user data - no session repo - sessions are not persistent!
        SessionService sessionService = new SessionService(userService);
        controllerList.add(new SessionController(sessionService));
        //todo: add card repo
        //CardService cardService = new CardService();
        //controllerList.add(new CardController(cardService));

        //PackageService packageService = new PackageService();
        //controllerList.add(new PackageController(packageService));




        return controllerList;
    }
}
