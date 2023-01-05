Java project using Selenium to test the webpage 'https://www.saucedemo.com/'.

This webpage has 4 different users:
- standard_user can browse the webpage without any problems, and can select items an do a checkout for them.
- locked_out_user can't log in, so this user will fail the login test.
- problem_user can log in, but will experience problems with the webpage and won't be able to select certain items from the inventory and won't be able to do a complete checkout of the items, so most of the tests will fail for this user except for the log in one.
- performance_glitch_user can do the same things the standard_user can, but will experience some glitches that slow down browsing the webpage, so all the tests involving 
- this user should take longer than the same test using the standard_user credentials.

You can find the list of web elements sorted by page in src/main/java/pages and the tests in src/test/java. To run the tests you only need to run the class, so all the tests will execute one by one. The web driver used is ChromeDriver, so you need it to perform the tests.

I've only coded a few tests to show the basic functionalities of the page, but much more tests can be created based on certain requirements, like response time (performance_glitch_user could fail these tests) and many more.
