

new Vue({
	el: "#app",
	data: {
		consulta: {
			id: null,
			descricao: null,
			dataConsulta: null,
			medico: null,
			cliente: null
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getConsulta(id);

	},
	
	methods: {
		getConsulta(id) {
			axios.get("/clinica/getConsultaMemory/"+id).then(resp => {
				this.consulta = resp.data;
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
		
		clickNovoConsulta: function() {
			createConsulta(this);
		}
	}

})

//function getPaciente() {
//	axios.get("/clinica/getClient/"+this.clienteId).then(resp => {
//		this.cliente = resp.data;
//		console.log(this.client);
//	})
//}

function createConsulta(vue) {
	vue.loadingImport = true;
	axios.post("/clinica/api/consultas", vue.consulta).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/consulta";
	})

}