package at.technikum.apps.mtcg;

import at.technikum.apps.mtcg.controller.SessionController;
import at.technikum.apps.mtcg.controller.UserController;
import at.technikum.apps.mtcg.repository.UserRepository;
import at.technikum.apps.mtcg.repository.UserRepositoryInterface;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.apps.mtcg.controller.Controller;

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
        UserRepositoryInterface userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        controllerList.add(new UserController(userService));
        //todo: add session repo interface
        SessionService sessionService = new SessionService();
        controllerList.add(new SessionController(sessionService));


        return controllerList;
    }
}
