package br.com.clinica.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.model.Cliente;
import br.com.clinica.model.Consulta;
import br.com.clinica.model.Especialidade;
import br.com.clinica.model.Medico;
import br.com.clinica.repository.ClienteRepository;
import br.com.clinica.repository.EspecialidadeRepository;
import br.com.clinica.repository.MedicoRepository;

@RestController
public class StateClient {

	@Autowired
	@Qualifier("paciente")
	private Map<Integer, Cliente> mapClient;
	@Autowired
	@Qualifier("especialidade")
	private Map<Integer, Especialidade> mapEspecialidade;
	@Autowired
	@Qualifier("consulta")
	private Map<Integer, Consulta> mapConsulta;
	@Autowired
	@Qualifier("medico")
	private Map<Integer, Medico> mapMedico;
	@Autowired
	@Qualifier("listespecialidade")
	private List<Especialidade> listEspecialidade;
	@Autowired
	@Qualifier("listcliente")
	private List<Cliente> listCliente;
	@Autowired
	@Qualifier("listmedico")
	private List<Medico> listMedico;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	
	
	@PostMapping("saveInMemoryCliente")
	public Boolean saveMemory(@RequestBody Cliente cliente) {
		mapClient.put(cliente.getId(), cliente);
		return true;
	}
	
	@GetMapping("getClientMemory/{id}")
	public Cliente getClient(@PathVariable("id") Integer id) {
		return mapClient.get(id);
	}
	
	@PostMapping("saveInMemoryEspecialidade")
	public Boolean saveMemoryEspecialidade(@RequestBody Especialidade especialidade) {
		mapEspecialidade.put(especialidade.getId(), especialidade);
		return true;
	}
	
	@GetMapping("getEspecialidadeMemory/{id}")
	public Especialidade getEspecialidade(@PathVariable("id") Integer id) {
		return mapEspecialidade.get(id);
	}
	
	@PostMapping("saveInMemoryConsulta")
	public Boolean saveMemoryConsulta(@RequestBody Consulta consulta) {
		mapConsulta.put(consulta.getId(), consulta);
		return true;
	}
	
	@GetMapping("getConsultaMemory/{id}")
	public Consulta getConsulta(@PathVariable("id") Integer id) {
		return mapConsulta.get(id);
	}
	
	@PostMapping("saveInMemoryMedico")
	public Boolean saveMemoryMedico(@RequestBody Medico medico) {
		mapMedico.put(medico.getId(), medico);
		listEspecialidade = especialidadeRepository.findAll();
		return true;
	}
	
	@GetMapping("getMedicoMemory/{id}")
	public Medico getMedico(@PathVariable("id") Integer id) {
		Medico medico = mapMedico.get(id);
		return medico;
	}
	
	@PostMapping("saveInMemoryListEspecialidade")
	public Boolean saveMemoryListEspecialidade(@RequestBody List<Especialidade> list) {
		listEspecialidade = list;
		return true;
	}
	
	@GetMapping("getListEspecialidadeMemory")
	public List<Especialidade> listEspecialidade() {
		return listEspecialidade;
	}
	
	@PostMapping("saveInMemoryListCliente")
	public Boolean saveMemoryListCliente(@RequestBody List<Cliente> list) {
		listCliente = list;
		return true;
	}
	
	@GetMapping("getListClienteMemory")
	public List<Cliente> listCliente() {
		return listCliente;
	}
	
//	@PostMapping("saveInMemoryListMedico")
//	public Boolean saveMemoryListMedico(@RequestBody List<UserDTO> list) {
//		listMedico = list;
//		return true;
//	}
	@PostMapping("saveInMemoryListMedico")
	public Boolean saveMemoryListMedico(@RequestBody List<Medico> list) {
		listMedico = list;
		return true;
	}
	
	@PostMapping("saveInMemoryListMedicoAndCliente")
	public Boolean saveMemoryListMedicoAndCliente() {
		this.listMedico = medicoRepository.findAll();
		this.listCliente = clienteRepository.findAll();
		return true;
	}
	
	@GetMapping("getListMedicoMemory")
	public List<Medico> listMedico() {
		return listMedico;
	}
	
	
}
