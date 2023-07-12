# Java Exceptions: Securing Messages
Create an *Encrypter* class to handle input validation and encryption. It should have the method 
`String getEncryptedName(String name)` that performs a simple string manipulation.

The *getEncryptedName* method must perform the following tasks:

* Validate the name by calling the validate(name) method provided in the Validator class
If the name validation returns true:
  * Reverse the entire string and convert upper-case letters to lower-case
  * Return the modified string
* If the name validation returns false:
  * Throw an exception of IllegalArgumentException class with the message 'Try again with valid name' 

The locked stub code in the editor provides the complete implementation of the Validator class and validates the
implementation of the Encrypter class.

### Constraints
* The name contains no more than 100 characters.

### Input Format For Custom Testing
There is a single line that contains the string name.

## Samples
### Case 0
#### Sample Input
```text
STDIN          Function
-----          -----
Kate Winslet → name = 'Kate Winslet'
```

#### Sample Output
`telsniw etak`


#### Explanation
The name validation is successful, so the string is reversed and converted to lower case.


### Case 1
#### Sample Input
```text
STDIN           Function
-----           -----
Kate Wins?let → name = 'Kate Wins?let'
```

#### Sample Output
```text
java.lang.IllegalArgumentException: Try again with valid name
```

#### Explanation
Invalid characters are found in the name, so the required exception is thrown with the message *Try again with valid name*.
