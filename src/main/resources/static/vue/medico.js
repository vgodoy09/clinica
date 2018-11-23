

new Vue({
	el: "#app",
	data: {
		medico: {
			id: null,
			name: null,
			login: null,
			password: null,
			numberChildren: null,
			phone: null,
			status: "ATIVO",
			dateDate: null,
//			especialidade: 1
			especialidade: {
				id: 1,
				name: null
			}
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getMedico(id);

	},
	
	methods: {
		getMedico(id) {
			console.log(id);
			axios.get("/clinica/getMedicoMemory/"+id).then(resp => {
				this.medico = resp.data;
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