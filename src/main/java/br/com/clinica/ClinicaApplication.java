package br.com.clinica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import br.com.clinica.model.Cliente;
import br.com.clinica.model.Consulta;
import br.com.clinica.model.Especialidade;
import br.com.clinica.model.Medico;
import br.com.clinica.model.dto.UserDTO;
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
	

	@Bean(name="paciente")
	public Map<Integer, Cliente> mapCliente() {
		HashMap<Integer, Cliente> mapClient = new HashMap<>();
		return mapClient;
	}
	
	@Bean(name="especialidade")
	public Map<Integer, Especialidade> mapEspecialidade() {
		HashMap<Integer, Especialidade> mapEspecialidade = new HashMap<>();
		return mapEspecialidade;
	}
	
	@Bean(name="consulta")
	public Map<Integer, Consulta> mapConsulta() {
		HashMap<Integer, Consulta> mapConsulta = new HashMap<>();
		return mapConsulta;
	}
	
	@Bean(name="medico")
	public Map<Integer, Medico> mapMedico() {
		HashMap<Integer, Medico> mapMedico = new HashMap<>();
		return mapMedico;
	}
	
	@Bean(name="listespecialidade")
	public List<Especialidade> listEspecialidade() {
		return new ArrayList<Especialidade>();
	}
	
	@Bean(name="listcliente")
	public List<Cliente> listCliente() {
		return new ArrayList<Cliente>();
	}
	@Bean(name="listmedico")
	public List<UserDTO> listMedico() {
		return new ArrayList<UserDTO>();
	}
	
	@Bean(name="especialidadeId")
	public Integer getEspecialidadeId() {
		return new Integer(0);
	}
	
	@Override
	public void run(String... args) throws Exception {
			
//		Medico medico = new Medico(2);
//		medico.setName("Jose Roberto de Godoy");
//	    medico.setLogin("joseroberto.godoy");
//	    medico.setNumberChildren(2);
//	    medico.setPassword("12345678");
//	    medico.setDateBirth(LocalDate.now());
//	    medico.setEspecialidade(new Especialidade(1, "Cardiologista"));
//	    medico.setStatus(Status.ATIVO);
//	    medico.setPhone("1147906017");
//	    
//		Cliente cliente = new Cliente(1);
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
//		 	cliente.setName("Victor Prado de Godoy");
//		    cliente.setLogin("victor.godoy");
//		    cliente.setNumberChildren(0);
//		    cliente.setPassword("123456789");
//		    cliente.setDateBirth("19/10/1991");
//		    cliente.setConvenio(true);
//		    cliente.setStatus(Status.ATIVO);
//		    cliente.setPhone("(11)96371-3714");
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
