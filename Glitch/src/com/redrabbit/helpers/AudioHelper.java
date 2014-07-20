package com.redrabbit.helpers;

import java.io.IOException;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.redrabbit.exceptions.badAudioFormatException;
import com.redrabbit.exceptions.badMethodArgException;
import com.redrabbit.logging.LoggerConfig;

public class AudioHelper {

	public static Audio createOpenALAudio(String fileType, String audioPath, boolean isStream) throws IOException, badAudioFormatException, badMethodArgException  {
		Audio audioBuffer = null;
		
		fileType = fileType.toUpperCase();
		// select the right function for whatever format the user has picked.
		try {
			switch (fileType) {
			    case "OGG":
			    	
			    	if(!isStream) {
				    // you can play oggs by loading the complete thing into 
				    // a sound
				    audioBuffer = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(audioPath));
			    	} else {
			    		
			    		// or setting up a stream to read from. Note that the argument becomes
			    		// a URL here so it can be reopened when the stream is complete. Probably
					    // should have reset the stream by thats not how the original stuff worked
					    audioBuffer = AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource(audioPath));
			    	}
			    break;
			    
			    case "MOD":
			    	
			    	if(!isStream) {
			    		// can load mods (XM, MOD) using ibxm which is then played through OpenAL. MODs
					    // are always streamed based on the way IBXM works
					    audioBuffer = AudioLoader.getStreamingAudio("MOD", ResourceLoader.getResource(audioPath));
				 	
			    	} else {
			    		throw new badMethodArgException("MOD files can be only streamed");
			    	}
			
				break;
				    // playing as music uses that reserved source to play the sound. The first
				    // two arguments are pitch and gain, the boolean is whether to loop the content
				    // modStream.playAsMusic(1.0f, 1.0f, true);
			    case "AIF": 
			    	
			    	if(!isStream)
			    	{
			    		// you can play aifs by loading the complete thing into 
					    // a sound
			    		audioBuffer = AudioLoader.getAudio("AIF", ResourceLoader.getResourceAsStream(audioPath));   		
			    	} else {
			    		audioBuffer = AudioLoader.getStreamingAudio("AIF", ResourceLoader.getResource(audioPath));			    		
			    	}
			  
			    break;
			    case "WAV":
			    	if(!isStream) {
			    	
			    		// you can play wavs by loading the complete thing into 
					    // a sound
					    audioBuffer = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(audioPath));
				    	
			    	}
			    	else
			    	{
			    		audioBuffer = AudioLoader.getStreamingAudio("WAV", ResourceLoader.getResource(audioPath));
			    	}
			    break;
			   
			    default:
			    	throw new badAudioFormatException(fileType);
			}

		} catch (IOException e) {
			if(LoggerConfig.ON) {
				// code for logging
			}
			
			throw new IOException("We could not load " + audioPath);
		}
	
		if (audioBuffer == null)
		{
			System.out.println("errrrrrrrrrrrrrrrrrror in music lib");
		}
		else 
		{
			System.out.println("uyyt");
		}
		return audioBuffer;
		
	}
	
	public static  Music createMusic(String filePath) throws SlickException 
	{
		return new Music(filePath);
	}
}
