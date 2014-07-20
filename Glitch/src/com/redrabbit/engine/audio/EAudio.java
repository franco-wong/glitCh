package com.redrabbit.engine.audio;

import org.lwjgl.openal.AL;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;

import com.redrabbit.helpers.AudioHelper;

public class EAudio {
	
	private Audio currentAudioBuffer;
	private Music musicBuffer;
	private String name;
	
	public EAudio(Audio sound, String name)
	{
		currentAudioBuffer = sound;
		this.name = name;
	}
	
	public EAudio(String filePath)
	{
		try {
			musicBuffer = AudioHelper.createMusic(filePath);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EAudio(String name, String audioPath, String fileType, boolean isStream)
	{
		this.name = name;
		
		try {
			currentAudioBuffer = AudioHelper.createOpenALAudio(fileType, audioPath, isStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}
	
	public String getAudioID()
	{
		return name;
	}
	
	public Music getMusic() 
	{
		return this.musicBuffer;
	}
	
	public Audio getAudio()
	{
		return currentAudioBuffer;
	}
}
