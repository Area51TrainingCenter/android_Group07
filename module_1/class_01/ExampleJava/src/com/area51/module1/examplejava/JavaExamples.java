package com.area51.module1.examplejava;

import android.util.Log;

public class JavaExamples {

	
	public void controlFlowIFELSE()
	{
		int nota =12;
		String status ="Desaprobado";
		
		if(nota < 13)
		{
			status ="Desaprobado";
		}else if(nota>= 13 && nota <17)
		{
			status ="Aprobado y buena nota";
		}else
		{
			status ="Aprobado y excelente nota";	
		}
		
		Log.v("CONSOLE", status);
		
	}
	public void controlFlowSWITCH()
	{
		int dia=2;
		char cdia='D';
		
		switch (dia) {
			case 0:
					cdia='D';
				break;
			case 1:
				cdia='L';
				break;
			case 2:
				cdia='M';
				break;
			case 3:
				cdia='I';
				break;
			case 4:
				cdia='J';
				break;
			case 5:
				cdia='V';
				break;
			case 6:
				cdia='S';
				break;
				
			default:
				break;
		}
		
		Log.v("CONSOLE", "cdia :"+cdia);
		
	}
}
