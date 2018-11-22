

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
			especialidade: null
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
				console.log(this.medico.name);
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
		
		clickNovoMedico: function() {
			createMedico(this);
		}
	}

})

//function getPaciente() {
//	axios.get("/clinica/getClient/"+this.clienteId).then(resp => {
//		this.cliente = resp.data;
//		console.log(this.client);
//	})
//}

function createMedico(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/medicos", vue.medico).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/medico";
	})

}