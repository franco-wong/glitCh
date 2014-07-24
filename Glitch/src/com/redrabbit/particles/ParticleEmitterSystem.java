package com.redrabbit.particles;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.util.Log;

import com.redrabbit.helpers.ParticleHelper;
import com.redrabbit.logging.LoggerConfig;

/**
 * A class to handle creation of a particle emitter system.
 * 
 * @author rabbitfighter
 *
 */
public class ParticleEmitterSystem {

    // Class name for logging.
    protected final String TAG = "ParticleEmitterSystem";

    // The Particle system stuff
    private ParticleSystem particleSystem;
    private ParticleIO particleIO;
    private ConfigurableEmitter configurableEmitter;
    private File xmlFile;
    private int numParticles;

    /**
     * @param vector
     *            The vector passed in.
     * @param imageName
     *            The image name.
     * @param xmlFileName
     *            The xml file to work with.
     * @param numParticles
     *            the number of particles to limit the emitter to.
     */
    public ParticleEmitterSystem(Vector2f vector, String imageName,
	    String xmlFileName, int numParticles) {

	// TODO - Figure this out???
	this.setParticleIO(new ParticleIO());

	// Set the number of particles.
	this.setNumParticles(numParticles);

	// Create the new Particle Emitter System.
	this.setParticleSystem(new ParticleSystem(ParticleHelper
		.setParticleImage(imageName), this.getNumParticles()));

	try {

	    // //Set the configurable emitter.
	    this.setConfigurableEmitter(ParticleIO
		    .loadEmitter(ParticleHelper.PATH_XML + xmlFileName));

	} catch (IOException e) {

	    // If logging, log the events.
	    if (LoggerConfig.PARTICLE_SYSTEM_DEBUG) {
		Log.debug(TAG + "Exception: " + e.getMessage());
		Log.debug(this.getParticleIO().toString());
	    }

	    // Print stack tracte
	    e.printStackTrace();

	    // Exit the system.
	    System.exit(0);

	}// End Try/Catch

	// Add the emitter to the paricle system.
	this.getParticleSystem().addEmitter(this.getConfigurableEmitter());

    }// End contructor

    /***** Getters/Setter *****/

    public File getXmlFile() {
	return xmlFile;
    }

    public void setXmlFile(File xmlFile) {
	this.xmlFile = xmlFile;
    }

    public ConfigurableEmitter getConfigurableEmitter() {
	return configurableEmitter;
    }

    public void setConfigurableEmitter(ConfigurableEmitter e) {
	this.configurableEmitter = e;
    }

    public ParticleIO getParticleIO() {
	return particleIO;
    }

    public void setParticleIO(ParticleIO particleIO) {
	this.particleIO = new ParticleIO();
    }

    public ParticleSystem getParticleSystem() {
	return particleSystem;
    }

    public void setParticleSystem(ParticleSystem particleSystem) {
	this.particleSystem = particleSystem;
    }

    public int getNumParticles() {
	return numParticles;
    }

    public void setNumParticles(int numParticles) {
	this.numParticles = numParticles;
    }

}// EOF
