package com.app.util;

/**
 * 
 * @author Marcos
 *
 * clase encargada de contener todos los comandos 
 * que se utilizaran para obtener la informaciond del sistema
 * 
 * asi mismo , contiene los eventos por el cual el socket se 
 * comunicara con el servidor express (nodejs)
 *
 */

public class StringConstant {
	
	//Command for CPU
	public static final String CPU_FEATURES_COMMAND = "wmic cpu get addressWidth,caption,currentVoltage,CurrentClockSpeed,"
			+ "loadpercentage,L2CacheSize,manufacturer,MaxClockSpeed,name,"
			+ "processorId,socketDesignation,version /value";
	
	//Command for MEMORY
	public static final String MEMORY_FEATURES_COMMAND = "wmic os get FreePhysicalMemory,FreeSpaceInPagingFiles,FreeVirtualMemory,"
			+ "MaxProcessMemorySize,MaxNumberOfProcesses,NumberOfProcesses,SizeStoredInPagingFiles,TotalVirtualMemorySize,TotalVisibleMemorySize /value";
	
	//Command for GENERAL
	public static final String SYSTEM_GRAL_COMMAND = "wmic os get csdversion,csname,InstallDate,localDateTime,name,NumberOfLicensedUsers,RegisteredUser,serialNumber,version,windowsDirectory /value";
	
	public static final String EMPTY = "";
		
	//Events
	public static final String CPU_EVENT_STC = "CPU_STATIC_DATA";
	public static final String CPU_EVENT_DYM = "CPU_DYNAMIC_DATA";
	public static final String MEMORY_EVENT = "MEMORY";
	public static final String GENERAL_EVENT = "GENERAL";
	
}
