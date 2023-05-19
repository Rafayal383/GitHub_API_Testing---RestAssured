Feature: create repo ,get repo ,list repo  ,list public repo , get all repo topics and replace all repo topics


Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
Given Get Payload from "createRepo.json" for repo
When Create Repo "/user/repos" and provide token
Then Successfully Create with status code 201
And Verify owner Name


Scenario: GET A REPOSITORY
Given Should have repository and owner
When get repository  "/repos/" owner /repo
Then Successfully got repository with status code 200
And Verify repository


Scenario: LIST PUBLIC REPOSITORIES
Given Should have token 
When list the public repository "/repositories"
Then Successfully listed public repository with status code 200
And Verify list public repository


Scenario: LIST REPOSITORY TAGS
Given Should have repository and owner and token
When list repository tags "/repos/" owner /repo "/tags"
Then Successfully listed repository tags with status code 200
And Verify list repository tags


Scenario: GET ALL REPOSITORY TOPICS
Given Should have repository
When get all repository topics "/repos/" owner /repo "/topics"
Then Successfully got all repository with status code 200
And Verify all repository topics


Scenario: REPLACE ALL REPOSITORY TOPICS
Given Get Payload from "githubTopics.json" 
When replace all repository topics "/repos/" owner /repo "/topics"
Then Successfully replaced all repository topics with status code 200
And Verify replaced repository tpoics
 
