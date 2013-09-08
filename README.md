# _FacebookSDK_

_Description: Java wrapper for Facebook's REST GRAPH API_

1. _you will need to have an active facebook app (appId,appSecret)_

for more information check out :
https://developers.facebook.com/docs/reference/api/

## Project Setup

_build the project with maven_ 

(mvn clean install)

1. _to run the test - TestFacebook- class, fill in the facebookSDK.properties (in the 'src/test/resources' directory) with the missing parameters_
2. _for the common use cases, check out the TestFacebook class_

## Testing

_run mvn test on the project, don't forget to fill in the facebookSDK.properties_


## Deploying

### _just add the project as a maven dependency after you've built the jar file._

i.e: add the following to your project's (the one that uses the facebookSDK) pom.xml:

		<dependency>
			<groupId>me.fishbowl</groupId>
			<artifactId>facebookSDK</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>

## Usage:
once a user logs into your app, you'll have the user's facebookID, AccessToken, Token-expiresIn and signedRequest
with which you can initialize the FacebookSDKUSERAPI object:

i.e:

FacebookSDKUSERAPI facebookSDK = Facebook.getFacebookSDKUSER(facebookId, requestdata.getAccessToken(), requestdata.getExpiresIn(), requestdata.getSignedRequest());

and then use it like so:

FacebookUserData details = facebookSDK.getUserPublicDetails(facebookId);

## Contributing changes

- _"Please open github issues"_

## License

GNU GENERAL PUBLIC LICENSE