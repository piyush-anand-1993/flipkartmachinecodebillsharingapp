   Bill Sharing Application

Problem Definition: 
To create a bill sharing application(like splitwise)

The application features are as follows:
The application must have a concept of a group - which is basically a collection of registered users.
A registered user can belong to multiple groups.
A person should be able to add a bill to the application. The bill will contain 
Total Amount of the bill.
People involved and their share of contribution
Group to which that bill get added



The application should keep track of all such bills. Also, the application should be able to display two things: 
Group wise balances to a user.
Total Balance to a user.

To summarise, we expect the following features
Ability to register a bill against a group with a list of participating users.
Users must be able to record contributions to these bills by way of specifying exact amount they owe or by %age of share of the total
A user must be able to view group wise balances

For example : Mudit registers a bill for lunch totalling 300 rupees. The bill is to be split equally among Mudit, Sourav and Souvik. Mudit has paid 250 while Souvik shelled out 50 rupees to complete the bill.
Thus, Mudit should get back 150 rupees while Sourav and Souvik need to give back 100 and 50 rupees respectively in order to balance out the bill.

Requirement:
Should support this using In-Memory DS constructs, use of DB not allowed.

Expectations:
Functionally correct code (whatever feature is completed) 
Create the sample data yourself. You can put it into a file, test case or main driver program itself. Unit test cases are not expected.  
Code should be demo-able. 
Code should be modular. Code should have basic OO design. Please do not jam the responsibilities of one class into another. 
Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re-writing the entire codebase. 
Code should handle edge cases properly and fail gracefully.
Code should be legible and readable. 
CLI, Web based application, REST API and UI are not expected. 

Bonus:
Support individual (person to person) balances.

Guidelines:
Please discuss the solution with an interviewer
Please do not access internet for anything EXCEPT syntax
You are free to use the language of your choice
All work is should be your own
Please focus on the Bonus Feature only after ensuring the required features are complete and demoable.

Evaluation guidelines:
Ability to create a bill with multiple people with different contributions
Group wise balances
Code extensibility - how easily can a new way of sharing (like by share ratios) can be supported
Validations - is the bill totaling to the share amount, are all the members part of the same group etc

Sample Data:
Person :
[
{
id: person1@xyz.com,
name: person1
},
{
id: person2@xyz.com,
name: person2
},
{
id: person3@xyz.com,
name: person3
}
]

Group:
[
	{
		id: group1,
		name: Group 1,
		members: [person1@xyz.com, person2@xyz.com] 
},
{
		id: group2,
		name: Group 2,
		members: [person2@xyz.com, person3@xyz.com] 
}
]

Bill: 
{
	desc: Bill 1,
	totalAmount: 300,
	groupId: group1,
	contribution: [{person: person1@xyz.com, share: 100},{person: person2@xyz.com, share: 200}],
	paidBy: [{person: person1@xyz.com, share: 300}]
}

{
	desc: Bill 2,
	totalAmount: 500,
	groupId: group1,
	contribution: [{person: person1@xyz.com, share: 250},{person: person2@xyz.com, share: 250}],
	paidBy: [{person: person2@xyz.com, share: 500}]
}
{
	desc: Bill 3,
	totalAmount: 100,
	groupId: group2,
	contribution: [{person: person2@xyz.com, share: 10},{person: person3@xyz.com, share: 90}],
	paidBy: [{person: person3@xyz.com, share: 100}]
}
{
	desc: Bill 4,
	totalAmount: 300,
	groupId: group2,
	contribution: [{person: person2@xyz.com, share: 150},{person: person3@xyz.com, share: 150}],
	paidBy: [{person: person3@xyz.com, share: 100},{person: person2@xyz.com, share: 200}]
}

Final Balance should look like this: 
person 1 in group 1: -50
person 2 in group 1: 50
person 2 in group 2: 40
person 3 in group 3: -40

Overall for person 1: -50
Overall for person 2: 90
Overall for person 3: -40 

