

new Vue({
	el: "#app",
	data: {
		userLogger: null,
		pacienteData: [],
		consultaData: [],
		especialidadeData: [],
		medicoData: [],
		agentDetailData: [],
		loadingImport: false,
		pacientenome: null,
		cliente: {
			id: null,
			name: null,
			login: null,
			password: null,
			numberChildren: null,
			phone: null,
			status: "ATIVO",
			dateBirth: null,
			convenio: null
		},
		medico: {
			id: null,
			name: null,
			login: null,
			password: null,
			numberChildren: null,
			phone: null,
			status: "ATIVO",
			dateDate: null,
			especialidade: null
		},
		especialidade: {
			id: null,
			name: null
		},
		consulta: {
			id: null,
			descricao: null,
			dataConsulta: null,
			medico: null,
			cliente: null
		}
	},

	mounted() {
		this.listPacientes();
		this.listConsultas();
		this.listEspecialidades();
		this.listMedicos();

		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getPaciente(id);
	},

	methods: {
		
		getPaciente(id) {
			axios.get("/clinica/getClientMemory/"+id).then(resp => {
				this.cliente = resp.data;
				console.log(this.cliente);
			})
		},
		
		clickClinica: function() {
			window.location.href = "/clinica/";
		},
		
		clickMedico: function() {
			window.location.href = "/clinica/medico";
		},
		
		clickPaciente: function() {
			window.location.href = "/clinica/paciente";
		},
		
		clickEspecialidade: function() {
			window.location.href = "/clinica/especialidade";
		},
		
		clickLogout: function() {
			window.location.href = "/clinica/logout";
		},
		
		listPacientes() {
			axios.get("/clinica/api/clientes").then(resp => {
				this.pacienteData = resp.data;
			})
		},
		
		listConsultas() {
			axios.get("/clinica/api/consultas").then(resp => {
				this.consultaData = resp.data;
			})
		},
		
		listEspecialidades() {
			axios.get("/clinica/api/especialidades").then(resp => {
				this.especialidadeData = resp.data;
			})
		},
		
		listMedicos() {
			axios.get("/clinica/api/medicos").then(resp => {
				this.medicoData = resp.data;
			})
		},

		clickNovoPaciente: function() {
			createPaciente(this);
		},
		
		clickNovoMedico: function() {
			createMedico(this);
		},
		
		clickNovoConsulta: function() {
			createConsulta(this);
		},
		
		clickNovaEspecialidade: function() {
			createEspecialidade(this);
		},
		
		clickUpdatePaciente: function(paciente) {
			axios.post("/clinica/saveInMemory", paciente).then(resp => {
				window.location.href = "/clinica/cadastropaciente?id=" + paciente.id;
			})
		},
		
		clickCreatePaciente: function() {
			window.location.href = "/clinica/cadastropaciente";
		},
		
		
		clickCreatedEspecialidade: function() {
			window.location.href = "/clinica/cadastroespecialidade";
		},
		
		clickUpdatedEspecialidade: function() {
			window.location.href = "/clinica/cadastroespecialidade";
		},
		clickDeletedEspecialidade: function(especialidade) {
			deleteEspecialidade(this,especialidade);
		},
		
		clickCreatedMedico: function() {
			window.location.href = "/clinica/cadastromedico";
		},
		
		clickUpdatedMedico: function() {
			window.location.href = "/clinica/cadastromedico";
		},
		clickDeletedMedico: function(medico) {
			deleteMedicos(this,medico);
		},
		
		clickCreatedConsulta: function() {
			window.location.href = "/clinica/cadastroconsulta";
		},
		
		clickUpdatedConsulta: function() {
			window.location.href = "/clinica/cadastroconsulta";
		},
		clickDeletedConsulta: function(consulta) {
			deleteConsultas(this,consulta);
		},
		
		clickDeletePaciente: function(paciente) {
			deletePaciente(this,paciente);
		},
		
		clickGetPaciente: function(paciente) {
			getPaciente(this,paciente);
		},

		showModalErrors: function(id) {
			axios.get("/import/listerrors/"+id).then(resp => {
				this.agentDetailData = resp.data;	
				this.$refs.modalRef.show();
			})
		} 
	}

})


function createEspecialidade(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/especialidades", vue.especialidade).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/especialidade";
	})
}

function createPaciente(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/clientes", vue.cliente).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/paciente";
	})

}
function createMedico(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/medicos", vue.medico).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/medico";
	})
}
function createConsulta(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/consultas", vue.consulta).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/consulta";
	})
}

function getPaciente(vue, cliente) {
	vue.cliente = cliente;
	let cli = JSON.stringify(cliente);
	vue.cliente = JSON.parse(cli);
	console.log(cli);
	console.log(JSON.parse(cli));
	console.log(cliente);
	console.log(vue.cliente.id);
}

function deletePaciente(vue, paciente) {
	vue.loadingImport = true;
	
	console.log(paciente.id);
	axios.delete("/clinica/api/clientes/"+ paciente.id, paciente).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/paciente";
	})
}

function deleteEspecialidade(vue, especialidade) {
	vue.loadingImport = true;
	
	console.log(especialidade.id);
	axios.delete("/clinica/api/especialidades/"+ especialidade.id, especialidade).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/especialidade";
	})
}

function deleteConsultas(vue, consulta) {
	vue.loadingImport = true;
	
	console.log(consulta.id);
	axios.delete("/clinica/api/consultas/"+ consulta.id, consulta).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/consulta";
	})
}

function deleteMedicos(vue, medico) {
	vue.loadingImport = true;
	
	console.log(medico.id);
	axios.delete("/clinica/api/medicos/"+ medico.id, medico).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/medico";
	})
}




