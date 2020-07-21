#Coffee machine
**[ Total Duration for the assignment : 2 Hours 30 mins ]** 

Write the working code to create a working coffee machine. Here are the desired features 
1. It will be serving some beverages. 
2. Each beverage will be made using some ingredients. 
3. Assume time to prepare a beverage is the same for all cases. 
4. The quantity of ingredients used for each beverage can vary. Also the same 
ingredient (ex: water) can be used for multiple beverages. 
5. There would be N ( N is an integer ) outlet from which beverages can be 
served. 
For N = 2 [ 2 outlets in a machine ] 
For N = 3 [ 3 outlets in a machine ] 
6. Maximum N beverages can be served in parallel. 
7. Any beverage can be served only if all the ingredients are available in terms of quantity. 
8. There would be an indicator which would show which all ingredients are running low. We need some methods to refill them. 
9. Please provide functional integration test cases for maximum coverage. 

    **Example:** 
    Consider Chai Point machine which serves these drinks: 
    1. ginger tea 
    2. elaichi tea 
    3. coffee 
    4. hot milk 
    5. hot water 
    
    The machine has N outlets for serving these drinks 
    Here is the composition for each drink: 1. ginger tea: 
- hot water 50 ml - hot milk 10 ml - tea leaves syrup 10 ml - ginger syrup 5 ml - sugar syrup 10 ml 2. elaichi tea: 
- hot water 50 ml - hot milk 10 ml - tea leaves syrup 10 ml - elaichi syrup 5 ml - sugar syrup 10 ml 3. coffee: 
- hot water 50 ml - hot milk 10 ml - coffee syrup 10 ml - sugar syrup 10 ml 4. hot milk: 
- milk 50 ml 5. hot water 
- water 50 ml 

**Note:** _`Since there are N outlets, N people can take beverages at the same time._ `

**Input Test Json :-** https://www.npoint.io/docs/e8cd5a9bbd1331de326a Expected Output :- This input can have multiple output based on the processes priority 
**Output** 
- hot_tea is prepared 
- hot_coffee is prepared 
- green_tea cannot be prepared because green_mixture is not available 
- black_tea cannot be prepared because item hot_water is 0 

**Output 2** 
- hot_tea is prepared 
- black_tea is prepared 
- green_tea cannot be prepared because green_mixture is not available 
- hot_coffee cannot be prepared because item hot_water is 0 

**Output 3** 
- hot_coffee is prepared 
- black_tea is prepared 
- green_tea cannot be prepared because green_mixture is not available 
- hot_tea cannot be prepared because item hot_water is 0 

###Scoring Criteria / Expectation 

• To simplify the problem – we will exclude the following issues from the scope:  
 The solution does not have to scale out. We only need to design 
 a solution to run on a single machine. 
    ▪ This machine can be assumed to have access to large high performance and reliable file systems to store the objects in. 
    ▪ This machine can be assumed to have multiple CPUs o The solution does not have to solve storage reliability issues 
    (assume that the underlying file system is reliable). 
• Please don’t expose any API, we need a functional test case. 

###Submission : 
1. Please submit the working code. We will be running test cases 
provided by you. 
2. Express the design/algorithm as part of the comment blocks around the 
code. Please take care of the readability part of it. 
3. We are looking for the following: 
    a. Good design (an efficient, correct, and simple way to solve this problem). 
    b. Correct implementation of the design. 
4. You can choose any languages you are comfortable in. 
5. Total Duration for the assignment is 2 hours and 30 mins. Try to give 30mins for functional integration test cases. 

Good Luck 
