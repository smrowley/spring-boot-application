Feature: Sample cucumber unit tests

Scenario: Looking up person by email should return a person with the proper name
Given an email address of 'john@sample.org'
When a person is looked up with the email address
Then the person name should be 'John'

Scenario: Looking up person by email should return a person with the proper name
Given an email address of 'ryan@sample.org'
When a person is looked up with the email address
Then the person name should be 'Ryan'