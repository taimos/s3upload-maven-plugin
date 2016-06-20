# S3 Upload Plugin for Maven

[![Build Status](https://travis-ci.org/taimos/s3upload-maven-plugin.png?branch=master)](https://travis-ci.org/taimos/s3upload-maven-plugin)

Uploads the given artifact to an S3 bucket using the default credentials chain

```
<plugins>
	<plugin>
		<groupId>de.taimos</groupId>
		<artifactId>s3upload-maven-plugin</artifactId>
		<version>1.0</version>
		<configuration>
            <artifact>the artifact to upload</artifact>
			<bucket>the target bucket</bucket>
			<targetName>the target file name</targetName>
			<region>bucket-region</region>
		</configuration>
		<executions>
            <execution>
                <goals>
                    <goal>upload</goal>
                </goals>
            </execution>
        </executions>
	</plugin>
</plugins>
```

``artifact`` defaults to ``${project.build.directory}/${project.build.finalName}.${project.packaging}``

``targetName`` defaults to ``${project.build.finalName}.${project.packaging}`` 

``bucket`` the name of the S3 bucket

``region`` optionally the region of the bucket to prevent signature warnings