package br.com.clinica;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.clinica.model.Cliente;
import br.com.clinica.model.enuns.Status;
import br.com.clinica.repository.ClienteRepository;
import br.com.clinica.repository.ConsultasRepository;
import br.com.clinica.repository.EspecialidadeRepository;
import br.com.clinica.repository.MedicoRepository;
import br.com.clinica.repository.UserRepository;
 
@SpringBootApplication
public class ClinicaApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	@Autowired
	MedicoRepository medicoRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ConsultasRepository consultasRepository;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClinicaApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
//		Medico medico = new Medico(4);
//		medico.setName("Jose Roberto de Godoy");
//	    medico.setLogin("joseroberto.godoy");
//	    medico.setNumberChildren(2);
//	    medico.setPassword("12345678");
//	    medico.setDateBirth(LocalDate.now());
//	    medico.setEspecialidade(new Especialidade(1, "Cardiologista"));
//	    medico.setStatus(Status.ATIVO);
//	    medico.setPhone("1147906017");
//	    
//		Cliente cliente = new Cliente(2);
//	 	cliente.setName("Jayne Moraes");
//	    cliente.setLogin("jayne.moraes");
//	    cliente.setNumberChildren(2);
//	    cliente.setPassword("12345678");
//	    cliente.setDateBirth(LocalDate.now());
//	    cliente.setConvenio(true);
//	    cliente.setStatus(Status.ATIVO);
//	    cliente.setPhone("1147906017");
//		
//			Consulta consulta = new Consulta();
//			consulta.setDataConsulta(LocalDate.now());
//		    consulta.setDescricao("Cardiologista com Dr Lenio");
//		    consulta.setStatus(Status.ATIVO);
//		    consulta.setMedico(medico);
//		    consulta.setCliente(cliente);
//		    consultasRepository.save(consulta);
//		    
//			Cliente cliente = new Cliente();
//		 	cliente.setName("Matheus Gregorio");
//		    cliente.setLogin("matheus.gregorio");
//		    cliente.setNumberChildren(0);
//		    cliente.setPassword("12345678");
//		    cliente.setDateBirth(LocalDate.now());
//		    cliente.setConvenio(true);
//		    cliente.setStatus(Status.ATIVO);
//		    cliente.setPhone("1147906017");
//		    Cliente save = clienteRepository.save(cliente);
//		    System.out.println(save.toString());
//		
//		Especialidade e = new Especialidade();
//		e.setName("Cardiologista");
//		especialidadeRepository.save(e);
//		Especialidade e1 = new Especialidade();
//		e1.setName("Anestesiologia");
//		especialidadeRepository.save(e1);
//		
//		Medico medico = new Medico();
//		medico.setName("Jose Roberto de Godoy");
//	    medico.setLogin("joseroberto.godoy");
//	    medico.setNumberChildren(2);
//	    medico.setPassword("12345678");
//	    medico.setDateBirth(LocalDate.now());
//	    medico.setEspecialidade(new Especialidade(1, "Cardiologista"));
//	    medico.setStatus(Status.ATIVO);
//	    medico.setPhone("1147906017");
//	    
//	    medicoRepository.save(medico);
		
//		UserDTO login = userRepository.login("victor.godoy", "x8pdkv19");
//		System.out.println(login);
	}
}
