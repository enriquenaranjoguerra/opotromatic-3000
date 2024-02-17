# area-calculator
This app is being developed to support a board game.

In this game, there are several places to investigate along some cities. Each of these places has a numeric value. From all the 32 places, only a few will be revealed during the gameplay. The critical city will be the one with the highest value once all cards values have been added. If two cities have the same sum, the city with the place with higher value will be the critical city.

For example, in a game they are revealed 5 cards corresponding two of them of values 1 and 3 to city A, two of them with values 2 and 4 to city B and the last one of value 5 corresponding to city C. This app will tell us that the value of city A is 1 + 3 = 4, the value of city B is 2 + 4 = 6 and the value of city C is 5. So B has the highest value, which is 6, and thus is the critical city.

In another game, city A has two cards of values 1 and 4, B has also two cards of values 2 and 3 and C has again one card of value 5. All cities have value 5, but city C has the card with the highest value, which is also 5. So city C is the critical city.