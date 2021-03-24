You can use this app to check names:
- Only first token of name is checked
    http://localhost:8080/check?firstNameOnly=<hear give your names>
Example: female tokens list = [“Maria”], male tokenslist = [“Jan”]. Givenname “Jan Maria Rokita”, algorithm concludes “MALE”gender, becauseonly Jan is checked
- All tokens are checked and majority rule is used
    http://localhost:8080/check?allNames=<hear give your names>
Example: female tokens list =  [“Maria”],  male tokenslist =  [“Jan”]. Giventhe name “Jan Maria Rokita”, the algorithm respondswith“INCONCLUSIVE”. Jan is in male tokens list, Mariais in the female tokenslist and Rokita is not found. Therefore no unambiguousconclusion couldbe found.
Example: female tokens list = [“Anna”, “Gertruda”],male tokens list =[“Zbigniew”]. Given name: “Anna Zbigniew Gertruda”algorithm respondswith Female guessed gender, because 2 tokens for female> 1 token formale.

You can get list all tocken names:
- you can get male name, if you wrote:
    http://localhost:8080/names?type=male
- you can get female name, if you wrote:
    http://localhost:8080/names?type=female
- if you wrote something else, you get both

