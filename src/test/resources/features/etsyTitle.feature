Feature: Verify Etsy Title

  User Story: As a user, when i'm on Etsy home page (https://www.etsy.com)
   I will see title is as expected :
  Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone


  Scenario: Etsy home page title verification
    Given User is on Etsy home page
    Then User should see Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone