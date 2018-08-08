Cuke-Up Your Tests
==================

## Download & Install:

- Java IDE: [IntelliJ community edition](https://www.jetbrains.com/idea/download/#section=windows) 
> You can use your own preferred IDE for Java (e.g. Eclipse). However the trainers know the settings and hotkeys for IntelliJ which are written in the [CheatSheet.docx](CheatSheet.docx), so the latter is preferred.
- Chrome Plugin: [CSS Selector Helper for Chrome](https://chrome.google.com/webstore/detail/css-selector-helper-for-c/gddgceinofapfodcekopkjjelkbjodin)
- [Git](https://git-scm.com)
- [Java jdk](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (not the JRE)


## Setup

- Start up IntelliJ
- Choose 'Check out from Version Control' -> Git
- Fill in URL "https://github.com/jgelon/cukeupyourtests.git"
- Press Clone
- When the following pop-up comes up select 'No': 

![versioncontrolcheckoutdone](https://user-images.githubusercontent.com/15871496/39982468-bf4640f6-5754-11e8-9c71-2c9970159400.png)   


- In your IntelliJ main screen choose 'Open' and navigate to the folder to which you cloned the project in step 3.
- If it is your first IntelliJ project then in IntelliJ:
    - Select 'Open' project and browse to the test project folder you just created and open the folder
    - Open project structure (CTRL + Shift + Alt + S), navigate to the 'Project' tab, choose new in Project SDK section, select JDK and direct to your java/jdk folder
    - Open Settings (CTRL + ALT + S), navigate to 'Plugins' and install the plugins: `Gherkin` and `Cucumber for Java` (**Don't** install the `Substeps` plugin)
	- Open the Maven Projects Tool window (Navigation bar > `View` > `Tool Windows` > `Maven Projects`), this will open a view on the right side of the screen.
	- Double click under `cukeupyourtests` > `Lifecycle` the `compile` option. This will install the drivers of Chrome, Firefox and InternetExplorer. _If the drivers don't download you might be behind a proxy, visit [the plugin page](https://github.com/webdriverextensions/webdriverextensions-maven-plugin#using-a-proxy) for help_.

  

## Assignments
The assignments can be found in the file [Assignments.md](Assignments.md)

## Disclaimer
This is a workshop architecture and is only for that goal intended. Using this framework on a larger scale is not recommended.
