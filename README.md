# MoneyTransfer Test Automation Project

## Overview
This project is a test automation framework for the MoneyTransfer application. It utilizes **Gauge** for test execution and **Appium** for mobile automation. The project is structured to support UI and functional testing.

## Project Structure
```
MoneyTransfer/
├── env/                     # Environment configuration files
├── logs/                    # Log files
├── reports/                 # Test reports and results
│   ├── css/
│   ├── fonts/
│   ├── images/
│   ├── specs/
│   └── index.html
├── specs/                   # Gauge specifications (test cases)
│   ├── Concepts/            # Reusable Gauge concepts
│   ├── Specifications/      # Gauge specification files
│   └── loginpage.spec       # Example spec file
├── src/
│   ├── test/java/com/web/base/
│   │   ├── driver/          # WebDriver configuration
│   │   ├── PageElements/    # UI element locators
│   │   ├── pages/           # Page Object Model (POM) classes
│   │   ├── pagesteps/       # Step implementations
│   │   ├── utils/           # Utility classes
│   │   └── resources/
│   │       └── allure.properties # Allure reporting configuration
├── target/                  # Compiled files and test output
├── .gitignore               # Git ignore file
├── pom.xml                  # Maven project configuration
└── README.md                # Project documentation
```

## Setup and Installation
### Prerequisites
- **Java 11+**
- **Maven**
- **Gauge**
- **Appium Server** (for mobile tests)
- **Android Emulator** or **real device** (for mobile tests)

### Installation Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/moneytransfer-test.git
   ```
2. Navigate to the project directory:
   ```sh
   cd moneytransfer-test
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```

## Element Strategy
The project follows the **Enum-based element definition** strategy. Elements are stored in the `LoginEnum` class, where each UI element is mapped using **By locators**:
```java
public enum LoginEnum {
    USERNAME_INPUT(By.cssSelector("input[placeholder='Username']")),
    PASSWORD_INPUT(By.cssSelector("input[placeholder='Password']")),
    LOGIN_BUTTON(By.xpath("//div[contains(text(), 'Login')]")),
    INVALID_CREDENTIALS(By.xpath("//div[contains(text(), 'Username or Password Invalid!')]"));
    
    private final By locator;
    
    LoginEnum(By locator) {
        this.locator = locator;
    }
    
    public By getLocator() {
        return locator;
    }
}
```
This ensures **centralized management of UI elements**, improving maintainability and reducing redundancy.

## Driver Factory
The `DriverFactory` class is responsible for **initializing WebDriver instances** based on the specified browser:
```java
public class DriverFactory {
    public static WebDriver getDriver(String browser) {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getDriverPath("geckodriver"));
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", getDriverPath("msedgedriver"));
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
```
### Key Features:
- Supports **Chrome, Firefox, Edge, and Safari**.
- Uses `System.setProperty()` to set driver paths dynamically.
- Throws an exception for unsupported browsers.
- `getDriverPath()` determines the correct driver executable based on OS.

## Running Tests
### Run All Tests
```sh
mvn test
```
### Run Specific Spec File
```sh
gauge run specs/loginpage.spec
```
### Generate Allure Report
```sh
mvn allure:report
```
### View Allure Report
```sh
allure serve target/allure-results
```

## Reporting
- **Allure Reports** are generated in `target/allure-results`.
- The final HTML report can be accessed at `target/allure-report/index.html`.

## Contribution
1. Fork the repository
2. Create a feature branch (`feature-new-test`)
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## License
MIT License

