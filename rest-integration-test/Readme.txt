To run:
1. go to java build path and under maven build create new Run configuration.
2. Under it, in Goals add below command:
   "site:run"
3. under base directory: point it to you project.
 ${workspace_loc:/rest-integration-test}
4. Apply and run.
5. Used jetty to run the project and test api's and surefire maven plugin to generate the report.