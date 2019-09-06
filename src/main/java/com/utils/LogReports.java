package com.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.cleartrip.ConstantFilePaths;

public class LogReports {

		
		Logger log=null;

		public LogReports() {
			getlogger();
			log = Logger.getLogger(LogReports.class.getName());
		}

		public void getlogger() {
			PropertyConfigurator.configure("C:\\Users\\siva.mutyala\\eclipse-workspace\\com.cleartrip\\resources\\log4j\\log4j.properties");
		}

		public void info(String message) {
			log.info(message);
		}
	}
