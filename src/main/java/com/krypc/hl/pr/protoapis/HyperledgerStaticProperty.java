package com.krypc.hl.pr.protoapis;
/**
 * Redesigned 13/01/2017
 * Add only new ENUM Variable.
 * Add any thing else if only needed
 * @author mohit
 */
public class HyperledgerStaticProperty {
	
	public static boolean isDevMode;
	public static String host = "";
	public static int port = -1;
	public static String host_membership = "";
	public static int port_membership = -1;
	public static String host_rest = "";
	public static int port_rest = -1;
	public static String host_event_hub = "";
	public static int port_event_hub = -1;
	public static String path_javask_db;
	public static String path_chaincode_id;
	
	static{
		host = System.getenv("PEER_IP");
		host_membership = System.getenv("MEMBERSHIP_IP");
		//DOCKER ENV
		if( host !=null && host_membership!= null ){
			port = Integer.parseInt(System.getenv("PEER_PORT"));
			port_membership = Integer.parseInt(System.getenv("MEMBERSHIP_PORT"));
		}else{
			//LOCAL ENV
			CONFIGS config = CONFIGS.DEFAULTCONFIG; //Only Change this value
			isDevMode = config.isDevMode;
			host = config.host;
			//||Setting up all the properties:::
			host_membership 			= config.host_membership;
			host_rest 					= config.host_rest;
			host_event_hub				= config.host_event_hub;
			port 						= config.port;
			port_membership 			= config.port_membership;
			port_rest 					= config.port_rest;
			port_event_hub				= config.port_event_hub;
			path_javask_db 				= config.path_hl_java_sdk;
			path_chaincode_id           = config.path_chaincode_id;
		}
	}
	enum CONFIGS{
		DEFAULTCONFIG(
				false,
				"127.0.0.1", 
				7051, 
				"127.0.0.1", 
				7054, 
				"127.0.0.1", 
				7050,
				"127.0.0.1", 
				7053, 
				System.getProperty("user.home")+"/test.properties",     
                                System.getProperty("user.home")+"/config.properties"
				);


		
		CONFIGS(){
			
		}
		

		private CONFIGS(boolean isDevMode, String host, int port, String host_membership, int port_membership,
				String host_rest, int port_rest, String host_event_hub, int port_event_hub,
				String path_hl_java_sdk,String path_chaincode_id) {
			this.isDevMode = isDevMode;
			this.host = host;
			this.port = port;
			this.host_membership = host_membership;
			this.port_membership = port_membership;
			this.host_rest = host_rest;
			this.port_rest = port_rest;
			this.host_event_hub = host_event_hub;
			this.port_event_hub = port_event_hub;
			this.path_hl_java_sdk = path_hl_java_sdk;
			this.path_chaincode_id = path_chaincode_id;
		}


		public boolean isDevMode;
		public String host = "";
		public int port = -1;
		public String host_membership = "";
		public int port_membership = -1;
		public String host_rest = "";
		public int port_rest = -1;
		public String host_event_hub = "";
		public int port_event_hub = -1;
		public String path_hl_java_sdk;
		public String path_chaincode_id;
	}
}
