/*
 * generated by Xtext
 */
package com.rockwellcollins.atc.resolute;

import org.eclipse.xtext.generator.IGenerator;

import com.rockwellcollins.atc.resolute.generator.NullGenerator;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class ResoluteRuntimeModule extends AbstractResoluteRuntimeModule {
    public Class<? extends IGenerator> bindIGenerator() {
        return NullGenerator.class;
    }
}
