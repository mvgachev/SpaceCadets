# Challenge1
Reading and Writing Strings from Files and URLs
Have a look at the Web page at https://www.ecs.soton.ac.uk/people/dem. This is a departmental information page which gives all sorts of information about a student or member of staff. The Web address is constructed from a departmental email id (in this case dem). If I have someone else's email id, I can look up their name from one of these Web pages. Try it with your own email id. In fact, in the past the name started at the 12th character of the 6th line of the HTML data returned by the Web server. It finishes when a '<' character appears. (Choose 'View Source' from your Web browser to check where it is now.)

Write a program which converts an email id into a name by

Constructing a BufferedReader object so that can read an email id from System.in (you will need some intermediate objects to help you here. Look it up!)
Constructing the full Web page address by string concatenation
Constructing a URL object from the Web address
Constructing a BufferedReader object that can read from the URL (you will need some intermediate objects to help you here. Look in the book!)
Ignoring the first lines of input from the Web page and saving the one which contains the name (Hint: <... property="name">)
Use the indexOf() and substring() methods to find and extract the name from the line
Print out the result
This sounds quite complex, but it is just a longer variation on the things you will already have seen in the book and in your labs. It's actually quite simple, but as in all programming, the devil is in the details!
