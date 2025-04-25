$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/functionalTests/APITest.feature");
formatter.feature({
  "name": "Get Dog Details",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Retrieve list of breed dogs",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "produce a list of all dog breeds",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.produce_a_list_of_all_dog_breeds()"
});
formatter.result({
  "error_message": "java.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to class java.util.List (java.util.LinkedHashMap and java.util.List are in module java.base of loader \u0027bootstrap\u0027)\n\tat stepDefinitions.TestSteps.produce_a_list_of_all_dog_breeds(TestSteps.java:31)\n\tat ✽.produce a list of all dog breeds(file:///Users/ilabadmin/IdeaProjects/ILab_Absa_Assessement/API/src/test/resources/functionalTests/APITest.feature:3)\n",
  "status": "failed"
});
formatter.step({
  "name": "verify \"retriever\" breed is within the list",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.verify_breed_is_within_the_list(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "request to produce a list of sub-breeds for \"retriever\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.request_to_produce_a_list_of_sub_breeds_for(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "produce a random image or link for the sub-breed \"golden\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.produce_a_random_image_or_link_for_the_sub_breed(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
});