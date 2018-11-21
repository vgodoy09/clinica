

new Vue({
	el: "#app",
	data: {
		userLogger: null,
		pacienteData: [],
		agentDetailData: [],
		loadingImport: false
	},

	mounted() {
		this.listProcess();

		let url = window.location.pathname;
		this.userLogger = url.split("/")[2];
	},

	methods: {

		listProcess() {
			axios.get("/clinica/api/clientes").then(resp => {
				this.pacienteData = resp.data;
			})
		},

		clickImportCreated: function() {
//			this.loadingImport = true;
			axios.get("/clinica/paciente/created").then(resp => {
				this.pacienteData = resp.data;
			})
//			axios.post("/import/created/"+this.userLogger).then(resp => {
//				this.loadingImport = false;
//				this.listProcess();
//			})
		},
		
		clickImportUpdated: function() {
			this.loadingImport = true;
			axios.put("/import/updated/"+this.userLogger).then(resp => {
				this.loadingImport = false;
				this.listProcess();
			})
		},
		
		clickImportDeleted: function() {
			this.loadingImport = true;
			axios.delete("/import/deleted/"+this.userLogger).then(resp => {
				this.loadingImport = false;
				this.listProcess();
			})
		},

		clickRefreshDelete: function() {
			refreshExclusionInstance(this);
		},

		showModalErrors: function(id) {
			axios.get("/import/listerrors/"+id).then(resp => {
				this.agentDetailData = resp.data;	
				this.$refs.modalRef.show();
			})
		} 
	}

})


//faz importação 
function importInstance(vue) {

	if(vue.userLogger != null) {
		vue.loadingImport = true;

		//faz importação 
		axios.get("/import/"+vue.userLogger).then(response => {
			console.log(response.data);	
			vue.listProcess();
			vue.loadingImport = false;
		})
	}
}

function refreshExclusionInstance(vue) {
	if(vue.userLogger != null) {
		vue.loadingImport = true;

		//faz importação 
		axios.get("/refreshremove/"+vue.userLogger).then(response => {
			console.log(response.data);	
			vue.listProcess();
			vue.loadingImport = false; 
		})
	}
}


