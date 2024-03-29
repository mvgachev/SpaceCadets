# Challenge2
Bare Bones
Bare Bones is the simple language that Brookshear uses in his book, 'Computer Science: an Overview', to illustrate the power of Turing complete machines and investigate the halting problem.

Bare Bones has three simple commands for manipulating a variable:

clear name;
incr name;
decr name;
...which respectively sets variable name to zero, increments it by one and decrements it by one.

The language also contains one control sequence, a simple loop:

while name not 0 do;
...
...
end;
... where name is a variable. Note that variables need not be declared before they are used and must be non-negative integers. Statements are delimited by the ; character.

Note that while loops must be terminated by an end statement, but that they can be nested.

[edit]The Challenge
This weeks challenge is to implement a Bare Bones interpreter. The program should take a text file containing a bare bones program as input and execute each statement in turn. After each statement has been executed it should output the state of all the variables in the system to form a record of execution.

You will almost certainly want to look at the String.split() as a starting point or possibly the java.util.regex package. Think carefully about the internal structure of your interpreter, try and come up with a decent object oriented design. Also beware of the nested while loop!

Test your interpreter with the following simple counting program :

clear X;
incr X;
incr X;
incr X;
while X not 0 do;
   decr X;
end;
and this more complex example for multiplying two numbers together, X x Y (taken from Brookshear):

clear X;
incr X;
incr X;
clear Y;
incr Y;
incr Y;
incr Y;
clear Z;
while X not 0 do;
   clear W;
   while Y not 0 do;
      incr Z;
      incr W;
      decr Y;
   end;
   while W not 0 do;
      incr Y;
      decr W;
   end;
   decr X;
end;
The behaviour of the Bare Bones interpreter is woefully underspecified :-( Make sure that when you post your code to the Wiki you list any special assumptions or behaviour.
