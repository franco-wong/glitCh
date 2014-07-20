package com.redrabbit.exceptions;

public class badAudioFormatException extends Exception {
	
	public badAudioFormatException(String fileType)
	{
		super(fileType + " is not a accepted file format for sound");
	}
}
