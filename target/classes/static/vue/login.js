
//plugin de mascaras
//Vue.use(VueMask.VueMaskPlugin);

new Vue({
	el: '#login',
	data: {
		error: false,
//		numbercpf: '',
		login: '',
		password: '',
		messageError: ''
//		cpfMask: '###.###.###-##'
	},

	methods: {

		clickCloseErroLogin: function() {
			this.error = false;
		},

		clickLogin: function() {
			loggerInstance(this);
		},
		
//		keyupNumberCpf: function() {
//			this.error = false;
//		}

	}
})

//método de logar usuário
function loggerInstance(vue) {
	
	if(vue.login == '' || vue.password == '') {
		vue.messageError = "Usuario inexistente";
		vue.error = true;
		return;
	}
	console.log('login' + vue.login);
	console.log('password' + vue.password);
	axios.post("/clinica/login/"+vue.login + "/"+vue.password).then(response => {

		if(response.data.error) {
			vue.messageError = response.data.message;
			vue.error = true;
		}
		else {
			window.location.href = "/clinica/admin";
		}
		
	}).catch(error => {
		console.log(error)
	})

}