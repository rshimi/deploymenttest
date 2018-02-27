# Deploy springboot application to Elastic BeanStalk

This is a quick guide to deploy to an Elastic BeanStalk instance on Amazon Web Service.

`````` Warning
The details for the deployment pipeline have not been finalised at the time of writing this 
README file. So this may be out of date by the time you are reading.
``````

## Installing the Elastic BeanStalk Command Line
This tool is an alternative method to create and manage Elastic BeanStalk Environments.

##### Prerequisites

 1. Python 2.7 
 2. pip
 
 Using pip:
``````
$ pip install awsebcli  
``````
On MacOS:
```
brew install awsebcli 
```

## Setting up the Springboot project

Once in the springboot project folder execute the following command: 
```
$ eb init
```
This will create a /.elasticbeanstalk folder which will contain a config.yml.

This will be used by elastic beanstalk to determine the configurations when the container will be built.
Below is an example of a config.yml generated. 

```yaml
branch-defaults:
  master:
    environment: HelloWorldDockerAWS-dev
    group_suffix: null
global:
  application_name: HelloWorldDockerAWS
  default_ec2_keyname: aws-eb
  default_platform: Java 8
  default_region: us-west-2
  profile: null
  repository: null
  sc: git
  workspace_type: Application
```

Before anymore steps are executed more options need to be added to the above yml.
As gradle is being used to build the project we will need to tell Elastic BeanStalk about 
an artifact by adding the following: 

```yaml
deploy:
  artifact: build/libs/hello-world-aws-0.1.0.jar
```

Once this is done use the following command to create the Elastic Beanstalk instance. 

```
$ eb create 
```

As this project is a demonstration, accept the default values. Not only will this create the Elastic Beanstalk instance 
but it will also create the security group and the CloudWatch instances. 

## Test the build on the deployed instance
The url can be obtained by going to the the elastic beanstalk page and then clicking into the instance that was just 
created. It will be shown at the top of the page next to the application name. 

A simpler way is to use the command: 
```
$ eb open
```
Which will open a new browser tab.

Currently,it will return an error as the only endpoint is /hello-world so add it to the url.

#### If you sill get an error:
In the root folder of the project create an application.yml with the following: 
```yaml
server:
  port : 5000
```
This is because by default springboot listens on port 8080 and nginx is forwarding to port 5000.

Build the project again with:
```
$ gradle build
```

Then to deploy any changes made, run: 

```
$ eb deploy
```

and visit the URL mentioned previously. and you should see:
```json
{
  "message": "HELLO WORLD"
}

```
### Still to do:
These commands need to be executed from jenkins which is to be the next step.  