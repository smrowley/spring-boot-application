Feature: Scenarios defining sample integration tests

Scenario: Sample Integration test
Given an email address of 'john@sample.org'
When the person lookup endpoint is called
Then the found person should be:
  | First Name | Last Name | Email           |
  | John       | Connor    | john@sample.org |