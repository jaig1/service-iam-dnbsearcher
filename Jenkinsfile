#!groovy
@Library('jenkins-shared-library')
/**
* Make sure that following environment variables are set in job configuration before using this Jenkinsfile for your builds.
* Jenkinsfile_Version=1.0
*
* DEDICATED_SLAVE=<JENKINS DEDICATED SLAVE>
* PUBLIC_SLAVE=<JENKINS PUBLIC SLAVE>
* ARTIFACTORY_URL=<ARTIFACTORY_URL URL>
* CHECKMARX_SERVER_URL=<CHECKMARX_SERVER_URL>
* CHECKMARX_PROJECT_NAME=<CHECKMARX_PROJECT_NAME>
* CHECKMARX_REPORT_PATH-=<CHECKMARX_REPORT_PATH>
* CHECKMARX_PRESET=<CHECKMARX_PRESET>
* CHECKMARX_LOCATION_PATH_EXCLUDE=<CHECKMARX_LOCATION_PATH_EXCLUDE>
* CHECKMARX_LOCATION_FILE_EXCLUDE=<CHECKMARX_LOCATION_FILE_EXCLUDE>
* RELEASE_REPO=<ONEID_ARTIFACTORY_RELEASE_REPO>
* SNAPSHOT_REPO=<ONEID_ARTIFACTORY_SNAPSHOT_REPO>
* SERVICE=<SERVICE_NAME>
* ARTIFACTORY_URL = env.ARTIFACTORY_URL
* OPS_SPARK_ROOM_ID=<OPS TEAM SPARK ROOM ID>
* DEV_SPARK_ROOM_ID=<DEV TEAM SPARK ROOM ID>
*/
import java.io.*
import groovy.xml.*
import groovy.json.JsonOutput
def environment
def jStage

try {

	    node(env.PUBLIC_SLAVE) {   

        deleteDir() // To wipe out Workspace
        stage 'Build Initialize'
              jStage ="Initialize"
              def message=env.SERVICE
              coiNotify.sparkNotification(env.DEV_SPARK_ROOM_ID, jStage, "SUCCESSFUL", message)
        stage 'Checkout'
              jStage = "Checkout"
              coiUtils.checkoutSource(jStage)
       /* stage 'Static Scan'
              jStage = "Static Scan"
             coiUtils.staticScanner(jStage) */
        stage 'Unit Tests'
              jStage="Unit Tests"
              coiBuild.runUnitTests(jStage)
        stage 'Build and Publish To Artifactory'
              jStage = "Build and Publish Artifactory"
              coiBuild.rtMavenDeploy(jStage)
      }

    node(env.DEDICATED_SLAVE) {
        unstash 'workspace'
        stage 'DockerBuild And Publish'
              jStage = "DockerBuild and Publish"
              coiBuild.buildDockerImage(jStage)
		/*stage 'Deploy To CAE POC'
			jStage = "Deploy to POC"
			environment = "poc"
			coiDeploy.runDeploy(["alln","rcdn"] as String[], environment, jStage)*/
		stage 'Deploy To CAE DEV'
			jStage = "Deploy to DEV"
			environment = "dev"
			coiDeploy.runDeploy(["alln","rcdn"] as String[], environment, jStage)
    }
}
catch(Exception e) {
              currentBuild.result = 'FAILURE'
              coiUtils.handleException(jStage, e.toString())
} finally {

        coiNotify.handleFinally()
}
