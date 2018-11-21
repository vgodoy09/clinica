

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
		this.listProcess();
		this.listConsultas();
		this.listEspecialidades();
		this.listMedicos();

		let url = window.location.pathname;
		this.userLogger = url.split("/")[2];
	},

	methods: {

		listProcess() {
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
//			this.loadingImport = true;
//			console.log('JSON ' + JSON.stringify(this.cliente));
//			axios.post("/clinica/api/clientes", this.cliente).then(resp => {
//				this.loadingImport = false;
//				this.listProcess();
//			})
			createPaciente(this);
		},
		
		clickImportUpdated: function() {
			this.loadingImport = true;
			axios.put("/import/updated/"+this.userLogger).then(resp => {
				this.loadingImport = false;
				this.listProcess();
			})
		},
		
		clickImportDeleted: function() {
			this.loadingImport = true;
			axios.delete("/import/deleted/"+this.userLogger).then(resp => {
				this.loadingImport = false;
				this.listProcess();
			})
		},

		clickRefreshDelete: function() {
			refreshExclusionInstance(this);
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
	console.log('JSON ' + JSON.stringify(vue.cliente));
	axios.post("/clinica/api/clientes", vue.cliente).then(resp => {
		vue.loadingImport = false;
		vue.listProcess();
	})
}

//faz importação 
function importInstance(vue) {

	if(vue.userLogger != null) {
		vue.loadingImport = true;

		//faz importação 
		axios.get("/import/"+vue.userLogger).then(response => {
			console.log(response.data);	
			vue.listProcess();
			vue.loadingImport = false;
		})
	}
}

function refreshExclusionInstance(vue) {
	if(vue.userLogger != null) {
		vue.loadingImport = true;

		//faz importação 
		axios.get("/refreshremove/"+vue.userLogger).then(response => {
			console.log(response.data);	
			vue.listProcess();
			vue.loadingImport = false; 
		})
	}
}


