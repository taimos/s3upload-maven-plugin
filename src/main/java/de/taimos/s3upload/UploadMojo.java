package de.taimos.s3upload;

/*
 * #%L
 * Upload artifact to AWS S3
 * %%
 * Copyright (C) 2015 Taimos GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.amazonaws.services.s3.AmazonS3Client;

@Mojo(name = "upload")
public class UploadMojo extends AbstractMojo {
	
	/**
	 * the artifact to uplaod
	 */
	@Parameter(defaultValue = "${project.build.directory}/${project.build.finalName}.jar", property = "artifact", required = true)
	protected String artifact;
	
	/**
	 * the target bucket
	 */
	@Parameter(property = "bucket", required = true)
	protected String bucket;
	
	/**
	 * the target name
	 */
	@Parameter(defaultValue = "${project.build.finalName}.jar", property = "targetName", required = true)
	protected String targetName;
	
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		File artifactFile = new File(this.artifact);
		if (!artifactFile.exists()) {
			throw new MojoExecutionException("artifact does not exist: " + this.artifact);
		}
		
		this.getLog().info("Uploading artifact " + this.artifact + " to AWS S3 s3://" + this.bucket + "/" + this.targetName);
		
		AmazonS3Client s3 = new AmazonS3Client();
		s3.putObject(this.bucket, this.targetName, artifactFile);
		
		this.getLog().info("Upload done");
	}
	
}
