package StepDefs;


import Pages.logic.SearchForItem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchForItemStepDef {
    SearchForItem searchForItem = new SearchForItem();



    @Given("Open Google and perform a search for {string}.")
    public void openGoogleAndPerformASearchFor(String searchItem) {
        searchForItem.Searching(searchItem);

    }

    @And("Get all search results displayed the number of the Ad links is greater than {int}")
    public void getAllSearchResultsDisplayedTheNumberOfTheAdLinksIsGreaterThan(int number) {
        searchForItem.validateNumberOfAdLinks(number);
    }

    @Then("Navigate to each Ad link and confirm the title is displayed.")
    public void navigateToEachAdLinkAndConfirmTheTitleIsDisplayed() {
        searchForItem.confirmTitleIsDisplayedInAdLinks();
    }
}
