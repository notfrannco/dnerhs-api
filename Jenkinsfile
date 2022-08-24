pipeline {
 agent any
 stages {
   stage ("Compilar el proyecto devops") {
	   when {
                branch 'devops'
            }
            steps {
             sh """
		sudo podman login registrynexusup.lab.data.com.py -u admin -p password
              """

             sh """
                sudo podman login registrynexus.lab.data.com.py -u admin -p password
               """

              sh """
	       sudo podman build -t registrynexusup.lab.data.com.py/dnerhs-api . 
	      """
              sh """
               sudo podman push registrynexusup.lab.data.com.py/dnerhs-api
              """
           }
   }
   stage ("Compilar el proyecto master") {
	   when {
                branch 'normalizacion'
            }
            steps {
             sh """
		sudo podman login registrynexusup.lab.data.com.py -u admin -p password
              """

             sh """
                sudo podman login registrynexus.lab.data.com.py -u admin -p password
               """

              sh """
	       sudo podman build -t registrynexusup.lab.data.com.py/dnerhs-api:prd . 
	      """
              sh """
               sudo podman push registrynexusup.lab.data.com.py/dnerhs-api:prd
              """
           }
   }
   stage ("Compilar el proyecto master") {
	   when {
                branch 'develop'
            }
            steps {
             sh """
		sudo podman login registrynexusup.lab.data.com.py -u admin -p password
              """

             sh """
                sudo podman login registrynexus.lab.data.com.py -u admin -p password
               """

              sh """
	       sudo podman build -t registrynexusup.lab.data.com.py/dnerhs-api:prd . 
	      """
              sh """
               sudo podman push registrynexusup.lab.data.com.py/dnerhs-api:prd
              """
           }
   }
 }
}
