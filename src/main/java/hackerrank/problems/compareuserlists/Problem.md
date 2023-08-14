# Compare User Lists

The manage users page in a company administrative portal contains a user list. The admin can add new users, update current users, and save all changes by pressing the save button. As a software developer for this company, implement the backend side of the user management page.



Given two user lists, one is the current database and the other a list of possible changes. The first value in a change record is its user ID. If this value is 0, it is a new user to insert into the database. If the value is greater than 0, it is a user ID. Compare all of the user's attributes with what is in the database. If there is any difference, update the record.



The implementation should return two lists. The first is a list of records to update. The second is a list of records to insert. The provided code will print the lengths of these lists.

### Example:

| List 1 (Current Users in DB) | List 2 (Users List from UI) |
| --- | --- |
| 1 User1 | 1 User4 |
| 2 User2 | 0 User5 |
| |	2 User2 |

User ID 1 changes the username from 'User1' to 'User4'.