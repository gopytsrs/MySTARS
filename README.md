# MySTARS-CZ2002

## Links
- <a href="https://en.wikipedia.org/wiki/Entity-control-boundary">Entity-Control-Boundary Pattern</a>
- <a href="https://www.freecodecamp.org/news/learn-the-basics-of-git-in-under-10-minutes-da548267cc91/">Git and Github setup</a>

<br></br>

![](https://i.ibb.co/ygWZc8q/Screenshot-2020-11-03-143649.jpg)

<br></br>

### Workflow
1. Firstly, pull the updates in main to your local repo

    ```bash
    $ git pull
    ```

2. Checkout a new branch to work on your code
    ```bash
    $ git checkout -b branch-name
    ```
3. You should be in the branch you created now, to check type this command
    ```bash
    $ git branch
      main
    * branch-name
    ```
   The * tells you which branch you are in
   
4. Make the desired changes in the current branch, add and commit.
    ```bash
    $ git add .
    ```
    The "." means to add all the files modified.
    You can add individual files by specifying their name.
    
    ```bash
    $ git commit -m "Your commit message here"
    ```
   
5. Push your commits to a remote branch with the same name
    ```bash
    $ git push -u origin branch-name
    ```
6. Return to the Github repo on your browser, this should appear, click on the button

    ![](https://i.ibb.co/fMjdcp8/Screenshot-2020-11-03-231544.jpg)
    ****
    
7. Create the pull request.
    
    ![](https://i.ibb.co/3hcc6Dw/Screenshot-2020-11-03-231612.jpg)
    ****
    
8. Let your team check the code before they merge the pull request