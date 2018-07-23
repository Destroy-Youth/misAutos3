package org.unitec.misAutos3;


import model.Admin;
import model.RepositorioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MisAutos3Application implements CommandLineRunner{
    
    @Autowired RepositorioAdmin repoAdmin;

	public static void main(String[] args) {
		SpringApplication.run(MisAutos3Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Admin adm = new Admin("Yop", "234234");
        repoAdmin.save(adm);
        System.out.println("Mensajeguardado");
        
    }
}
