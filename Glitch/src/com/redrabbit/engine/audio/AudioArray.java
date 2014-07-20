package com.redrabbit.engine.audio;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

import com.redrabbit.exceptions.badAudioFormatException;
import com.redrabbit.exceptions.badMethodArgException;
import com.redrabbit.helpers.AudioHelper;
import com.redrabbit.logging.LoggerConfig;

public class AudioArray {
	private ArrayList<EAudio> audioCollectionArray;

	public AudioArray() {
		audioCollectionArray = new ArrayList<EAudio>();
	}

	public void addSound(String fileType, 
		                 String audioPath,
		                 String audioName, 
                         boolean isStream) throws badMethodArgException, badAudioFormatException {
		
		Audio audioBuffer = null;
		// this is just a wrapper for OpenAL audio objects.
		EAudio newAudio = null; 
	
		try {
			audioBuffer = AudioHelper.createOpenALAudio(fileType, audioPath, isStream); 	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		newAudio = new EAudio(audioBuffer, audioName);
		audioCollectionArray.add(newAudio);
	}
	
	public EAudio findEAudioByName(String audioName)
	{
		EAudio tempEAudio;
		for(int i = 0; i < audioCollectionArray.size(); i++)
		{
			tempEAudio =  audioCollectionArray.get(i);
			
			if(tempEAudio.getAudioID().equals(audioName))
			{
				return tempEAudio;
			}
		}
		return null;
	}
}
