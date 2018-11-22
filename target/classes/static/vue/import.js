

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

		let url = window.location.pathname;
		this.userLogger = url.split("/")[2];
	},

	methods: {

		
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
		
		clickUpdatePaciente: function(paciente) {
			this.cliente = paciente;
			alert(this.cliente.name);
			console.log(paciente);
			console.log(this.cliente.name);
			window.location.href = "/clinica/cadastropaciente";
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


function createPaciente(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/clientes", vue.cliente).then(resp => {
		vue.loadingImport = false;
		vue.listPacientes();
		window.location.href = "/clinica/paciente";
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
	axios.delete("/clinica/api/clientes"+ paciente.id, paciente).then(resp => {
		vue.loadingImport = false;
		vue.listPacientes();
		window.location.href = "/clinica/paciente";
	})
}




