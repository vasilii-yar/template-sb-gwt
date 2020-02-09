package com.template_sb_gwt;

import com.template_sb_gwt.database.HumanRepository;
import com.template_sb_gwt.database.entities.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TemplateSbGwtApplication implements CommandLineRunner {

    private final HumanRepository repository;

    @Autowired
    public TemplateSbGwtApplication(HumanRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TemplateSbGwtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Human> humans = new ArrayList<>();

        humans.add(new Human("John", "Smith", "male", "UK"));
        humans.add(new Human("Michal", "Dallas", "male", "USA"));
        humans.add(new Human("Judy", "Dao", "female", "Denmark"));
        humans.add(new Human("Linda", "Fischer", "female", "Austria"));
        humans.add(new Human("Sarah", "Schwarzenegger", "female", "Poland"));
        humans.add(new Human("Leila", "Golicina", "female", "Ukraine"));
        humans.add(new Human("Lao", "Zen dong", "male", "China"));

        repository.saveAll(humans);
    }
}
