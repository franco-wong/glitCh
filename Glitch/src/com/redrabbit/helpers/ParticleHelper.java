package com.redrabbit.helpers;

import org.newdawn.slick.Image;

public class ParticleHelper {
    
    public static final String PATH_XML = "res/data/particledata/";
    public static final String TEST_XML = "test_emitter.xml";
    public static final String PARTICLE_LIGHTNING = "particle_lightning.png";
    public static final String PARTICLE_FIRE = "particle_redBall_posterized.png";
    public static final String PARTICLE_QUESTIONMARK = "particle_question_mark.png";


    public static Image setParticleImage(String imageName) {
	return ImageHelper.setParticleImage(imageName);
	
    }

   

}
