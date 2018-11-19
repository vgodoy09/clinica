package br.com.clinica.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServer {

	Logger logger = LoggerFactory.getLogger(LogServer.class);

	public void monitoringAccessLog(String nameClass, List<Object> list, String param) {
		
		if(list == null || list.isEmpty()) {
			logger.info("Na Classe: "+nameClass+" ==> Não obteve resultado do serviço para a pesquisa:" +param);
		}
	}
	
	public void monitoringAccessLog(String nameClass, Object object, String param) {
		if(object == null) {
			logger.info("Na Classe: "+nameClass+" ==> Não obteve resultado do serviço para esse request: "+param);
		}
	}

	public void monitoringErrorLog(String nameClass, String error, String param) {
		logger.error("Na Classe: "+nameClass+" ==> "+error+" "+param);
	}
}
