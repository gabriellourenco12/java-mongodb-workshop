package application.config;

import application.domain.Post;
import application.domain.User;
import application.dto.AuthorDTO;
import application.repository.PostRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postReposiroty.deleteAll();

        User batman = new User(null, "Bruce Wayne", "batman@jl.com");
        User flash = new User(null, "Barry Allen", "flash@jl.com");
        User ww = new User(null, "Diana Prince", "ww@jl.com");
        User greenLantern = new User(null, "Hal Jordan", "greenlantern@jl.com");
        User martian = new User(null, "Martian Manhunter", "martian@jl.com");
        User superman = new User(null, "Clark Kent", "superman@jl.com");
        User cyborg = new User(null, "Victor Stone", "cyborg@jl.com");

        userReposiroty.saveAll(Arrays.asList(batman,flash,ww,greenLantern,martian,superman,cyborg));

        Post post1 = new Post(null, sdf.parse("06/06/2022"), "Aviso: Reunião Urgente", "Teremos uma reunião hoje de caráter emergencial!", new AuthorDTO(batman));
        Post post2 = new Post(null, sdf.parse("16/03/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(flash));
        Post post3 = new Post(null, sdf.parse("13/04/2022"), "Vou viajar", "Vou voltar para Marte. Abraços!", new AuthorDTO(martian));
        Post post4 = new Post(null, sdf.parse("30/01/2022"), "O time de Gotham joga hoje", "Go Gotham!", new AuthorDTO(batman));
        Post post5 = new Post(null, sdf.parse("30/01/2022"), "Supercão", "O supercão aprendeu a dar a patinha!", new AuthorDTO(superman));

        postReposiroty.saveAll(Arrays.asList(post1, post2, post3, post4, post5));

        batman.getPosts().addAll(Arrays.asList(post1, post4));
        flash.getPosts().add(post2);
        userReposiroty.save(batman);
        userReposiroty.save(flash);
    }

}
