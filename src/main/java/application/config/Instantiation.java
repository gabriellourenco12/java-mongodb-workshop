package application.config;

import application.domain.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        userReposiroty.deleteAll();

        User batman = new User(null, "Bruce Wayne", "batman@jl.com");
        User flash = new User(null, "Barry Allen", "flash@jl.com");
        User ww = new User(null, "Diana Prince", "ww@jl.com");
        User greenLantern = new User(null, "Hal Jordan", "greenlantern@jl.com");
        User martian = new User(null, "Martian Manhunter", "martian@jl.com");
        User superman = new User(null, "Clark Kent", "superman@jl.com");
        User cyborg = new User(null, "Victor Stone", "cyborg@jl.com");

        userReposiroty.saveAll(Arrays.asList(batman,flash,ww,greenLantern,martian,superman,cyborg));
    }

}
