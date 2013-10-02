cf-suicidal-app
===============

A simple application to allow testing of Cloud Foundry load balancing, and self-healing for failed droplets.

To use, first build the project with Maven, using the "mvn package" command.
Next, edit the manifest.yml to point to a unique host name for the application.
Finally, execute a cf push to push the application to run.pivotal.io.

You can go to the root context for the application once it is deployed to see a little status message about the app, and what ip and port is is running on.

You can then go to the /die context to cause an instance of the application to terminate.  After termination, you can then watch Cloud Foundry restart your application by simply refreshing the page, or by using cf instances, or some other means.
