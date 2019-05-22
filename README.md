# java-review3-groupProject



Email System

Hierarchy
    A) Welcome to Code School Mail.
        1. Create a new User
            I. Enter your name
            II. Enter your password
        2. Sign in
            I. Welcome [NAME]. What would you like to do?
                A) Check CCMail
                    (1) List all CCMail Subjects up to 12 chars
                        i. Click on CCMail
                            A) See Subject and Body
                            B) Reply
                            C) Delete
                B) Write a new CCMail
                    (1) Subject
                    (2) Body
                    (3) Important (Optional)
                C) See all CCMail Sent Subjects up to 12 chars
                    (1) Click on CCMail to read body
                D) Options
                    (1) Change email address
                    (2) Change password


Topics

    A) User Authentication
    B) Objects/Classes

Tables
    1. Users
        1. UserID
        2. UserName
        3. Password
    2. CCMail
        1. MailID
        2. Subject
        3. Body
        4. isImportant
        5. fromUserID
        6. sentUserID
        7. dateTimeSent
        8. previousMailID



Notes:
- The table name user is already in use by something else.
- You should create a function that checks for userInput validation to easily handle it for all menus.
- Use the Auto Inc feature when creating a primary key to automatically populate your IDs.
- You can make an ArrayList of ArrayLists like this: ArrayList<ArrayList<String>> test = new ArrayList<ArrayList<String>>();

Challenges
- Allow replies by tracking the previousMailID
- Allow mail importance by sorting by isImportant, then date
