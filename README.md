# S3 Upload Plugin for Maven

Uploads the given artifact to an S3 bucket using the default credentials 

```
<plugins>
	<plugin>
		<groupId>de.taimos</groupId>
		<artifactId>s3upload-maven-plugin</artifactId>
		<version>0.1-SNAPSHOT</version>
		<configuration>
			<artifact>the artifact to upload</artifact>
			<bucket>the target bucket</bucket>
			<targetName>the target file name</targetName>
		</configuration>
	</plugin>
</plugins>
```

``artifact`` defaults to ``${project.build.directory}/${project.build.finalName}.jar``

``targetName`` defaults to ``${project.build.finalName}.jar`` 