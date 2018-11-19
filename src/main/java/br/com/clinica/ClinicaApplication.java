package br.com.clinica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.clinica.repository.ClienteRepository;
import br.com.clinica.repository.EspecialidadeRepository;
import br.com.clinica.repository.MedicoRepository;
 
@SpringBootApplication
public class ClinicaApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	@Autowired
	MedicoRepository medicoRepository;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClinicaApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//			Cliente cliente = new Cliente();
//		 	cliente.setName("Miriam do Prado Godoy");
//		    cliente.setLogin("miriam.godoy");
//		    cliente.setNumberChildren(2);
//		    cliente.setPassword("ika3b919");
//		    cliente.setDateBirth(LocalDate.now());
//		    cliente.setConvenio(true);
//		    cliente.setStatus(Status.ATIVO);
//		    cliente.setPhone("1147906017");
//		    Cliente save = clienteRepository.save(cliente);
//		    System.out.println(save.toString());
		
//		Especialidade e = new Especialidade();
//		e.setName("Cardiologista");
//		especialidadeRepository.save(e);
//		Especialidade e1 = new Especialidade();
//		e1.setName("Anestesiologia");
//		especialidadeRepository.save(e1);
		
//		Medico medico = new Medico();
//		medico.setName("Jose Roberto de Godoy");
//	    medico.setLogin("joseroberto.godoy");
//	    medico.setNumberChildren(2);
//	    medico.setPassword("kzgxgk18");
//	    medico.setDateBirth(LocalDate.now());
//	    medico.setEspecialidade(new Especialidade(1, "Cardiologista"));
//	    medico.setStatus(Status.ATIVO);
//	    medico.setPhone("1147906017");
//	    
//	    medicoRepository.save(medico);
	}
}
