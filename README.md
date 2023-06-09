<h1>LinkedIn Job Search Automation</h1>

This project demonstrates an automation script written in Java for performing job searches on LinkedIn using Selenium WebDriver. The script interacts with the LinkedIn job search page, enters a job title, selects the "Easy Apply" option, and applies for multiple job listings.


<h2>Prerequisites</h2>

Before running the script, make sure you have the following installed:

    Java Development Kit (JDK)
    Selenium WebDriver for Java
    ChromeDriver

<h3>Setup</h3>

    Download and install the Java Development Kit (JDK) on your machine.
    Set up your project and import the Selenium WebDriver for Java library.
    Download the ChromeDriver executable and specify its path in the code.

<h3>Usage</h3>

    Open the LinkedInJobSearch Java class.
    Update the ChromeDriver path in the line System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); with the actual path to your ChromeDriver executable.
    Customize the jobTitle variable with the desired job title.
    Run the main method to start the script.

The script will launch a Chrome browser, navigate to the LinkedIn job search page, enter the specified job title, select the "Easy Apply" option, and apply for multiple job listings. It will automatically fill in form inputs and select options as needed.
Note

    Ensure that you have a valid LinkedIn account and are logged in before running the script.
    Adjust the sleep durations as needed to allow sufficient time for page loading and element interactions.

That's it! You can now use this automation script to simplify your LinkedIn job search process. Happy job hunting!
