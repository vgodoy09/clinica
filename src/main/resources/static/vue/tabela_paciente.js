

new Vue({
	el: "#app",
	data: {
		pacienteData: [],
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
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getPaciente(id);
		
		this.listPacientes();

	},
	
	methods: {
		
		listPacientes() {
			axios.get("/clinica/api/clientes").then(resp => {
				this.pacienteData = resp.data;
			})
		},
		
		getPaciente(id) {
			axios.get("/clinica/getClientMemory/"+id).then(resp => {
				this.cliente = resp.data;
				console.log(this.cliente);
			})
		},
		
		clickUpdatePaciente: function(paciente) {
			axios.post("/clinica/saveInMemoryCliente", paciente).then(resp => {
				window.location.href = "/clinica/cadastropaciente?id=" + paciente.id;
			})
		},
		
		clickCreatePaciente: function() {
			window.location.href = "/clinica/cadastropaciente";
		},
		
		clickDeletePaciente: function(paciente) {
			deletePaciente(this,paciente);
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

function deletePaciente(vue, paciente) {
	vue.loadingImport = true;
	
	console.log(paciente.id);
	axios.delete("/clinica/api/clientes/"+ paciente.id, paciente).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/paciente";
	})
}

