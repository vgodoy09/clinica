

new Vue({
	el: "#app",
	data: {
		especialidadeData: [],
		especialidade: {
			id: null,
			name: null
		},
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getEspecialidade(id);

		this.listEspecialidades();
	},
	
	methods: {
		getEspecialidade(id) {
			axios.get("/clinica/getEspecialidadeMemory/"+id).then(resp => {
				this.especialidade = resp.data;
			})
		},
		
		listEspecialidades() {
			axios.get("/clinica/api/especialidades").then(resp => {
				this.especialidadeData = resp.data;
			})
		},
		
		clickCreatedEspecialidade: function() {
			window.location.href = "/clinica/cadastroespecialidade";
		},
		
		clickUpdatedEspecialidade: function(especialidade) {
			axios.post("/clinica/saveInMemoryEspecialidade", especialidade).then(resp => {
				window.location.href = "/clinica/cadastroespecialidade?id=" + especialidade.id;
			})
		},
		
		clickDeletedEspecialidade: function(especialidade) {
			deleteEspecialidade(this,especialidade);
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

function deleteEspecialidade(vue, especialidade) {
	vue.loadingImport = true;
	
	console.log(especialidade.id);
	axios.delete("/clinica/api/especialidades/"+ especialidade.id, especialidade).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/especialidade";
	})
}
