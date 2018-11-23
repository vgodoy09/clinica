//plugin de mascaras
Vue.use(VueMask.VueMaskPlugin);

new Vue({
	el: "#app",
	data: {
		mobileMask: '(##)#####-####',
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
			convenio: false
		}
	},
	mounted() {
		var id = location.search.split('id=')[1];
		if(id != null && typeof id != "undefined") 
			this.getPaciente(id);

	},
	
	methods: {
		getPaciente(id) {
			axios.get("/clinica/getClientMemory/"+id).then(resp => {
				this.cliente = resp.data;
				console.log(this.cliente);
			})
		},
		
		clickNovoPaciente: function() {
			createPaciente(this);
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

function createPaciente(vue) {
	vue.loadingImport = true;
	console.log(vue.cliente.convenio);
	axios.post("/clinica/api/clientes", vue.cliente).then(resp => {
		vue.loadingImport = false;
		window.location.href = "/clinica/paciente";
	})

}