

new Vue({
	el: "#app",
	data: {
		pacienteData: [],
		medicoData: [],
		consultaData: [],
		wrapper:{
			medicos: [],
			clientes: []
		},
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
		
		this.listConsultas();
	},
	
	methods: {
		getConsulta(id) {
			axios.get("/clinica/getConsultaMemory/"+id).then(resp => {
				this.consulta = resp.data;
			})
		},
		
		listConsultas() {
			axios.get("/clinica/api/consultas").then(resp => {
				this.consultaData = resp.data;
			})
		},
		
		clickCreatedConsulta: function() {
			axios.post("/clinica/saveInMemoryListMedicoAndCliente").then(resp => {
				window.location.href = "/clinica/cadastroconsulta";
			})
		},
		
		clickUpdatedConsulta: function(consulta) {
			axios.post("/clinica/saveInMemoryConsulta", consulta).then(resp => {
				window.location.href = "/clinica/cadastroconsulta?id=" + consulta.id;
			})
		},
		
		clickDeletedConsulta: function(consulta) {
			deleteConsultas(this,consulta);
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

function deleteConsultas(vue, consulta) {
	vue.loadingImport = true;
	
	console.log(consulta.id);
	axios.delete("/clinica/api/consultas/"+ consulta.id, consulta).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/consulta";
	})
}
