
//plugin de mascaras
Vue.use(VueMask.VueMaskPlugin);

new Vue({
	el: "#app",
	data: {
		pacienteData: [],
		medicoData: [],
		dateMask: '##/##/####',
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
		consulta: {
			id: null,
			descricao: null,
			dataConsulta: null,
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
			}
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getConsulta(id);
		
		this.listPacientes();
		this.listMedicos();

	},
	
	methods: {
		getConsulta(id) {
			axios.get("/clinica/getConsultaMemory/"+id).then(resp => {
				this.consulta = resp.data;
			})
		},
		
		listPacientes() {
			axios.get("/clinica/getListClienteMemory/").then(resp => {
				this.pacienteData = resp.data;
			})
		},
		
		listMedicos() {
			axios.get("/clinica/getListMedicoMemory/").then(resp => {
				this.medicoData = resp.data;
			})
		},
		
		clickNovoConsulta: function() {
			createConsulta(this);
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
		}
	}

})

function createConsulta(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/consultas", vue.consulta).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/consulta";
	})

}