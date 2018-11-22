

new Vue({
	el: "#app",
	data: {
		especialidade: {
			id: null,
			name: null
		},
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getEspecialidade(id);

	},
	
	methods: {
		getEspecialidade(id) {
			axios.get("/clinica/getEspecialidadeMemory/"+id).then(resp => {
				this.especialidade = resp.data;
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
		
		clickNovaEspecialidade: function() {
			createEspecialidade(this);
		}
	}

})

//function getPaciente() {
//	axios.get("/clinica/getClient/"+this.clienteId).then(resp => {
//		this.cliente = resp.data;
//		console.log(this.client);
//	})
//}

function createEspecialidade(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/especialidades", vue.especialidade).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/especialidade";
	})

}