ASD_FrameworkProject
====================
This is a project to design a framework for Bank and Credit Card Application.
We refactor existing code from Bank and Credit Card application and implement some design patterns 
to make the design more open to extension and close for modification.

Group Members:
1. Hardi Chandra 
2. Rhena Lelleen Plagata
3. Juvelyn Hiolen

Patterns Used :
1. We used MVC pattern to implement this project. The view aspect uses template method pattern to yank the common codes 
and put it in a parent class in the framework like FincoView and have the applications implement the concrete 
specializations like BankView and CardView.

2. For the Controller aspect, we used the Command and Functor patterns to be able to execute the different commands like 
add account, deposit and withdraw.

3. For the Model aspect, we use Factory Method to create different kinds of account, Party and Account pattern to model
the Customer and Account objects.

II. A description of the plug points of the framework
• GUI- base frame, which has common, fields applicable for financial company. This base frame has an Add Account button, 
Withdraw button, Deposit button, Exit button and default table with its respective actions. The client can reuse Add 
Account button and reset the title to its own custom title and just override the getDialog() method to create its own
custom add account dialog box. No need to add an Actionlistener because the framework has already implemented it.

• AAddAccDialog – base frame, which contains fields for adding a default account for a financial company. The client can
extend from this and add its own fields. This can be instantiated in getDialog() box to be used in the Add Account button 
action performed

• IOperation- base operation with compute() method. This can be called dynamically from the ComputeTransaction. If the 
client has concrete specialization on their operations, they need to implement the compute() method. The framework 
currently has AddOperation and SubtractOperation which just simply adds or subtracts amount being entered from client 
to the account’s balance.

• IAccount- base account

• ITransaction – command abstraction.  

• IAccountFactory – base factory. Client can extend from this base class to be able to create its concrete 
specialization of IAccount.
