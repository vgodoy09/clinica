

new Vue({
	el: "#app",
	data: {
		medicoData: [],
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
			especialidade: {
				id: null,
				name: null
			}
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getMedico(id);
		
		this.listMedicos();
		this.listEspecialidades();

	},
	
	methods: {
		getMedico(id) {
			console.log(id);
			axios.get("/clinica/getMedicoMemory/"+id).then(resp => {
//				let cli = JSON.stringify(resp.data);
//				console.log(cli);
//				console.log(JSON.parse(cli));
				this.medico = resp.data;
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
		
		clickCreatedMedico: function() {
			axios.post("/clinica/saveInMemoryListEspecialidade", this.especialidadeData).then(resp => {
				window.location.href = "/clinica/cadastromedico";
			})
		},
		
		clickUpdatedMedico: function(medico) {
			alert(medico.especialidadeId);
			axios.post("/clinica/saveInMemoryMedico", medico).then(resp => {
				window.location.href = "/clinica/cadastromedico?id=" + medico.id;
			})
		},
		
		clickDeletedMedico: function(medico) {
			deleteMedicos(this,medico);
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

function deleteMedicos(vue, medico) {
	vue.loadingImport = true;
	
	console.log(medico.id);
	axios.delete("/clinica/api/medicos/"+ medico.id, medico).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/medico";
	})
}

