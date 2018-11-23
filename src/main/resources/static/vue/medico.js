//plugin de mascaras
Vue.use(VueMask.VueMaskPlugin);

new Vue({
	el: "#app",
	data: {
		mobileMask: '(##)#####-####',
		dateMask: '##/##/####',
		especialidadeData: [],
		especialidade: {
			id: null,
			name: null
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
			especialidadeId: null,
			especialidade: {
				id: null,
				name: null
			}
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		var especialidadeId = location.search.split('especialidadeId=')[1];
		if(id != null && typeof id != "undefined" && especialidadeId != null && typeof especialidadeId != "undefined") 
			this.getMedico(id, especialidadeId);
		
		this.listEspecialidade();

	},
	
	methods: {
		getMedico(id) {
			console.log(id);
			axios.get("/clinica/getMedicoMemory/"+id).then(resp => {
				this.medico = resp.data;
			})
			axios.get("/clinica/getEspecialidadeIdMemory").then(resp => {
				this.medico.especialidadeId = resp.data;
				console.log(this.medico.especialidadeId);
			})
		},
		
		listEspecialidade() {
			axios.get("/clinica/getListEspecialidadeMemory").then(resp => {
				this.especialidadeData = resp.data;
			})
		},
		
		clickNovoMedico: function() {
			createMedico(this);
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

function createMedico(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/medicos", vue.medico).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/medico";
	})

}