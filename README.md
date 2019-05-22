# java-review3-groupProject

## Group Project
Build a messenging mail system for the CodeCrew network. This is NOT email. It's a one message communication system. You should be able to create a user/password, sign in, read, or sent a message to other users.

You can see the hierarchy below:

```
Hierarchy
    A) Welcome to Code School Mail.
    B) Create a new User
        I. Enter your name
        II. Enter your password
    C) Sign in
        I. Welcome [NAME]. What would you like to do?
        II. Check CCMail
            (1) List all CCMail. Include To, From, and Subject up to 12 chars
                i. Choose a CCMail for more details
                    A) Press enter to go back to CCMail
                    B) <strong>Challenge:</strong> Type 'delete' to delete the message.
        III. Write a new CCMail
            (1) Pick user out of existing users
            (2) Subject
            (3) Body
        IV. Log Out
            (1) Go back to beginning of program
```

You can use the following tables:
```
1. usertable
    1. UserID
    2. UserName
    3. Password
2. ccmail
    1. MailID
    2. Subject
    3. Body
    4. isImportant
    5. fromUserID
    6. sentUserID
    7. dateTimeSent
```

FYI: There is only one message/mail created. Once the reciever deletes it, it's gone.

Notes:
- The table name user is already in use by something else.
- You should create a function that checks for userInput validation to easily handle it for all menus.
- Use the Auto Inc feature when creating a primary key to automatically populate your IDs.
- You can make an ArrayList of ArrayLists like this: ArrayList<ArrayList<String>> test = new ArrayList<ArrayList<String>>();
- Timestamp is the data type for time and date in PostGres.

### Challenge
- Allow replies by tracking the previousMailID
- Allow mail importance by sorting by isImportant, then date
